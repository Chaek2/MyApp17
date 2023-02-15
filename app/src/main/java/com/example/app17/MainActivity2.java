package com.example.app17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import io.paperdb.Paper;

public class MainActivity2 extends AppCompatActivity {
    Button btn;
    EditText Name;
    EditText St;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Paper.init(this);

        btn = findViewById(R.id.btnAddAnime);
        Name = findViewById(R.id.editName);
        St = findViewById(R.id.editStudent);//opisanie

        paperDb paperD = new paperDb();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(Name.getText().toString(),St.getText().toString());
                paperD.addStudent(student,getApplicationContext());
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}