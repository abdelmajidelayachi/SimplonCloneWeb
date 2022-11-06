package com.simploncloneweb.simplon_clone_web.controllers;

import com.simploncloneweb.simplon_clone_web.entities.FormersEntity;
import com.simploncloneweb.simplon_clone_web.entities.PromosEntity;
import com.simploncloneweb.simplon_clone_web.services.FormerService;
import com.simploncloneweb.simplon_clone_web.services.PromoService;
import com.simploncloneweb.simplon_clone_web.util.Parser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({ "/admin/formers","/admin/former/add","/admin/former/update","/admin/former/delete","/admin/learners", "/admin/promos"})
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       mappingGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       mappingPost(request,response);
    }

    private void mappingGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath()!=null?request.getServletPath():"";
        switch (path){
            case "/admin/formers" ->{
                getFormers(request, response);
            }
            case "/admin/former/delete" ->{
                deleteFormer(request, response);
            }
            case "/admin/learners" ->{
                getLearners(request, response);
            }
            case "/admin/promos" ->{
                getPromos(request, response);
            }
        }
    }
    private void mappingPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath()!=null?request.getServletPath():"";
        switch (path){
            case "/admin/former/add" ->{
                addFormer(request, response);
            }
            case "/admin/former/update" ->{
                updateFormer(request, response);
            }
            case "/admin/learner/add" ->{
                getLearners(request, response);
            }
            case "/admin/promo/add" ->{
                getPromos(request, response);
            }
        }
    }
    private static void getFormers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<FormersEntity> formers = new FormerService().getAll();
        List<PromosEntity> promos = new PromoService().getAll();
        request.setAttribute("formers",formers);
        request.setAttribute("promos",promos);
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }
    private static void deleteFormer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getParameter("idFormer") );
        if (request.getParameter("idFormer") != null) {
            int id = Parser.parseInt(request.getParameter("idFormer"));
            System.out.println(id);
            if (id != -1){
                FormerService formerService = new FormerService();
                if (formerService.deleteById(id)) response.sendRedirect("/admin/formers");
            }
        }
    }

    private static void addFormer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("firstname") != null && request.getParameter("lastname") != null && request.getParameter("email") != null ){
            String firstname  = request.getParameter("firstname").trim();
            String lastname  = request.getParameter("lastname").trim();
            String email  = request.getParameter("email").trim();
            if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty()){
                String password = (firstname.charAt(0) + lastname).toLowerCase();
                FormerService formerService = new FormerService();
                if(formerService.add(firstname, lastname, email, password)) response.sendRedirect("/admin/formers");
            }
        }
    }
    private static void updateFormer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("firstname") != null && request.getParameter("lastname") != null && request.getParameter("email") != null && request.getParameter("id") != null){
            String id  = request.getParameter("id").trim();
            System.out.println(id);
            String firstname  = request.getParameter("firstname").trim();
            System.out.println(firstname);
            String lastname  = request.getParameter("lastname").trim();
            System.out.println(lastname);
            String email  = request.getParameter("email").trim();
            System.out.println(email);
            if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && !id.isEmpty()){
                String password = (firstname.charAt(0) + lastname).toLowerCase();
                FormerService formerService = new FormerService();
                if(Parser.parseInt(id) == -1){
                    response.sendRedirect("/admin/formers");
                }else if(formerService.edit(firstname, lastname, email, password, Integer.parseInt(id)))
                {
                    response.sendRedirect("/admin/formers");
                }
            }
        }
    }

    private static void getLearners(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Hello  this is Learners</h1>");
        out.println("</body></html>");
    }
    private static void getPromos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Hello  this is promos</h1>");
        out.println("</body></html>");
    }
}
