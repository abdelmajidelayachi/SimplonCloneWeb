package com.simploncloneweb.simplon_clone_web.services;

import com.simploncloneweb.simplon_clone_web.DAO.GenericDOAImpl;
import com.simploncloneweb.simplon_clone_web.entities.FormersEntity;

import java.util.List;

public class FormerService {

    public List<FormersEntity> getAll(){
        GenericDOAImpl<FormersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.getAll(FormersEntity.class);
    }

    public FormersEntity getById(int id){
        GenericDOAImpl<FormersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.get(FormersEntity.class,id);
    }

    public boolean add(String firstname, String lastname, String email, String password){
        FormersEntity newFormer = new FormersEntity();
        newFormer.setFirstName(firstname);
        newFormer.setLastName(lastname);
        newFormer.setEmail(email);
        newFormer.setPassword(password);
        GenericDOAImpl<FormersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.save(newFormer);
    }

    public boolean edit(String firstname, String lastname, String email, String password,int id){
        FormersEntity former = new FormersEntity();
        former.setIdFormer(id);
        former.setFirstName(firstname);
        former.setLastName(lastname);
        former.setEmail(email);
        former.setPassword(password);
        GenericDOAImpl<FormersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.update(former);
    }

    public boolean deleteById(int id){
        GenericDOAImpl<FormersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.deleteId(FormersEntity.class,id);
    }
}
