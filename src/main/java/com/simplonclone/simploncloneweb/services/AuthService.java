package com.simplonclone.simploncloneweb.services;

import com.simplonclone.simploncloneweb.DAO.GenericDOAImpl;
import com.simplonclone.simploncloneweb.entity.AdminsEntity;

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
}
