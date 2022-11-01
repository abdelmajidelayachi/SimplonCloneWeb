package com.simplonclone.simploncloneweb.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "briefs", schema = "public", catalog = "simplon_web")
public class BriefsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_brief")
    private int idBrief;
    @Basic
    @Column(name = "brief_name")
    private String briefName;
    @Basic
    @Column(name = "tags")
    private String tags;
    @Basic
    @Column(name = "context")
    private String context;
    @Basic
    @Column(name = "criteria")
    private String criteria;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "promo_id")
    private Integer promoId;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    public int getIdBrief() {
        return idBrief;
    }

    public void setIdBrief(int idBrief) {
        this.idBrief = idBrief;
    }

    public String getBriefName() {
        return briefName;
    }

    public void setBriefName(String briefName) {
        this.briefName = briefName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BriefsEntity that = (BriefsEntity) o;

        if (idBrief != that.idBrief) return false;
        if (briefName != null ? !briefName.equals(that.briefName) : that.briefName != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (context != null ? !context.equals(that.context) : that.context != null) return false;
        if (criteria != null ? !criteria.equals(that.criteria) : that.criteria != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (promoId != null ? !promoId.equals(that.promoId) : that.promoId != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBrief;
        result = 31 * result + (briefName != null ? briefName.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (criteria != null ? criteria.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (promoId != null ? promoId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
