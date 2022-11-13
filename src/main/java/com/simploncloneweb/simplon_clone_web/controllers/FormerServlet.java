package com.simploncloneweb.simplon_clone_web.controllers;

import com.simploncloneweb.simplon_clone_web.entities.FormersEntity;
import com.simploncloneweb.simplon_clone_web.entities.LearnersEntity;
import com.simploncloneweb.simplon_clone_web.entities.PromosEntity;
import com.simploncloneweb.simplon_clone_web.services.FormerService;
import com.simploncloneweb.simplon_clone_web.services.LearnerService;
import com.simploncloneweb.simplon_clone_web.services.PromoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({ "/former/learners","/former/learner/assign","/admin/briefs"})
public class FormerServlet extends HttpServlet {

    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        mappingGet(request,response, session);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        mappingPost(request,response,session);
    }
    private void mappingGet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String path = request.getServletPath()!=null?request.getServletPath():"";
        switch (path){
            case "/former/learners" ->{
                getLearners(request, response,session);
            }
        }
    }
    private void mappingPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String path = request.getServletPath()!=null?request.getServletPath():"";

    }

    private static void getLearners(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        int idFormer = (int) session.getAttribute("id");
        PromosEntity promo = new PromoService().getByFormerId(idFormer);
        List<LearnersEntity> learners = new LearnerService().getAll();
        request.setAttribute("promo",promo);
        request.setAttribute("learner",learners);
        request.getRequestDispatcher("/former/views/learners.jsp").forward(request, response);
    }
    private static void getFormers(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        List<FormersEntity> formers = new FormerService().getAll();
        List<PromosEntity> promos = new PromoService().getAll();
        request.setAttribute("formers",formers);
        request.setAttribute("promos",promos);
        request.getRequestDispatcher("/admin/views/formers.jsp").forward(request, response);
    }
}
