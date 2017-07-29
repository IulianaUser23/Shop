package fasttrackit.shop.business.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by icondor on 22/07/2017.
 */

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("/logout , here i do log out the user");




            HttpSession s = request.getSession();
            s.removeAttribute("isLoggedIn");




    }


    private void returnJsonResponse(HttpServletResponse response, String jsonResponse) {
        response.setContentType("application/json");
        PrintWriter pr = null;
        try {
            pr = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert pr != null;
        pr.write(jsonResponse);
        pr.close();
    }


    }
