package com.example.app17;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import io.paperdb.Paper;

public class paperDb {
    public ArrayList<Student> getStudent(){
        return Paper.book("students").read("students", new ArrayList<Student>());
    }

    public void  saveStudent(ArrayList<Student> students){
        Paper.book("students").write("students",students);
    }

    public void addStudent(Student student, Context context){
        ArrayList<Student> students = getStudent();
        for (int i=0;i<students.size();i++){
            if(students.get(i).getStudentName().equals(student.getStudentName())){
                Toast.makeText(context,"Такой студент уже существует",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        students.add(student);
        saveStudent(students);
    }

    public void deleteStudent(int id){
        ArrayList<Student> students = getStudent();
        students.remove(id);
        Paper.book("students").write("students",students);
        saveStudent(students);
    }

    public void updateStudent(Student student , int id){
        ArrayList<Student> students = getStudent();
        students.set(id,student);
        Paper.book("students").write("students",students);
        saveStudent(students);
    }
}
