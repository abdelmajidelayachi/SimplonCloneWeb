package com.simploncloneweb.simplon_clone_web.services;

import com.simploncloneweb.simplon_clone_web.DAO.GenericDOAImpl;
import com.simploncloneweb.simplon_clone_web.entities.LearnersEntity;

import java.util.List;

public class LearnerService {

    public List<LearnersEntity> getAll(){
        GenericDOAImpl<LearnersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.getAll(LearnersEntity.class);
    }

    public LearnersEntity getById(int id){
        GenericDOAImpl<LearnersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.get(LearnersEntity.class,id);
    }

    public boolean add(String firstname, String lastname, String email, String password){
        LearnersEntity newLearner = new LearnersEntity();
        newLearner.setFirstName(firstname);
        newLearner.setLastName(lastname);
        newLearner.setEmail(email);
        newLearner.setPassword(password);
        GenericDOAImpl<LearnersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.save(newLearner);
    }

    public boolean edit(String firstname, String lastname, String email, String password,int id){
        LearnersEntity learner = new LearnersEntity();
        learner.setIdLearner(id);
        learner.setFirstName(firstname);
        learner.setLastName(lastname);
        learner.setEmail(email);
        learner.setPassword(password);
        GenericDOAImpl<LearnersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.update(learner);
    }

    public boolean deleteById(int id){
        GenericDOAImpl<LearnersEntity> genericDOA = new GenericDOAImpl<>();
        return genericDOA.deleteId(LearnersEntity.class,id);
    }
}
