package com.example.app17;

public class Student {
    private String StudentName;
    private String opisanie;

    public Student(String StudentName, String opisanie){
        this.StudentName = StudentName;
        this.opisanie = opisanie;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }
}
