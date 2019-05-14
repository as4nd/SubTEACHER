package com.example.letstrythisagain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AttendanceFlashcards extends AppCompatActivity {

    private Button bPractice, bAttendance;
    private TextView bChoose;
    private Button bLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_flashcards);


        bPractice= (Button) findViewById(R.id.practiceButton);
        bAttendance= (Button) findViewById(R.id.attendanceButton);
        bLogout= (Button)findViewById(R.id.btnLogout);


        bPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1= new Intent(AttendanceFlashcards.this, MainActivity.class);
                startActivity(int1);
                finish();
                return;
            }
        });

        bAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int7= new Intent(AttendanceFlashcards.this, Attendance.class);
                startActivity(int7);
                finish();
                return;

            }
        });

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1= new Intent(AttendanceFlashcards.this, LoginRegistrationPage.class);
                startActivity(int1);
                finish();
                return;
            }
        });

    }

}

