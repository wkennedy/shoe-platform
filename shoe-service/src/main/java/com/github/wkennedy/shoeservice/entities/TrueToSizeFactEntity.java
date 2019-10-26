package com.github.wkennedy.shoeservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "true_to_size_fact", catalog = "shoe_db")
public class TrueToSizeFactEntity {
    private int id;
    private short trueToSize;
    private DateDimEntity dateDimByDateDim;
    private ShoeDimEntity shoeDimByShoeDim;
    private ShoeSizeDimEntity shoeSizeDimByShoeSizeDim;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "true_to_size")
    public short getTrueToSize() {
        return trueToSize;
    }

    public void setTrueToSize(short trueToSize) {
        this.trueToSize = trueToSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrueToSizeFactEntity that = (TrueToSizeFactEntity) o;

        if (id != that.id) return false;
        if (trueToSize != that.trueToSize) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) trueToSize;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "date_dim", referencedColumnName = "date_dim_id", nullable = false)
    public DateDimEntity getDateDimByDateDim() {
        return dateDimByDateDim;
    }

    public void setDateDimByDateDim(DateDimEntity dateDimByDateDim) {
        this.dateDimByDateDim = dateDimByDateDim;
    }

    @ManyToOne
    @JoinColumn(name = "shoe_dim", referencedColumnName = "ID", nullable = false)
    public ShoeDimEntity getShoeDimByShoeDim() {
        return shoeDimByShoeDim;
    }

    public void setShoeDimByShoeDim(ShoeDimEntity shoeDimByShoeDim) {
        this.shoeDimByShoeDim = shoeDimByShoeDim;
    }

    @ManyToOne
    @JoinColumn(name = "shoe_size_dim", referencedColumnName = "ID")
    public ShoeSizeDimEntity getShoeSizeDimByShoeSizeDim() {
        return shoeSizeDimByShoeSizeDim;
    }

    public void setShoeSizeDimByShoeSizeDim(ShoeSizeDimEntity shoeSizeDimByShoeSizeDim) {
        this.shoeSizeDimByShoeSizeDim = shoeSizeDimByShoeSizeDim;
    }
}
