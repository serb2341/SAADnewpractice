package com.practice.saadnewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    Button button8;
    Button button9;

    private EditText symptomTitleEdit, symptomDescriptionEdit, severityEdit,
            startDateEdit, startTimeEdit, endDateEdit, endTimeEdit;
    private Button addButton;
    private DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        symptomTitleEdit = findViewById(R.id.symptomTitle);
        symptomDescriptionEdit = findViewById(R.id.symptomDescription);
        severityEdit = findViewById(R.id.severity);
        startDateEdit = findViewById(R.id.startDate);
        startTimeEdit = findViewById(R.id.startTime);
        endDateEdit = findViewById(R.id.endDate);
        endTimeEdit = findViewById(R.id.endTime);


        button8=(Button)findViewById(R.id.button8);
        addButton = findViewById(R.id.addbttn);

        myDB = new DatabaseHelper(this);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        button9=(Button)findViewById(R.id.button9);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        addData();
    }

    public void addData()
    {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = myDB.insertData(symptomTitleEdit.getText().toString(), symptomDescriptionEdit.getText().toString(), severityEdit.getText().toString(), startDateEdit.getText().toString(), startTimeEdit.getText().toString(), endDateEdit.getText().toString(), endTimeEdit.getText().toString());

                if (isInserted)
                {
                    Toast.makeText(MainActivity2.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity2.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}