package com.company.controller;

import com.company.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements Serializable {
    private School school;

    public Controller() {
        school = new School();
    }

    Scanner s = new Scanner(System.in);


    public ClassUnit returnClassUnit(Integer lvl, String letter) {
        try {
            ClassUnit classUnit = school.getClasses().stream().filter(classUnit1 -> classUnit1.getLevel().equals(lvl) && classUnit1.getLetter().toLowerCase()
                    .equals(letter.toLowerCase())).findFirst().orElseThrow(() -> new NullPointerException());
            return classUnit;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Student> getAllStudentsInClass() {
        try {
            System.out.println("Выберите класс из списка  (введите номер и букву)");
            System.out.println(school.getClasses());
            Integer lvl = tryParse(s.nextLine());
            String letter = s.nextLine();
            return returnClassUnit(lvl, letter).getStudents();

        } catch (Exception e) {
            System.out.println("такого класса не существует");
            return null;
        }
    }

    public Student getStudentFrom(List<Student> currentStudents, String lastName, String firstName) {
        try {
            Student student_ = currentStudents.stream().filter(student -> student.getLastName().toLowerCase().equals(firstName.toLowerCase()) && student.getFirstName().toLowerCase().equals(lastName.toLowerCase()))
                    .findFirst().orElseThrow(() -> new NullPointerException());
            return student_;
        } catch (Exception e) {
            System.out.println(e);
            return null;

        }
    }

    public Journal getJournal(ClassUnit currentClasses, String discipline) {
        try {
            Journal currentJournal = currentClasses.getJournals().stream().filter(journal -> journal.getDiscipline().toLowerCase().equals(discipline.toLowerCase()))
                    .findFirst().orElseThrow(() -> new NullPointerException());
            return currentJournal;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("нет такого журнала");
            return null;
        }
    }

    public List<Mark> getAllMark(Journal currentJoutnal, Student currentStudent) {
        List<Mark> currentMarks = new ArrayList<>();

        for (int a = 0; a < currentJoutnal.getMarks().size(); a++) {
            if (currentJoutnal.getMarks().get(a).getOwner().equals(currentStudent)) {
                currentMarks.add(currentJoutnal.getMarks().get(a));
            }
        }

        return currentMarks;
    }

    public void addMark(Journal currentJournal, Mark currentMark) {
        currentJournal.getMarks().add(currentMark);
    }

    public void changeMark(Journal currentJournal, Date currentDate, Integer newMark) {

        try {
            Mark currentMark1 = currentJournal.getMarks().stream().filter(mark -> mark.getDate().equals(currentDate)).findFirst().orElseThrow(() -> new NullPointerException());
            currentMark1.setMark(newMark);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("в этот день оценки не было ");
        }

    }

    public void deleteMark(Journal currentJournal, Date currentDate, Student currentStudent) {


        for (int a = 0; a < currentJournal.getMarks().size(); a++) {
            if (currentJournal.getMarks().get(a).getDate().equals(currentDate) && currentJournal.getMarks().get(a).getOwner().equals(currentStudent)) {
                currentJournal.getMarks().remove(a);
            } /*else {
                System.out.println("Такой оценки не найдёно");
            }*/
        }
    }

    public Integer tryParse(String str) {
        Integer newInt;
        try {
            newInt = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            newInt = 0;
        }

        return newInt;
    }

    public void saveData() {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {

            fileOutputStream = new FileOutputStream("dataFile");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(school);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (fileOutputStream != null && objectOutputStream != null) {
                    fileOutputStream.close();
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public School readData() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("dataFile");
            objectInputStream = new ObjectInputStream(fileInputStream);
            School newSchool = (School) objectInputStream.readObject();
            return newSchool;
            // return (School) objectInputStream.readObject();

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            try {
                if (fileInputStream != null && objectInputStream != null) {
                    fileInputStream.close();
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }

        }
        return null;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
