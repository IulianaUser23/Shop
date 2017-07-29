package fasttrackit.shop.business.servlet;

import fasttrackit.shop.business.DbAccessProduct;
import fasttrackit.shop.business.Product;
import org.json.JSONObject;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("intra iin logcin ");

        // citeasca un user si o parola
        // si daca exista in combinata asta in db
        //atunci sa scrie pe sesiune ce trebe
        //altfel nu
        String u="ionel";
        String p = "anaaremere";

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if(u.equals(user) && p.equals(pwd)) {
            HttpSession s = request.getSession();
            s.setAttribute("isLoggedIn", "brrr");
        }



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
