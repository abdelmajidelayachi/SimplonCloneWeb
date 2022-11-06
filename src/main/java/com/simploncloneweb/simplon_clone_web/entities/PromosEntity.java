package com.simploncloneweb.simplon_clone_web.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "promos", schema = "public", catalog = "simplon_web")
public class PromosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_promo")
    private int idPromo;
    @Basic
    @Column(name = "promo_name")
    private String promoName;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "campus")
    private String campus;
    @Basic(optional = false)
    @Column(name = "created_at",updatable = false,insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;
    @Basic
    @Column(name = "former_id")
    private Integer formerId;

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFormerId() {
        return formerId;
    }

    public void setFormerId(Integer formerId) {
        this.formerId = formerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromosEntity that = (PromosEntity) o;

        if (idPromo != that.idPromo) return false;
        if (promoName != null ? !promoName.equals(that.promoName) : that.promoName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (campus != null ? !campus.equals(that.campus) : that.campus != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (formerId != null ? !formerId.equals(that.formerId) : that.formerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPromo;
        result = 31 * result + (promoName != null ? promoName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (formerId != null ? formerId.hashCode() : 0);
        return result;
    }
}
