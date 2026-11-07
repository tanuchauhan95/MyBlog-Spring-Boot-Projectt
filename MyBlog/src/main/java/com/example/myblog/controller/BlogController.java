package com.example.myblog.controller;

import com.example.myblog.model.Blog;
import com.example.myblog.repository.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    private final BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "add-blog";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog,
                           RedirectAttributes redirectAttributes) {
        blogRepository.save(blog);
        redirectAttributes.addFlashAttribute("message", "Your blog was published!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog == null) {
            return "redirect:/";
        }
        model.addAttribute("blog", blog);
        return "view-blog";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id,
                             RedirectAttributes redirectAttributes) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Blog deleted.");
        }
        return "redirect:/";
    }
}
