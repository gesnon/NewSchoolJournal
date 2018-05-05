package com.company.model;

import java.io.Serializable;

public class Mark  implements Serializable{
    private Student owner;
    private  Date date;
    private Integer mark;

    public Mark() {
    }

    public Mark(Student owner, Date date, Integer mark) {
        this.owner = owner;
        this.date = date;
        this.mark = mark;
    }

    public Student getOwner() {
        return owner;
    }

    public void setOwner(Student owner) {
        this.owner = owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "date=" + date +
                ", mark=" + mark +
                '}';
    }
}
