package com.javarush.test.level29.lesson15.big01.human;

import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students;

    public University(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student rezStudent = null;
        for (Student student : students) {

            if (student.getAverageGrade() == averageGrade) {
                rezStudent = student;
            }
        }
        return rezStudent;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student rezStudent = null;
        double max = 0;
        for (Student student : students) {

            if (student.getAverageGrade() > max) {
                max = student.getAverageGrade();
                rezStudent = student;
            }
        }
        return rezStudent;
    }

    public Student getStudentWithMinAverageGrade() {

        Student rezStudent = null;
        double min = students.get(0).getAverageGrade();
        for (Student student : students) {

            if (student.getAverageGrade() < min) {
                min = student.getAverageGrade();
                rezStudent = student;
            }
        }
        return rezStudent;
    }

    public void expel(Student student) {

          students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
