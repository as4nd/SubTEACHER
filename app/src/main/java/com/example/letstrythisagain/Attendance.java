package com.example.letstrythisagain;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Attendance extends AppCompatActivity {

    private Button cBack, cSubmit;
    private TextView cPresent, cTxtAttendence, cTxtWill, cTxtCourtney, cTxtMark, cTxtJacob2, cTxtArmin2, cTxtDamon, cTxtMoe, cTxtSydney, cTxtAshma, cTxtRitu;
    private CheckBox cCheckBox, cCheckBox2, cCheckBox3, cCheckBox4,cCheckBox5, cCheckBox6, cCheckBox7, cCheckBox8, cCheckBox9, cCheckBox10;
    private IntentFilter filter;


    private FirebaseAuth myAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_attendance);
        myAuth= FirebaseAuth.getInstance();


        cBack= (Button) findViewById(R.id.backButton);
        cSubmit= (Button) findViewById(R.id.submitButton);




        cBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int8= new Intent(Attendance.this, AttendanceFlashcards.class);
                startActivity(int8);
                finish();
                return;
            }
        });

        cSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                myAuth= FirebaseAuth.getInstance();

                Intent int10= new Intent(Attendance.this, AttendanceFlashcards.class);
                startActivity(int10);

                final CheckBox cCheckBox = (CheckBox) findViewById(R.id.checkBox);
                final CheckBox cCheckBox2 = (CheckBox) findViewById(R.id.checkBox2);
                final CheckBox cCheckBox3 = (CheckBox) findViewById(R.id.checkBox3);
                final CheckBox cCheckBox4 = (CheckBox) findViewById(R.id.checkBox4);
                final CheckBox cCheckBox5 = (CheckBox) findViewById(R.id.checkBox5);
                final CheckBox cCheckBox6 = (CheckBox) findViewById(R.id.checkBox6);
                final CheckBox cCheckBox7 = (CheckBox) findViewById(R.id.checkBox7);
                final CheckBox cCheckBox8 = (CheckBox) findViewById(R.id.checkBox8);
                final CheckBox cCheckBox9 = (CheckBox) findViewById(R.id.checkBox9);
                final CheckBox cCheckBox10 = (CheckBox) findViewById(R.id.checkBox10);

                cTxtWill= (TextView) findViewById(R.id.txtWill);
                cTxtArmin2= (TextView) findViewById(R.id.txtArmin2);
                cTxtAshma= (TextView) findViewById(R.id.txtAshma);
                cTxtCourtney= (TextView) findViewById(R.id.txtCourtney);
                cTxtJacob2= (TextView) findViewById(R.id.txtJacob2);
                cTxtMark= (TextView) findViewById(R.id.txtMark);
                cTxtMoe= (TextView) findViewById(R.id.txtMoe);
                cTxtRitu= (TextView) findViewById(R.id.txtRitu);
                cTxtSydney= (TextView) findViewById(R.id.txtSydney);
                cTxtDamon= (TextView) findViewById(R.id.txtDamon);

                final String Will= cTxtWill.getText().toString();
                final String Armin= cTxtArmin2.getText().toString();
                final String Ashma= cTxtAshma.getText().toString();
                final String Courtney= cTxtCourtney.getText().toString();
                final String Jacob= cTxtJacob2.getText().toString();
                final String Mark= cTxtMark.getText().toString();
                final String Moe= cTxtMoe.getText().toString();
                final String Ritu= cTxtRitu.getText().toString();
                final String Sydney= cTxtSydney.getText().toString();
                final String Damon= cTxtDamon.getText().toString();
                    RegistrationActivity ra= new RegistrationActivity();
                String userid= myAuth.getCurrentUser().getUid();


                DatabaseReference currentUserDb6 = FirebaseDatabase.getInstance().getReference().child("Attendance").child("present");// check to see if "userid" is correct
                DatabaseReference currentUserDb7 = FirebaseDatabase.getInstance().getReference().child("Attendance").child("absent");
                Map <String, String> attendanceInfo2 = new HashMap<>();
                Map <String, String> absentInfo3= new HashMap<>();

                if (cCheckBox.isChecked()) {
                    cCheckBox.setChecked(true);
                    attendanceInfo2.put("studentName",Damon );
                    currentUserDb6.setValue(attendanceInfo2);
                }else {
                    absentInfo3.put("studentName", Damon);
                    currentUserDb7.setValue(absentInfo3);
                }


                if (cCheckBox2.isChecked()) {
                    cCheckBox2.setChecked(true);
                    attendanceInfo2.put("studentName2",Moe );
                    currentUserDb6.setValue(attendanceInfo2);
                }else{
                    absentInfo3.put("studentName2", Moe);
                    currentUserDb7.setValue(absentInfo3);
                }


                if (cCheckBox3.isChecked()) {
                    cCheckBox3.setChecked(true);
                    attendanceInfo2.put("studentName3",Ashma );
                    currentUserDb6.setValue(attendanceInfo2);

                }else{
                    absentInfo3.put("studentName3", Ashma);
                    currentUserDb7.setValue(absentInfo3);
                }


                if (cCheckBox4.isChecked()) {
                    cCheckBox4.setChecked(true);
                    attendanceInfo2.put("studentName4",Sydney );
                    currentUserDb6.setValue(attendanceInfo2);
                }else{
                    absentInfo3.put("studentName4", Sydney);
                    currentUserDb7.setValue(absentInfo3);
                }


                if (cCheckBox5.isChecked()) {
                    cCheckBox5.setChecked(true);
                    attendanceInfo2.put("studentName5",Armin );
                    currentUserDb6.setValue(attendanceInfo2);
                }else{
                    absentInfo3.put("studentName5", Armin);
                    currentUserDb7.setValue(absentInfo3);
                }


                if (cCheckBox6.isChecked()) {
                    cCheckBox6.setChecked(true);
                    attendanceInfo2.put("studentName6",Jacob );
                    currentUserDb6.setValue(attendanceInfo2);
                }else{
                    absentInfo3.put("studentName6", Jacob);
                    currentUserDb7.setValue(absentInfo3);
                }


                if (cCheckBox7.isChecked()) {
                    cCheckBox7.setChecked(true);
                    attendanceInfo2.put("studentName7",Will );
                    currentUserDb6.setValue(attendanceInfo2);
                }else{
                    absentInfo3.put("studentName7", Will);
                    currentUserDb7.setValue(absentInfo3);
                }


                if (cCheckBox8.isChecked()) {
                    cCheckBox8.setChecked(true);
                    attendanceInfo2.put("studentName8",Mark );
                    currentUserDb6.setValue(attendanceInfo2);
                }else{
                    absentInfo3.put("studentName8", Mark);
                    currentUserDb7.setValue(absentInfo3);
                }


                if (cCheckBox9.isChecked()) {
                    cCheckBox9.setChecked(true);
                    attendanceInfo2.put("studentName9",Ritu );
                    currentUserDb6.setValue(attendanceInfo2);
                }else{
                    absentInfo3.put("studentName9", Ritu);
                    currentUserDb7.setValue(absentInfo3);
                }


                if (cCheckBox10.isChecked()) {
                    cCheckBox10.setChecked(true);
                    attendanceInfo2.put("studentName10",Courtney );
                    currentUserDb6.setValue(attendanceInfo2);
                }else{
                    absentInfo3.put("studentName10", Courtney);
                    currentUserDb7.setValue(absentInfo3);
                }
                finish();
                return;
            }
        });

    }


}
