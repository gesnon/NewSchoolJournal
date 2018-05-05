package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Journal implements Serializable {
    private String discipline;
    private List<Mark> marks;

    public Journal(String discipline) {
        this.discipline = discipline;
        marks = new ArrayList<>();
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "discipline='" + discipline + '\'' +
                '}';
    }
}
