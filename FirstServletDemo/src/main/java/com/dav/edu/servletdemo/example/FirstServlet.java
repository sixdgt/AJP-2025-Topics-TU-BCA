package com.dav.edu.servletdemo.example;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet implements Servlet{
    ServletConfig sc;
    @Override
    public void init(ServletConfig sc) throws ServletException {
        System.out.println("Servlet is running..");
        this.sc = sc;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.sc;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        // setting content type
        res.setContentType("text/html");
        // to display html tag or element or any content
        out.println("<!DOCTYPE html><head><title>Servlet Demo</title></head><body>");
        out.println("<div><h1>This is our first Servlet Program</h1></div>");
        out.println("</body></html>");
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "First Servlet Program";
    }

    @Override
    public void destroy() {
    }
    
}
