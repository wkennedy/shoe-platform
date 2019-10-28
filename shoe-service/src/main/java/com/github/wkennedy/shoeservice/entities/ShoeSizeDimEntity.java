package com.github.wkennedy.shoeservice.entities;

import com.github.wkennedy.shoeservice.models.Sex;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "shoe_size_dim")
public class ShoeSizeDimEntity {
    private int id;
    private Sex sex;
    private Float us;
    private Float inches;
    private Float centimeters;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "us")
    public Float getUs() {
        return us;
    }

    public void setUs(Float us) {
        this.us = us;
    }

    @Basic
    @Column(name = "inches")
    public Float getInches() {
        return inches;
    }

    public void setInches(Float inches) {
        this.inches = inches;
    }

    @Basic
    @Column(name = "centimeters")
    public Float getCentimeters() {
        return centimeters;
    }

    public void setCentimeters(Float centimeters) {
        this.centimeters = centimeters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoeSizeDimEntity that = (ShoeSizeDimEntity) o;

        if (id != that.id) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (us != null ? !us.equals(that.us) : that.us != null) return false;
        if (inches != null ? !inches.equals(that.inches) : that.inches != null) return false;
        if (centimeters != null ? !centimeters.equals(that.centimeters) : that.centimeters != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (us != null ? us.hashCode() : 0);
        result = 31 * result + (inches != null ? inches.hashCode() : 0);
        result = 31 * result + (centimeters != null ? centimeters.hashCode() : 0);
        return result;
    }
}
