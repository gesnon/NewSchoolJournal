package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClassUnit implements Serializable{
    private Integer level;
    private String letter;
    private List<Journal> journals;
    private List<Student> students;

    public ClassUnit() {
    }

    public ClassUnit(Integer lvl, String letter) {
        this.level = lvl;
        this.letter = letter;
        journals = new ArrayList<>();
        students = new ArrayList<>();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer lvl) {
        this.level = lvl;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public List<Journal> getJournals() {
        return journals;
    }

    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ClassUnit{" +
                "level=" + level +
                ", letter='" + letter + '\'' +
                '}';
    }
}
