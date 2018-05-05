package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class School implements Serializable {

    private List<ClassUnit> classes;
    public School() {
        classes = new ArrayList<>();
    }

    public List<ClassUnit> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassUnit> classes) {
        this.classes = classes;
    }
}
