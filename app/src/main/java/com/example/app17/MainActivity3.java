package com.example.app17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    Button btnB, btnD;
    EditText LT, LA;
    paperDb paperD = new paperDb();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnB = findViewById(R.id.btnBack);
        btnD = findViewById(R.id.btnDelete);
        LT = findViewById(R.id.LTitle);
        LA = findViewById(R.id.LAvtor);

        Bundle arguments = getIntent().getExtras();
        LT.setText(arguments.get("Name").toString());
        LA.setText(arguments.get("St").toString());

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(LT.getText().toString(),LA.getText().toString());
                paperD.updateStudent(student,(Integer) arguments.get("ID"));
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paperD.deleteStudent((Integer) arguments.get("ID"));
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}