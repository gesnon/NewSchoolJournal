package com.company.view;

import com.company.controller.Controller;
import com.company.model.*;

import java.util.Scanner;

public class View {
    private Controller controller;
    Scanner scanner;

    public View() {
        controller = new Controller();
        scanner = new Scanner(System.in);
    }

    public void initialData() {

        controller.getSchool().getClasses().add(new ClassUnit(11, "A"));
        controller.getSchool().getClasses().add(new ClassUnit(11, "B"));
        controller.getSchool().getClasses().add(new ClassUnit(11, "C"));

        controller.getSchool().getClasses().get(0).getStudents().add(new Student("Ivanov", "Ivan"));
        controller.getSchool().getClasses().get(0).getStudents().add(new Student("Petrov", "Petr"));
        controller.getSchool().getClasses().get(0).getStudents().add(new Student("Fedorova", "Svetlana"));
        controller.getSchool().getClasses().get(0).getStudents().add(new Student("Shirokov", "Petr"));
        controller.getSchool().getClasses().get(0).getStudents().add(new Student("Ivanova", "Anna"));

        controller.getSchool().getClasses().get(1).getStudents().add(new Student("Khromov", "Max"));
        controller.getSchool().getClasses().get(1).getStudents().add(new Student("Chinnov", "Vlad"));
        controller.getSchool().getClasses().get(1).getStudents().add(new Student("Fedorova", "Anna"));
        controller.getSchool().getClasses().get(1).getStudents().add(new Student("Shirokov", "Sergey"));
        controller.getSchool().getClasses().get(1).getStudents().add(new Student("Tichonova", "Anna"));

        controller.getSchool().getClasses().get(2).getStudents().add(new Student("Khromova", "Viktoria"));
        controller.getSchool().getClasses().get(2).getStudents().add(new Student("Chinnov", "Sergey"));
        controller.getSchool().getClasses().get(2).getStudents().add(new Student("Fedorova", "Olga"));
        controller.getSchool().getClasses().get(2).getStudents().add(new Student("Ivanov", "Sergey"));
        controller.getSchool().getClasses().get(2).getStudents().add(new Student("Tichonova", "Darya"));

        controller.getSchool().getClasses().get(0).getJournals().add(new Journal("Math"));
        controller.getSchool().getClasses().get(0).getJournals().add(new Journal("Russian"));
        controller.getSchool().getClasses().get(0).getJournals().add(new Journal("Chemistry"));

        controller.getSchool().getClasses().get(1).getJournals().add(new Journal("Math"));
        controller.getSchool().getClasses().get(1).getJournals().add(new Journal("Russian"));
        controller.getSchool().getClasses().get(1).getJournals().add(new Journal("Chemistry"));

        controller.getSchool().getClasses().get(2).getJournals().add(new Journal("Math"));
        controller.getSchool().getClasses().get(2).getJournals().add(new Journal("Russian"));
        controller.getSchool().getClasses().get(2).getJournals().add(new Journal("Chemistry"));

        for (int q = 0; q < 3; q++) {
            Journal currentJournal = controller.getSchool().getClasses().get(0).getJournals().get(q);
            for (int w = 0; w < 5; w++) {
                Student currentStudent = controller.getSchool().getClasses().get(0).getStudents().get(w);

                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 1), 2));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 2), 4));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 3), 5));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 4), 3));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 5), 2));

            }
        }
        for (int q = 0; q < 3; q++) {
            Journal currentJournal = controller.getSchool().getClasses().get(1).getJournals().get(q);
            for (int w = 0; w < 5; w++) {
                Student currentStudent = controller.getSchool().getClasses().get(1).getStudents().get(w);

                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 1), 4));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 2), 5));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 3), 2));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 4), 4));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 5), 1));

            }
        }
        for (int q = 0; q < 3; q++) {
            Journal currentJournal = controller.getSchool().getClasses().get(2).getJournals().get(q);
            for (int w = 0; w < 5; w++) {
                Student currentStudent = controller.getSchool().getClasses().get(2).getStudents().get(w);

                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 1), 1));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 2), 2));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 3), 3));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 4), 4));
                controller.addMark(currentJournal, new Mark(currentStudent, new Date(1, 5), 5));

            }
        }
    }

    public void startTheme() {
        System.out.println("нажмите 1 чтобы получить список классов");
        System.out.println("нажмите 2 чтобы получить список студентов в классе");
        System.out.println("нажмите 3 чтобы получить список журналов в классе");
        System.out.println("нажмите 4 чтобы получить список оценок ученика по конкретному предмету");
        System.out.println("нажмите 5 чтобы добавить оценку");
        System.out.println("нажмите 6 чтобы изменить оценку");
        System.out.println("нажмите 7 чтобы удалить оценку");
        System.out.println("нажмите 8 завершить работу программы");
    }

    public void start() {
        boolean bool = true;
        if (controller.readData() == null) {
            initialData();
            System.out.println("программа запущена с тестовым набором данных");
        } else controller.setSchool(controller.readData());

        while (bool) {
            System.out.println();
            System.out.println("Выберите действие");
            startTheme();
            int num = controller.tryParse(scanner.nextLine());
            switch (num) {

                case 1: // получить список классов
                    System.out.println(controller.getSchool().getClasses());
                    continue;

                case 2: // получить список студентов к классе
                    controller.getAllStudentsInClass();
                    continue;

                case 3: // получить список журналов класса
                    System.out.println("Выберите класс из списка  (введите номер и букву)");
                    System.out.println(controller.getSchool().getClasses());
                    Integer lvl = controller.tryParse(scanner.nextLine());
                    String letter = scanner.nextLine();
                    ClassUnit currentClass = controller.returnClassUnit(lvl, letter);
                    if (currentClass == null) {
                        break;
                    } else
                        System.out.println(currentClass.getJournals());
                    continue;


                case 4: // получить оценки по предмету
                    System.out.println("Выберите класс (введите номер и букву)");
                    System.out.println(controller.getSchool().getClasses());
                    lvl = controller.tryParse(scanner.nextLine());
                    letter = scanner.nextLine();
                    ClassUnit currentClasses = controller.returnClassUnit(lvl, letter);
                    if (currentClasses == null) {
                        System.out.println("нет такого класса");
                        continue;
                    }
                    System.out.println("выберите предмет из списка ");
                    for (Journal journal : currentClasses.getJournals()) {
                        System.out.println(journal.getDiscipline()
                        );
                    }
                    String discipline = scanner.nextLine();
                    Journal currentJournal = controller.getJournal(currentClasses, discipline);
                    if (currentJournal == null) {
                        System.out.println("нет такого студента");
                        continue;
                    }

                    System.out.println("Выберите ученика из списка (Введите имя и фамилию)");
                    System.out.println(currentClasses.getStudents());
                    String firstName = scanner.nextLine();
                    String lastName = scanner.nextLine();
                    Student currentStudent = controller.getStudentFrom(currentClasses.getStudents(), lastName, firstName);
                    if (currentStudent == null) {
                        System.out.println("нет такого студента");
                        continue;
                    }

                    if (controller.getAllMark(currentJournal, currentStudent).size() == 0) {
                        System.out.println("у данного ученика нет оценок по этому предмету");
                    } else System.out.println(controller.getAllMark(currentJournal, currentStudent));

                    continue;

                case 5: // добавить оценку
                    System.out.println("Выберите класс из списка  (введите номер и букву)");
                    System.out.println(controller.getSchool().getClasses());
                    lvl = controller.tryParse(scanner.nextLine());
                    letter = scanner.nextLine();
                    ClassUnit currentClasses_ = controller.returnClassUnit(lvl, letter);
                    if (currentClasses_ == null) {
                        System.out.println("нет такого класса");
                        continue;
                    }
                    System.out.println("выберите предмет из списка ");
                    for (Journal journal : currentClasses_.getJournals()) {
                        System.out.println(journal.getDiscipline()
                        );
                    }
                    String discipline_ = scanner.nextLine();
                    Journal currentJournal_ = controller.getJournal(currentClasses_, discipline_);
                    if (currentJournal_ == null) {
                        System.out.println("нет такого журнала");
                        continue;
                    }
                    if (currentJournal_ == null) {
                        System.out.println("нет такого предмета");
                        continue;
                    }
                    System.out.println("Выберите ученика из списка (Введите имя и фамилию)");
                    System.out.println(currentClasses_.getStudents());
                    String firstName_ = scanner.nextLine();
                    String lastName_ = scanner.nextLine();
                    Student currentStudent_ = controller.getStudentFrom(currentClasses_.getStudents(), lastName_, firstName_);
                    if (currentStudent_ == null) {
                        System.out.println("нет такого студента");
                        continue;
                    }
                    System.out.println("Выберите дату");
                    System.out.println("Month :");
                    Integer month = controller.tryParse(scanner.nextLine());
                    System.out.println("Day :");
                    Integer day = controller.tryParse(scanner.nextLine());
                    System.out.println("оценка :");
                    Integer mark = controller.tryParse(scanner.nextLine());
                    Mark currentMark_ = new Mark(currentStudent_, new Date(month, day), mark);
                    controller.addMark(currentJournal_, currentMark_);
                    continue;

                case 6: // изменить оценку
                    System.out.println("Выберите класс из списка  (введите номер и букву)");
                    System.out.println(controller.getSchool().getClasses());
                    lvl = controller.tryParse(scanner.nextLine());
                    letter = scanner.nextLine();
                    ClassUnit currentClasses_1 = controller.returnClassUnit(lvl, letter);
                    if (currentClasses_1 == null) {
                        System.out.println("нет такого класса");
                        continue;
                    }
                    System.out.println("выберите предмет из списка ");
                    for (Journal journal : currentClasses_1.getJournals()) {
                        System.out.println(journal.getDiscipline()
                        );
                    }
                    String discipline_1 = scanner.nextLine();
                    Journal currentJournal_1 = controller.getJournal(currentClasses_1, discipline_1);
                    if (currentJournal_1 == null) {
                        System.out.println("нет такого журнала");
                        continue;
                    }
                    System.out.println("Выберите ученика из списка (Введите имя и фамилию)");
                    System.out.println(currentClasses_1.getStudents());
                    String firstName_1 = scanner.nextLine();
                    String lastName_1 = scanner.nextLine();
                    Student currentStudent_1 = controller.getStudentFrom(currentClasses_1.getStudents(), lastName_1, firstName_1);
                    if (currentStudent_1 == null) {
                        System.out.println("нет такого студента");
                        continue;
                    }
                    if (controller.getAllMark(currentJournal_1, currentStudent_1).size() == 0) {
                        System.out.println("у данного ученика нет оценок по этому предмету");
                        continue;
                    }
                    System.out.println(controller.getAllMark(currentJournal_1, currentStudent_1));

                    System.out.println("Выберите дату");
                    System.out.println("Month :");
                    Integer month_1 = controller.tryParse(scanner.nextLine());
                    System.out.println("Day :");
                    Integer day_1 = controller.tryParse(scanner.nextLine());
                    Date currentDate = new Date(month_1, day_1);
                    if (currentDate == null) {
                        System.out.println("в этот день не было поставлено оценки ");
                        continue;
                    }
                    System.out.println("оценка :");
                    Integer mark1 = controller.tryParse(scanner.nextLine());

                    controller.changeMark(currentJournal_1, currentDate, mark1);
                    continue;

                case 7: // удалить оценку
                    System.out.println("Выберите класс из списка  (введите номер и букву)");
                    System.out.println(controller.getSchool().getClasses());
                    lvl = controller.tryParse(scanner.nextLine());
                    letter = scanner.nextLine();
                    currentClasses_1 = controller.returnClassUnit(lvl, letter);
                    if (currentClasses_1 == null) {
                        System.out.println("нет такого класса");
                        continue;
                    }
                    System.out.println("выберите предмет из списка ");
                    for (Journal journal : currentClasses_1.getJournals()) {
                        System.out.println(journal.getDiscipline()
                        );
                    }
                    discipline_1 = scanner.nextLine();
                    currentJournal_1 = controller.getJournal(currentClasses_1, discipline_1);
                    if (currentJournal_1 == null) {
                        System.out.println("нет такого журнала");
                        continue;
                    }
                    System.out.println("Выберите ученика из списка (Введите имя и фамилию)");
                    System.out.println(currentClasses_1.getStudents());
                    firstName_1 = scanner.nextLine();
                    lastName_1 = scanner.nextLine();
                    currentStudent_1 = controller.getStudentFrom(currentClasses_1.getStudents(), lastName_1, firstName_1);
                    if (currentStudent_1 == null) {
                        System.out.println("нет такого студента");
                        continue;
                    }
                    if (controller.getAllMark(currentJournal_1, currentStudent_1).size() == 0) {
                        System.out.println("у данного ученика нет оценок по этому предмету");
                        continue;
                    }
                    System.out.println(controller.getAllMark(currentJournal_1, currentStudent_1));

                    System.out.println("Выберите дату");
                    System.out.println("Month :");
                    month_1 = controller.tryParse(scanner.nextLine());
                    System.out.println("Day :");
                    day_1 = controller.tryParse(scanner.nextLine());

                    Date currentDate_ = new Date(month_1, day_1);
                    if (currentDate_ == null) {
                        System.out.println("в этот день не было поставлено оценки ");
                        continue;
                    }
                    controller.deleteMark(currentJournal_1, currentDate_, currentStudent_1);
                    continue;

                case 8: // выход
                    controller.saveData();
                    bool = false;

            }

        }
    }
}
