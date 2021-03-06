package com.github.wkennedy.shoeservice.models;

import java.util.Objects;

public class Shoe {
    private String brand;
    private String model;
    private Double trueToSizeAvg;
    private String trueToSizeDescription;

    public Shoe() {
    }

    public Shoe(String brand, String model, Double trueToSizeAvg) {
        this.brand = brand;
        this.model = model;
        this.trueToSizeAvg = trueToSizeAvg;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getTrueToSizeAvg() {
        return trueToSizeAvg;
    }

    public void setTrueToSizeAvg(Double trueToSizeAvg) {
        this.trueToSizeAvg = trueToSizeAvg;
    }

    public String getTrueToSizeDescription() {
        return trueToSizeDescription;
    }

    public void setTrueToSizeDescription(String trueToSizeDescription) {
        this.trueToSizeDescription = trueToSizeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoe shoe = (Shoe) o;
        return Objects.equals(brand, shoe.brand) &&
                Objects.equals(model, shoe.model) &&
                Objects.equals(trueToSizeAvg, shoe.trueToSizeAvg) &&
                Objects.equals(trueToSizeDescription, shoe.trueToSizeDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, trueToSizeAvg, trueToSizeDescription);
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", trueToSizeAvg=" + trueToSizeAvg +
                ", trueToSizeDescription='" + trueToSizeDescription + '\'' +
                '}';
    }
}
