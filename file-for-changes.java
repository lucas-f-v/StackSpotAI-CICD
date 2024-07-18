import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VulnerableClass extends HttpServlet {
    // Hardcoded credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        // SQL Injection vulnerability
        String query = "SELECT * FROM users WHERE username = '" + user + "' AND password = '" + pass + "'";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                response.getWriter().println("Login successful!");
            } else {
                response.getWriter().println("Invalid credentials.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Insecure deserialization
        try (ObjectInputStream ois = new ObjectInputStream(request.getInputStream())) {
            Object obj = ois.readObject();
            // Process the deserialized object
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Cross-Site Scripting (XSS) vulnerability
        String message = request.getParameter("message");
        response.getWriter().println("User message: " + message);
    }
}
