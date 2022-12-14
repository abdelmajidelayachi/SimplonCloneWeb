package com.simploncloneweb.simplon_clone_web.services;

import com.simploncloneweb.simplon_clone_web.DAO.GenericDOAImpl;
import com.simploncloneweb.simplon_clone_web.entities.FormersEntity;
import com.simploncloneweb.simplon_clone_web.entities.PromosEntity;

import java.util.HashMap;
import java.util.List;

public class PromoService {
    public List<PromosEntity> getAll(){
        GenericDOAImpl<PromosEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.getAll(PromosEntity.class);
    }

    public PromosEntity getById(int id){
        GenericDOAImpl<PromosEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.get(PromosEntity.class,id);
    }
    public PromosEntity getByFormerId(int id){
        GenericDOAImpl<PromosEntity> promoEntityGenericDOA = new GenericDOAImpl<>();
        String jpaQuery = "SELECT a FROM PromosEntity a WHERE a.formerId = ?1" ;
        HashMap<String , Object> params = new HashMap<>();
        params.put("formerId",id);
        List<PromosEntity> promo  = promoEntityGenericDOA.query(PromosEntity.class, jpaQuery, params);
        return promo != null ? promo.get(0): null;
    }

    public boolean add(String promoName, String campus, String description, int formerId){
        PromosEntity newPromo = new PromosEntity();
        newPromo.setPromoName(promoName);
        newPromo.setCampus(campus);
        newPromo.setDescription(description);
        if (formerId != -1) {
            newPromo.setFormerId(formerId);
        }
        GenericDOAImpl<PromosEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.save(newPromo);
    }

    public boolean edit(String promoName, String campus, String description, int formerId,int id){
        PromosEntity promo = new PromosEntity();
        promo.setIdPromo(id);
        if (promoName != null) {
            promo.setPromoName(promoName);
        }
        if (campus != null) {
            promo.setCampus(campus);
        }
        if (description != null){
            promo.setDescription(description);
        }
        if (formerId != -1) {
            promo.setFormerId(formerId);
        }
        GenericDOAImpl<PromosEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.update(promo);
    }

    public boolean deleteById(int id){
        GenericDOAImpl<PromosEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.deleteId(PromosEntity.class,id);
    }

}
