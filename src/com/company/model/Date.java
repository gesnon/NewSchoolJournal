package com.company.model;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {
    private Integer month;
    private Integer day;

    public Date() {
    }

    public Date(Integer month, Integer day) {
        this.month = month;
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(month, date.month) &&
                Objects.equals(day, date.day);
    }

    @Override
    public int hashCode() {

        return Objects.hash(month, day);
    }
}
