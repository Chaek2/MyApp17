package com.example.app17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView liststudent;
    Button goAddStudent;
    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paper.init(this);

        liststudent = findViewById(R.id.listStudent);
        goAddStudent = findViewById(R.id.addStudent);

        goAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
                finish();
            }
        });

        paperDb paperD = new paperDb();
        liststudent.setLayoutManager(new LinearLayoutManager(this));
        liststudent.setHasFixedSize(true);
        students = paperD.getStudent();
        RecuclerAdapter adapter = new RecuclerAdapter(this,paperD.getStudent(), this);
        liststudent.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(MainActivity.this, MainActivity3.class);
        i.putExtra("ID", position);
        i.putExtra("Name", students.get(position).getStudentName());
        i.putExtra("St", students.get(position).getOpisanie());
        startActivity(i);
    }
}