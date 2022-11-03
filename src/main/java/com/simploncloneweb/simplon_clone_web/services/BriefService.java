package com.simploncloneweb.simplon_clone_web.services;

import com.simploncloneweb.simplon_clone_web.DAO.GenericDOAImpl;
import com.simploncloneweb.simplon_clone_web.entities.BriefsEntity;

import java.sql.Date;
import java.util.List;

public class BriefService {
    public List<BriefsEntity> getAll(){
        GenericDOAImpl<BriefsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.getAll(BriefsEntity.class);
    }

    public BriefsEntity getById(int id){
        GenericDOAImpl<BriefsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.get(BriefsEntity.class,id);
    }

    public boolean add(String briefName, String context, Date startDate, Date endDate, String criteria, String tag, int promoId){
        BriefsEntity newBrief = new BriefsEntity();
        newBrief.setBriefName(briefName);
        newBrief.setContext(context);
        newBrief.setStartDate(startDate);
        newBrief.setEndDate(endDate);
        newBrief.setCriteria(criteria);
        newBrief.setTags(tag);
        newBrief.setPromoId(promoId);
        GenericDOAImpl<BriefsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.save(newBrief);
    }

    public boolean edit(String briefName, String context, Date startDate, Date endDate, String criteria, String tag, int promoId,int id){
        BriefsEntity brief = new BriefsEntity();
        brief.setBriefName(briefName);
        brief.setContext(context);
        brief.setStartDate(startDate);
        brief.setEndDate(endDate);
        brief.setCriteria(criteria);
        brief.setTags(tag);
        brief.setPromoId(promoId);
        GenericDOAImpl<BriefsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.update(brief);
    }

    public boolean deleteById(int id){
        GenericDOAImpl<BriefsEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.deleteId(BriefsEntity.class,id);
    }

}
