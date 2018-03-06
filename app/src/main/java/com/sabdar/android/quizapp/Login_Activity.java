package com.sabdar.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login_Activity extends AppCompatActivity {
    EditText edit_Username, edit_Password;
    CreateAccount createAccount = new CreateAccount();
    String s = createAccount.username;
    String s2 = createAccount.password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        edit_Username = findViewById(R.id.username_edit_box);
        edit_Password = findViewById(R.id.password_edit_box);
    }

    public void openQuiz(View view) {
        String username = edit_Username.getText().toString();
        String password = edit_Password.getText().toString();

        String login_username = null;
        String login_password = null;
        Log.d(login_password+login_username,"LoginActivity");

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter all the fields", Toast.LENGTH_SHORT).show();
            return;
        } else if (!(TextUtils.isEmpty(username)) || !(TextUtils.isEmpty(password))) {
            Intent intent = getIntent();


            if (intent.hasExtra("username") && intent.hasExtra("password")) {
                login_username = intent.getStringExtra("username");
                login_password = intent.getStringExtra("password");
                Log.d(login_password+login_username,"LoginActivity");


                if (login_password.equals(password) && login_username.equals(username)) {
                    Intent intent1 = new Intent(this, MainActivity.class);
                    startActivity(intent1);
                    Toast.makeText(this, "Successful LogIn", Toast.LENGTH_LONG).show();
                    Log.d("hello","LoginActivity");
                    finish();
                    return;
                }
                else {
                    Toast.makeText(this, "Wrong Password", Toast.LENGTH_LONG).show();
                    return;

                }
            }

            else {
                Toast.makeText(this, "Account Not Exist", Toast.LENGTH_LONG).show();
                return;
            }


        }


    }


    public void create_Account(View view) {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
        finish();
    }
}
