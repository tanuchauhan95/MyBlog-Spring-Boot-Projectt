# MyBlog - Spring Boot beginner project

A simple blog website with:
- Home page showing all blog posts
- Create/publish a blog
- Read a full blog post
- Delete a blog post
- Local file-based H2 database

## Requirements
- Java 17 or later
- Maven 3.6+ (or use the Maven wrapper if you add one)
- Internet connection on the first run so Maven can download dependencies

## Run in VS Code / IntelliJ
1. Extract `MyBlog.zip`.
2. Open the extracted `MyBlog` folder (the folder containing `pom.xml`).
3. Make sure Java 17+ and Maven are installed.
4. Open a terminal in that folder.
5. Run:

   ```bash
   mvn spring-boot:run
   ```

6. Open http://localhost:8080 in your browser.

## Pages
- Home: http://localhost:8080/
- Add a blog: http://localhost:8080/add
- H2 database console: http://localhost:8080/h2-console

For the H2 console, use:
- JDBC URL: `jdbc:h2:file:./data/blogdb`
- User Name: `sa`
- Password: leave blank

## Notes
- Blog posts are saved in the local `data` folder created when the application runs.
- The delete links use GET for simplicity in this beginner demo. For a production website, use a POST/DELETE request and add authentication/authorization.
- H2 console is enabled for local development only. Disable it before deploying publicly.
