package com.example.letstrythisagain;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginRegistrationPage extends AppCompatActivity {


    private Button sLogin, sRegister;
    private TextView sWelcometoSubTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registration_page);

        sLogin= (Button) findViewById(R.id.login);
        sRegister= (Button) findViewById(R.id.register);
        sWelcometoSubTeacher= (TextView)findViewById(R.id.txtWelcome);


        sLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1= new Intent(LoginRegistrationPage.this, LoginActivity.class);
                startActivity(int1);
                finish();
                return;
            }
        });

        sRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2= new Intent(LoginRegistrationPage.this, RegistrationActivity.class);
                startActivity(int2);
                finish();
                return;

            }
        });



    }




}

//
//    private TextView SubTeacher;
//    private EditText Email;
//    private TextView Pass;
//    private TextView Username;
//    private TextView Password;
//    private Button ForgotPassword;
//
//    private Button Login;
//    private Button Signup;
//    private int counter = 5;
//
//
//    @SuppressLint("WrongViewCast")
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_main);
//
//
//        SubTeacher = (TextView) findViewById(R.id.edSubTeacher);
//        Email = (EditText) findViewById(R.id.edEmail);
//        Pass = (EditText) findViewById(R.id.edPass);
//        SubTeacher = (TextView) findViewById(R.id.edSubTeacher);
//        Username = (TextView) findViewById(R.id.txtUsername);
//        Password = (TextView) findViewById(R.id.txtPassword);
//        ForgotPassword = (Button) findViewById(R.id.btnFrgtPswd);
//        Login = (Button) findViewById(R.id.btnLogin);
//        Signup = (Button) findViewById(R.id.btnSignup);
//
//
//        Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(LoginRegistrationPage.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//                return;
//
//                /*validate(Email.getText().toString(),Pass.getText().toString());
//                 */
//
//            }
//        });
//
//
//        Signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(LoginRegistrationPage.this, RegistrationActivity.class);
//                startActivity(intent);
//                finish();
//                return;
//
//                /*validate(Email.getText().toString(),Pass.getText().toString());
//                 */
//
//            }
//        });
//    }
//}
//
//


