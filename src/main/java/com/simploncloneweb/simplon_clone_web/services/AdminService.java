package com.simploncloneweb.simplon_clone_web.services;

import com.simploncloneweb.simplon_clone_web.DAO.GenericDOAImpl;
import com.simploncloneweb.simplon_clone_web.entities.AdminsEntity;

import java.util.List;

public class AdminService {

    public List<AdminsEntity> getAll(){
        GenericDOAImpl<AdminsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.getAll(AdminsEntity.class);
    }

    public AdminsEntity getById(int id){
        GenericDOAImpl<AdminsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.get(AdminsEntity.class,id);
    }

    public boolean add(String firstname, String lastname, String email, String password){
        AdminsEntity newAdmin = new AdminsEntity();
        newAdmin.setFirstName(firstname);
        newAdmin.setLastName(lastname);
        newAdmin.setEmail(email);
        newAdmin.setPassword(password);
        GenericDOAImpl<AdminsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.save(newAdmin);
    }

    public boolean edit(String firstname, String lastname, String email, String password,int id){
        AdminsEntity admin = new AdminsEntity();
        admin.setIdAdmin(id);
        admin.setFirstName(firstname);
        admin.setLastName(lastname);
        admin.setEmail(email);
        admin.setPassword(password);
        GenericDOAImpl<AdminsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.update(admin);
    }

    public boolean deleteById(int id){
        GenericDOAImpl<AdminsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.deleteId(AdminsEntity.class,id);
    }

}
