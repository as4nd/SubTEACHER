package com.example.letstrythisagain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {


    private Button mRegister;
    private EditText mEmail, mPassword, mUniversity, mName;

    private FirebaseAuth myAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        myAuth= FirebaseAuth.getInstance();
        firebaseAuthStateListener= new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                if (user != null)   {
////                    Intent intent= new Intent(RegistrationActivity.this, MainActivity.class);
////                    startActivity(intent);
////                    finish();
//                   // return;
                }
            }
        };


        mRegister= (Button) findViewById(R.id.registration);
        mEmail= (EditText) findViewById(R.id.email);
        mPassword= (EditText) findViewById(R.id.password);
        mUniversity=(EditText) findViewById(R.id.universityName);//university name
        mName= (EditText) findViewById(R.id.teacherName);

        mRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final String email= mEmail.getText().toString();
                final String password= mPassword.getText().toString();
                final String teacherName= mName.getText().toString();
                final String universityName= mUniversity.getText().toString();

                myAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this, "sign up error.", Toast.LENGTH_SHORT).show();
                        }else {
                            Intent int3= new Intent(RegistrationActivity.this, LoginActivity.class);
                            startActivity(int3);

                            String userid= myAuth.getCurrentUser().getUid();
                            DatabaseReference currentUserDb = FirebaseDatabase.getInstance().getReference().child("Users").child(userid);// check to see if "userid" is correct
                            Map userInfo = new HashMap<>();
                            userInfo.put("name", teacherName);
                            userInfo.put("email", email);
                            userInfo.put("university",universityName );


                            currentUserDb.updateChildren(userInfo);

                            finish();
                            return;
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAuth.removeAuthStateListener(firebaseAuthStateListener);
    }
}
