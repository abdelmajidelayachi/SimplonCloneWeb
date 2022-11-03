package com.simploncloneweb.simplon_clone_web.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class PromostolearnersEntityPK implements Serializable {
    @Column(name = "promo_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promoId;
    @Column(name = "learner_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int learnerId;

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public int getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(int learnerId) {
        this.learnerId = learnerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromostolearnersEntityPK that = (PromostolearnersEntityPK) o;

        if (promoId != that.promoId) return false;
        if (learnerId != that.learnerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = promoId;
        result = 31 * result + learnerId;
        return result;
    }
}
