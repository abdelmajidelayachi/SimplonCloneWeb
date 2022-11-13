package com.simploncloneweb.simplon_clone_web.controllers;

import com.simploncloneweb.simplon_clone_web.entities.FormersEntity;
import com.simploncloneweb.simplon_clone_web.services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = { "/authentication","/admin/login","/former/login","/former/home","/logout"})
public class AuthServlet extends HttpServlet {
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        Mapping(request,response, session);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        Mapping(request,response, session);

    }

    private void Mapping(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException{
        String path = request.getServletPath();
            switch (path){
                case "/former/login"->{
                    if (session.getAttribute("id") == null || session.getAttribute("role") == null) {
                        request.getRequestDispatcher("/auth/formerAuth.jsp").forward(request, response);
                    }
                    checkLoginFormer(request, response, session);
                }
                case "/admin/login"->{
                    request.getRequestDispatcher("/auth/adminAuth.jsp").forward(request,response);
                }
                case "/authentication"->{
                    request.getRequestDispatcher("/auth/learnerAuth.jsp").forward(request,response);
                }
                case "/former/home"->{
                   checkLoginFormer(request, response, session);
                }
                case "/logout"->{
                   logout(request, response, session);
                }
            }
    }
    private void checkLoginFormer(HttpServletRequest request , HttpServletResponse response, HttpSession session) throws IOException{
        if (session.getAttribute("id") == null || session.getAttribute("role") == null) {
            if (request.getParameter("email") != null && request.getParameter("password") != null) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                AuthService authService = new AuthService();
                FormersEntity former = authService.loginFormer(email, password);
                if (former != null) {
                    session.setAttribute("role", "FORMER");
                    session.setAttribute("id", former.getIdFormer());
                    response.sendRedirect("/former/learners");
                }
            }
            response.sendRedirect("/former/login");
        }else if (session.getAttribute("role") == "FORMER") {
            response.sendRedirect("/former/learners");
        }else{
            response.sendRedirect("/former/login");
        }
    }
    private void logout(HttpServletRequest request , HttpServletResponse response, HttpSession session)throws IOException{
        session.invalidate();
        response.sendRedirect("/former/login");
    }
}
