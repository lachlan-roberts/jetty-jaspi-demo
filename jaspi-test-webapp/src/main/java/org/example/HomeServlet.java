package org.example;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        Principal userPrincipal = request.getUserPrincipal();
        if (userPrincipal == null)
        {
            response.getWriter().println("<h1>UserPrincipal was null</h1>");
        }
        else
        {
            response.getWriter().println("<h1>Username: " + userPrincipal.getName() + "</h1>");
        }

    }
}