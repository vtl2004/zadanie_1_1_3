package servlety;
import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlett extends HttpServlet{

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      List<User> userList = userService.findAllUsers();

        req.setAttribute("users", userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listusers.jsp");
        dispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User(name, age);
        if (name == null || age == 0){
            
        } else {
            try {
                userService.saveUser(user);
            } catch (Exception ignored) {}
            resp.sendRedirect("users");
        }

    }
}
