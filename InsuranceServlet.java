package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/insurance")
public class InsuranceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");

        response.setContentType("text/html");
        
        if (type == null) {
            response.getWriter().println("<h2>No insurance selected</h2>");
            return;
        }

        String message = "";

        switch (type) {
            case "home":
                message = "Welcome to Home Insurance";
                break;
            case "health":
                message = "Welcome to Health Insurance";
                break;
            case "car":
                message = "Welcome to Car Insurance";
                break;
            case "life":
                message = "Welcome to Life Insurance";
                break;
            default:
                message = "Invalid selection";
        }

        response.getWriter().println(
            "<html><head><link rel='stylesheet' href='style.css'></head><body>" +
            "<h1>" + message + "</h1>" +
            "<a href='index.html'>Go Back</a>" +
            "</body></html>"
        );
    }
}
