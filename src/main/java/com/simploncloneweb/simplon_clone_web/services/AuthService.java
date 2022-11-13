package com.simploncloneweb.simplon_clone_web.services;


import com.simploncloneweb.simplon_clone_web.DAO.GenericDOAImpl;
import com.simploncloneweb.simplon_clone_web.entities.AdminsEntity;
import com.simploncloneweb.simplon_clone_web.entities.FormersEntity;

import java.util.HashMap;
import java.util.List;

public class AuthService {

    public boolean loginAdmin (String email, String password){
        GenericDOAImpl<AdminsEntity> adminsEntityGenericDOA = new GenericDOAImpl<>();
        String jpaQuery = "SELECT a FROM AdminsEntity a WHERE a.email = ? and a.password = ?" ;
        HashMap<String , Object> params = new HashMap<>();
        params.put("email",email);
        params.put("password",password);
        List<AdminsEntity> admin  = adminsEntityGenericDOA.query(AdminsEntity.class, jpaQuery, params);
        return admin.size() >= 1;

    }
    public FormersEntity loginFormer(String email, String password){
        GenericDOAImpl<FormersEntity> formersEntityGenericDOA = new GenericDOAImpl<>();
        String jpaQuery = "SELECT a FROM FormersEntity a WHERE a.email = ?1 and a.password = ?2" ;
        HashMap<String , Object> params = new HashMap<>();
        params.put("email",email);
        params.put("password",password);
        List<FormersEntity> former  = formersEntityGenericDOA.query(FormersEntity.class, jpaQuery, params);
        return former != null ? former.get(0): null;

    }
}
