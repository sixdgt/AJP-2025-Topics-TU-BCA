package com.dav.edu.servletdemo.example;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GenericServletExample extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<!DOCTYPE html><head><title>GenericServlet Example</title></head><body>");
        out.println("<div><h1>This is a simple demostration of GenericServlet</h1></div>");
        out.println("</body></html>");
        out.close();
    }
    
}
