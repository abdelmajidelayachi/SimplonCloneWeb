package com.simploncloneweb.simplon_clone_web.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "promostolearners", schema = "public", catalog = "simplon_web")
@IdClass(PromostolearnersEntityPK.class)
public class PromostolearnersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "promo_id")
    private int promoId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "learner_id")
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

        PromostolearnersEntity that = (PromostolearnersEntity) o;

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
