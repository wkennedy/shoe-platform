package com.github.wkennedy.shoeservice.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "date_dim")
public class DateDimEntity {
    private int dateDimId;
    private Date dateActual;
    private long epoch;
    private String daySuffix;
    private String dayName;
    private int dayOfWeek;
    private int dayOfMonth;
    private int dayOfQuarter;
    private int dayOfYear;
    private int weekOfMonth;
    private int weekOfYear;
    private String weekOfYearIso;
    private int monthActual;
    private String monthName;
    private String monthNameAbbreviated;
    private int quarterActual;
    private String quarterName;
    private int yearActual;
    private Date firstDayOfWeek;
    private Date lastDayOfWeek;
    private Date firstDayOfMonth;
    private Date lastDayOfMonth;
    private Date firstDayOfQuarter;
    private Date lastDayOfQuarter;
    private Date firstDayOfYear;
    private Date lastDayOfYear;
    private String mmyyyy;
    private String mmddyyyy;
    private boolean weekendIndr;
    private Collection<TrueToSizeFactEntity> trueToSizeFactsByDateDimId;

    @Id
    @Column(name = "date_dim_id")
    public int getDateDimId() {
        return dateDimId;
    }

    public void setDateDimId(int dateDimId) {
        this.dateDimId = dateDimId;
    }

    @Basic
    @Column(name = "date_actual")
    public Date getDateActual() {
        return dateActual;
    }

    public void setDateActual(Date dateActual) {
        this.dateActual = dateActual;
    }

    @Basic
    @Column(name = "epoch")
    public long getEpoch() {
        return epoch;
    }

    public void setEpoch(long epoch) {
        this.epoch = epoch;
    }

    @Basic
    @Column(name = "day_suffix")
    public String getDaySuffix() {
        return daySuffix;
    }

    public void setDaySuffix(String daySuffix) {
        this.daySuffix = daySuffix;
    }

    @Basic
    @Column(name = "day_name")
    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @Basic
    @Column(name = "day_of_week")
    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Basic
    @Column(name = "day_of_month")
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Basic
    @Column(name = "day_of_quarter")
    public int getDayOfQuarter() {
        return dayOfQuarter;
    }

    public void setDayOfQuarter(int dayOfQuarter) {
        this.dayOfQuarter = dayOfQuarter;
    }

    @Basic
    @Column(name = "day_of_year")
    public int getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(int dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    @Basic
    @Column(name = "week_of_month")
    public int getWeekOfMonth() {
        return weekOfMonth;
    }

    public void setWeekOfMonth(int weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    @Basic
    @Column(name = "week_of_year")
    public int getWeekOfYear() {
        return weekOfYear;
    }

    public void setWeekOfYear(int weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    @Basic
    @Column(name = "week_of_year_iso")
    public String getWeekOfYearIso() {
        return weekOfYearIso;
    }

    public void setWeekOfYearIso(String weekOfYearIso) {
        this.weekOfYearIso = weekOfYearIso;
    }

    @Basic
    @Column(name = "month_actual")
    public int getMonthActual() {
        return monthActual;
    }

    public void setMonthActual(int monthActual) {
        this.monthActual = monthActual;
    }

    @Basic
    @Column(name = "month_name")
    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    @Basic
    @Column(name = "month_name_abbreviated")
    public String getMonthNameAbbreviated() {
        return monthNameAbbreviated;
    }

    public void setMonthNameAbbreviated(String monthNameAbbreviated) {
        this.monthNameAbbreviated = monthNameAbbreviated;
    }

    @Basic
    @Column(name = "quarter_actual")
    public int getQuarterActual() {
        return quarterActual;
    }

    public void setQuarterActual(int quarterActual) {
        this.quarterActual = quarterActual;
    }

    @Basic
    @Column(name = "quarter_name")
    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }

    @Basic
    @Column(name = "year_actual")
    public int getYearActual() {
        return yearActual;
    }

    public void setYearActual(int yearActual) {
        this.yearActual = yearActual;
    }

    @Basic
    @Column(name = "first_day_of_week")
    public Date getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public void setFirstDayOfWeek(Date firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
    }

    @Basic
    @Column(name = "last_day_of_week")
    public Date getLastDayOfWeek() {
        return lastDayOfWeek;
    }

    public void setLastDayOfWeek(Date lastDayOfWeek) {
        this.lastDayOfWeek = lastDayOfWeek;
    }

    @Basic
    @Column(name = "first_day_of_month")
    public Date getFirstDayOfMonth() {
        return firstDayOfMonth;
    }

    public void setFirstDayOfMonth(Date firstDayOfMonth) {
        this.firstDayOfMonth = firstDayOfMonth;
    }

    @Basic
    @Column(name = "last_day_of_month")
    public Date getLastDayOfMonth() {
        return lastDayOfMonth;
    }

    public void setLastDayOfMonth(Date lastDayOfMonth) {
        this.lastDayOfMonth = lastDayOfMonth;
    }

    @Basic
    @Column(name = "first_day_of_quarter")
    public Date getFirstDayOfQuarter() {
        return firstDayOfQuarter;
    }

    public void setFirstDayOfQuarter(Date firstDayOfQuarter) {
        this.firstDayOfQuarter = firstDayOfQuarter;
    }

    @Basic
    @Column(name = "last_day_of_quarter")
    public Date getLastDayOfQuarter() {
        return lastDayOfQuarter;
    }

    public void setLastDayOfQuarter(Date lastDayOfQuarter) {
        this.lastDayOfQuarter = lastDayOfQuarter;
    }

    @Basic
    @Column(name = "first_day_of_year")
    public Date getFirstDayOfYear() {
        return firstDayOfYear;
    }

    public void setFirstDayOfYear(Date firstDayOfYear) {
        this.firstDayOfYear = firstDayOfYear;
    }

    @Basic
    @Column(name = "last_day_of_year")
    public Date getLastDayOfYear() {
        return lastDayOfYear;
    }

    public void setLastDayOfYear(Date lastDayOfYear) {
        this.lastDayOfYear = lastDayOfYear;
    }

    @Basic
    @Column(name = "mmyyyy")
    public String getMmyyyy() {
        return mmyyyy;
    }

    public void setMmyyyy(String mmyyyy) {
        this.mmyyyy = mmyyyy;
    }

    @Basic
    @Column(name = "mmddyyyy")
    public String getMmddyyyy() {
        return mmddyyyy;
    }

    public void setMmddyyyy(String mmddyyyy) {
        this.mmddyyyy = mmddyyyy;
    }

    @Basic
    @Column(name = "weekend_indr")
    public boolean isWeekendIndr() {
        return weekendIndr;
    }

    public void setWeekendIndr(boolean weekendIndr) {
        this.weekendIndr = weekendIndr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateDimEntity that = (DateDimEntity) o;

        if (dateDimId != that.dateDimId) return false;
        if (epoch != that.epoch) return false;
        if (dayOfWeek != that.dayOfWeek) return false;
        if (dayOfMonth != that.dayOfMonth) return false;
        if (dayOfQuarter != that.dayOfQuarter) return false;
        if (dayOfYear != that.dayOfYear) return false;
        if (weekOfMonth != that.weekOfMonth) return false;
        if (weekOfYear != that.weekOfYear) return false;
        if (monthActual != that.monthActual) return false;
        if (quarterActual != that.quarterActual) return false;
        if (yearActual != that.yearActual) return false;
        if (weekendIndr != that.weekendIndr) return false;
        if (dateActual != null ? !dateActual.equals(that.dateActual) : that.dateActual != null) return false;
        if (daySuffix != null ? !daySuffix.equals(that.daySuffix) : that.daySuffix != null) return false;
        if (dayName != null ? !dayName.equals(that.dayName) : that.dayName != null) return false;
        if (weekOfYearIso != null ? !weekOfYearIso.equals(that.weekOfYearIso) : that.weekOfYearIso != null)
            return false;
        if (monthName != null ? !monthName.equals(that.monthName) : that.monthName != null) return false;
        if (monthNameAbbreviated != null ? !monthNameAbbreviated.equals(that.monthNameAbbreviated) : that.monthNameAbbreviated != null)
            return false;
        if (quarterName != null ? !quarterName.equals(that.quarterName) : that.quarterName != null) return false;
        if (firstDayOfWeek != null ? !firstDayOfWeek.equals(that.firstDayOfWeek) : that.firstDayOfWeek != null)
            return false;
        if (lastDayOfWeek != null ? !lastDayOfWeek.equals(that.lastDayOfWeek) : that.lastDayOfWeek != null)
            return false;
        if (firstDayOfMonth != null ? !firstDayOfMonth.equals(that.firstDayOfMonth) : that.firstDayOfMonth != null)
            return false;
        if (lastDayOfMonth != null ? !lastDayOfMonth.equals(that.lastDayOfMonth) : that.lastDayOfMonth != null)
            return false;
        if (firstDayOfQuarter != null ? !firstDayOfQuarter.equals(that.firstDayOfQuarter) : that.firstDayOfQuarter != null)
            return false;
        if (lastDayOfQuarter != null ? !lastDayOfQuarter.equals(that.lastDayOfQuarter) : that.lastDayOfQuarter != null)
            return false;
        if (firstDayOfYear != null ? !firstDayOfYear.equals(that.firstDayOfYear) : that.firstDayOfYear != null)
            return false;
        if (lastDayOfYear != null ? !lastDayOfYear.equals(that.lastDayOfYear) : that.lastDayOfYear != null)
            return false;
        if (mmyyyy != null ? !mmyyyy.equals(that.mmyyyy) : that.mmyyyy != null) return false;
        if (mmddyyyy != null ? !mmddyyyy.equals(that.mmddyyyy) : that.mmddyyyy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateDimId;
        result = 31 * result + (dateActual != null ? dateActual.hashCode() : 0);
        result = 31 * result + (int) (epoch ^ (epoch >>> 32));
        result = 31 * result + (daySuffix != null ? daySuffix.hashCode() : 0);
        result = 31 * result + (dayName != null ? dayName.hashCode() : 0);
        result = 31 * result + dayOfWeek;
        result = 31 * result + dayOfMonth;
        result = 31 * result + dayOfQuarter;
        result = 31 * result + dayOfYear;
        result = 31 * result + weekOfMonth;
        result = 31 * result + weekOfYear;
        result = 31 * result + (weekOfYearIso != null ? weekOfYearIso.hashCode() : 0);
        result = 31 * result + monthActual;
        result = 31 * result + (monthName != null ? monthName.hashCode() : 0);
        result = 31 * result + (monthNameAbbreviated != null ? monthNameAbbreviated.hashCode() : 0);
        result = 31 * result + quarterActual;
        result = 31 * result + (quarterName != null ? quarterName.hashCode() : 0);
        result = 31 * result + yearActual;
        result = 31 * result + (firstDayOfWeek != null ? firstDayOfWeek.hashCode() : 0);
        result = 31 * result + (lastDayOfWeek != null ? lastDayOfWeek.hashCode() : 0);
        result = 31 * result + (firstDayOfMonth != null ? firstDayOfMonth.hashCode() : 0);
        result = 31 * result + (lastDayOfMonth != null ? lastDayOfMonth.hashCode() : 0);
        result = 31 * result + (firstDayOfQuarter != null ? firstDayOfQuarter.hashCode() : 0);
        result = 31 * result + (lastDayOfQuarter != null ? lastDayOfQuarter.hashCode() : 0);
        result = 31 * result + (firstDayOfYear != null ? firstDayOfYear.hashCode() : 0);
        result = 31 * result + (lastDayOfYear != null ? lastDayOfYear.hashCode() : 0);
        result = 31 * result + (mmyyyy != null ? mmyyyy.hashCode() : 0);
        result = 31 * result + (mmddyyyy != null ? mmddyyyy.hashCode() : 0);
        result = 31 * result + (weekendIndr ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "dateDimByDateDim")
    public Collection<TrueToSizeFactEntity> getTrueToSizeFactsByDateDimId() {
        return trueToSizeFactsByDateDimId;
    }

    public void setTrueToSizeFactsByDateDimId(Collection<TrueToSizeFactEntity> trueToSizeFactsByDateDimId) {
        this.trueToSizeFactsByDateDimId = trueToSizeFactsByDateDimId;
    }
}
