package com.simploncloneweb.simplon_clone_web.controllers;

import com.simploncloneweb.simplon_clone_web.entities.FormersEntity;
import com.simploncloneweb.simplon_clone_web.entities.LearnersEntity;
import com.simploncloneweb.simplon_clone_web.entities.PromosEntity;
import com.simploncloneweb.simplon_clone_web.services.FormerService;
import com.simploncloneweb.simplon_clone_web.services.LearnerService;
import com.simploncloneweb.simplon_clone_web.services.PromoService;
import com.simploncloneweb.simplon_clone_web.util.Parser;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet({ "/admin/formers","/admin/former/add","/admin/former/update","/admin/former/assign","/admin/former/delete","/admin/learners","/admin/learner/add","/admin/learner/update","/admin/learner/delete", "/admin/promos","/admin/promo/add","/admin/promo/update","/admin/promo/assign","/admin/promo/delete"})
public class AdminServlet extends HttpServlet {
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
            case "/admin/formers" ->{
                getFormers(request, response,session);
            }
            case "/admin/former/delete" ->{
                deleteFormer(request, response,session);
            }
            case "/admin/learners" ->{
                getLearners(request, response,session);
            }
            case "/admin/learner/delete" ->{
                deleteLearner(request, response,session);
            }
            case "/admin/promos" ->{
                getPromos(request, response,session);
            }
            case "/admin/promo/delete" ->{
                deletePromo(request, response,session);
            }
        }
    }
    private void mappingPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String path = request.getServletPath()!=null?request.getServletPath():"";
        switch (path){
            case "/admin/former/add" ->{
                addFormer(request, response,session);
            }
            case "/admin/former/update" ->{
                updateFormer(request, response,session);
            }
            case "/admin/former/assign" ->{
                assignFormer(request, response,session,"formers");
            }
            case "/admin/learner/add" ->{
                addLearner(request, response,session);
            }
            case "/admin/learner/update" ->{
                updateLearner(request, response,session);
            }
            case "/admin/promo/add" ->{
                addPromo(request, response,session);
            }
            case "/admin/promo/update" ->{
                updatePromo(request, response,session);
            }
            case "/admin/promo/assign" ->{
                assignFormer(request, response,session,"promos");
            }

        }
    }

    private static void getFormers(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        List<FormersEntity> formers = new FormerService().getAll();
        List<PromosEntity> promos = new PromoService().getAll();
        request.setAttribute("formers",formers);
        request.setAttribute("promos",promos);
        request.getRequestDispatcher("/admin/views/formers.jsp").forward(request, response);
    }

    private static void deleteFormer(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        if (request.getParameter("idFormer") != null) {
            int id = Parser.parseInt(request.getParameter("idFormer"));
            if (id != -1){
                FormerService formerService = new FormerService();
                if (formerService.deleteById(id)){
                    session.setAttribute("success", "Former deleted successfully!");
                    response.sendRedirect("/admin/formers");
                }else {
                    session.setAttribute("error", "Former doesn't exist");
                    response.sendRedirect("/admin/formers");
                }
            }else{
                session.setAttribute("error", "Former doesn't exist");
                response.sendRedirect("/admin/formers");
            }
        }else {
            session.setAttribute("error", "Something went wrong!");
            response.sendRedirect("/admin/formers");
        }
    }

    private static void addFormer(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        if (request.getParameter("firstname") != null && request.getParameter("lastname") != null && request.getParameter("email") != null ){
            String firstname  = request.getParameter("firstname").trim();
            String lastname  = request.getParameter("lastname").trim();
            String email  = request.getParameter("email").trim();
            if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty()){
                String password = (firstname.charAt(0) + lastname).toLowerCase();
                FormerService formerService = new FormerService();
                if(formerService.add(firstname, lastname, email, password)){
                    session.setAttribute("success","Former added successfully!");
                    response.sendRedirect("/admin/formers");
                }else{
                    session.setAttribute("error","fill all input correctly!");
                    response.sendRedirect("/admin/formers");
                }
            }else{
                session.setAttribute("error","Former doesn't exist!");
                response.sendRedirect("/admin/formers");
            }
        }else{
            session.setAttribute("error","Former doesn't exist!");
            response.sendRedirect("/admin/formers");
        }
    }

    private static void updateFormer(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        if (request.getParameter("firstname") != null && request.getParameter("lastname") != null && request.getParameter("email") != null && request.getParameter("id") != null){
            String id  = request.getParameter("id").trim();
            String firstname  = request.getParameter("firstname").trim();
            String lastname  = request.getParameter("lastname").trim();
            String email  = request.getParameter("email").trim();
            if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && !id.isEmpty()){
                String password = (firstname.charAt(0) + lastname).toLowerCase();
                FormerService formerService = new FormerService();
                if(Parser.parseInt(id) == -1){
                    response.sendRedirect("/admin/formers");
                }else if(formerService.edit(firstname, lastname, email, password, Integer.parseInt(id)))
                {
                    session.setAttribute("success","Former updated successfully");
                    response.sendRedirect("/admin/formers");
                }else{
                    session.setAttribute("error","Former doesn't exist!");
                    response.sendRedirect("/admin/formers");
                }
            }else{
                session.setAttribute("error","Fill all input correctly!");
                response.sendRedirect("/admin/formers");
            }
        }else{
            session.setAttribute("error","Fill all input correctly!");
            response.sendRedirect("/admin/formers");
        }
    }
    private static void assignFormer(HttpServletRequest request, HttpServletResponse response, HttpSession session, String path) throws IOException {
        if ( request.getParameter("formerId") != null && request.getParameter("id") != null){
            String id  = request.getParameter("id").trim();
            String formerId  = request.getParameter("formerId").trim();
            if(!formerId.isEmpty() && !id.isEmpty()){
                PromoService promoService = new PromoService();
                if(Parser.parseInt(id) == -1 || Parser.parseInt(formerId) == -1 ){
                    response.sendRedirect("/admin/" + path);
                }
                PromosEntity promo = promoService.getById(Parser.parseInt(id));
                if(promoService.edit(promo.getPromoName(),promo.getCampus(),promo.getDescription(),Integer.parseInt(formerId), Integer.parseInt(id)))
                {
                    session.setAttribute("success","Former assigned successfully");
                    response.sendRedirect("/admin/"+ path);
                }else{
                    session.setAttribute("error","Former doesn't exist!");
                    response.sendRedirect("/admin/" + path);
                }
            }else{
                session.setAttribute("error","Fill all input correctly!");
                response.sendRedirect("/admin/" + path);
            }
        }else{
            session.setAttribute("error","Fill all input correctly!");
            response.sendRedirect("/admin/" + path);
        }
    }
    private static void getLearners(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        List<LearnersEntity> learners = new LearnerService().getAll();
        List<PromosEntity> promos = new PromoService().getAll();
        request.setAttribute("learners",learners);
        request.setAttribute("promos",promos);
        request.getRequestDispatcher("/admin/views/learners.jsp").forward(request, response);
    }

    private static void deleteLearner(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println(request.getParameter("idLearner"));
        if (request.getParameter("idLearner") != null) {
            int id = Parser.parseInt(request.getParameter("idLearner"));
            if (id != -1){
                LearnerService learnerService = new LearnerService();
                if (learnerService.deleteById(id)){
                    session.setAttribute("success", "Learner deleted successfully!");
                    response.sendRedirect("/admin/learners");
                }else{
                    session.setAttribute("error", "Something went wrong!");
                    response.sendRedirect("/admin/learners");
                }
            }else{
                session.setAttribute("error", "Learner doesn't exist");
                response.sendRedirect("/admin/learners");
            }
        }else{
            session.setAttribute("error", "Learner doesn't exist");
            response.sendRedirect("/admin/learners");
        }
    }

    private static void addLearner(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        if (request.getParameter("firstname") != null && request.getParameter("lastname") != null && request.getParameter("email") != null ){
            String firstname  = request.getParameter("firstname").trim();
            String lastname  = request.getParameter("lastname").trim();
            String email  = request.getParameter("email").trim();
            if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty()){
                String password = (firstname.charAt(0) + lastname).toLowerCase();
                LearnerService learnerService = new LearnerService();
                if(learnerService.add(firstname, lastname, email, password)) {
                    session.setAttribute("success","Learner added successfully");
                    response.sendRedirect("/admin/learners");
                }else{
                    session.setAttribute("error","Something went wrong!");
                    response.sendRedirect("/admin/learners");
                }
            }else{
                session.setAttribute("error","Fill all input!");
                response.sendRedirect("/admin/learners");
            }
        }else{
            session.setAttribute("error","Something went wrong!");
            response.sendRedirect("/admin/learners");
        }
    }
    private static void updateLearner(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        if (request.getParameter("firstname") != null && request.getParameter("lastname") != null && request.getParameter("email") != null && request.getParameter("id") != null){
            String id  = request.getParameter("id").trim();
            String firstname  = request.getParameter("firstname").trim();
            String lastname  = request.getParameter("lastname").trim();
            String email  = request.getParameter("email").trim();
            if(!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && !id.isEmpty()){
                String password = (firstname.charAt(0) + lastname).toLowerCase();
                LearnerService learnerService = new LearnerService();
                if(Parser.parseInt(id) == -1){
                    response.sendRedirect("/admin/learners");
                }else if(learnerService.edit(firstname, lastname, email, password, Integer.parseInt(id)))
                {
                    response.sendRedirect("/admin/learners");
                }else{
                    session.setAttribute("error","Something went wrong!");
                    response.sendRedirect("/admin/learners");

                }
            }else{
                session.setAttribute("error","Fill Input correctly!");
                response.sendRedirect("/admin/learners");
            }
        }else{
            session.setAttribute("error","Something went wrong!");
            response.sendRedirect("/admin/learners");
        }
    }



    private static void getPromos(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        List<FormersEntity> formers = new FormerService().getAll();
        List<LearnersEntity> learners = new LearnerService().getAll();
        List<PromosEntity> promos = new PromoService().getAll();
        request.setAttribute("learners",learners);
        request.setAttribute("formers",formers);
        request.setAttribute("promos",promos);
        request.getRequestDispatcher("/admin/views/promos.jsp").forward(request, response);
    }
    private static void deletePromo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println(request.getParameter("idPromo"));
        if (request.getParameter("idPromo") != null) {
            int id = Parser.parseInt(request.getParameter("idPromo"));
            System.out.println(id);
            if (id != -1){
                PromoService promoService = new PromoService();
                if (promoService.deleteById(id)){
                    session.setAttribute("success", "Promo deleted successfully!");
                    response.sendRedirect("/admin/promos");
                }else{
                    session.setAttribute("error", "Something went wrong!");
                    response.sendRedirect("/admin/promos");
                }
            }else{
                session.setAttribute("error", "Promo doesn't exist");
                response.sendRedirect("/admin/promos");
            }
        }else{
            session.setAttribute("error", "Promo doesn't exist");
            response.sendRedirect("/admin/promos");
        }
    }
    private static void addPromo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        if (request.getParameter("promo_name") != null && request.getParameter("description") != null && request.getParameter("campus") != null ){
            String promo_name  = request.getParameter("promo_name").trim();
            String description  = request.getParameter("description").trim();
            String campus  = request.getParameter("campus").trim();
            int formerId = -1;
            if(!promo_name.isEmpty() && !description.isEmpty() && !campus.isEmpty()){
                PromoService promoService = new PromoService();
                if(promoService.add(promo_name, campus, description, formerId)){
                    session.setAttribute("success", "Promo added  successfully!!");
                    response.sendRedirect("/admin/promos");
                }else{
                    session.setAttribute("error", "Something went wrong!");
                    response.sendRedirect("/admin/promos");
                }
            }else{
                session.setAttribute("error", "Fill all input correctly!");
                response.sendRedirect("/admin/promos");
            }
        }else{
            session.setAttribute("error", "Fill all input correctly!");
            response.sendRedirect("/admin/promos");
        }
    }
    private static void updatePromo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        if (request.getParameter("promo_name") != null && request.getParameter("description") != null && request.getParameter("campus") != null && request.getParameter("id") != null){
            String promo_name  = request.getParameter("promo_name").trim();
            String description  = request.getParameter("description").trim();
            String campus  = request.getParameter("campus").trim();
            int id = Parser.parseInt(request.getParameter("id"));
            int formerId = -1;
            if(id == -1){
                response.sendRedirect("/admin/promos");
            }else  if(!promo_name.isEmpty() && !description.isEmpty() && !campus.isEmpty()){
                PromoService promoService = new PromoService();
                if(promoService.edit(promo_name, campus, description, formerId,id)) {
                    session.setAttribute("success", "Promo updated successfully!");
                    response.sendRedirect("/admin/promos");
                }else{
                    session.setAttribute("error", "Something went wrong!");
                    response.sendRedirect("/admin/promos");
                }
            }else{
                session.setAttribute("error", "Fill  all input correctly!");
                response.sendRedirect("/admin/promos");
            }
        }else{
            session.setAttribute("error", "Fill all input correctly!");
            response.sendRedirect("/admin/promos");
        }
    }

}
