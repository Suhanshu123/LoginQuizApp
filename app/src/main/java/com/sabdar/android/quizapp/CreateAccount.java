package com.sabdar.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateAccount extends AppCompatActivity {
    EditText edit_Enter_Username, edit_Enter_Password, edit_Re_Enter_Password;
    String username = null;
    String password = null;
    String repassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        edit_Enter_Username = findViewById(R.id.enterusername_edit_box);
        edit_Enter_Password = findViewById(R.id.enterpassword_edit_box);
        edit_Re_Enter_Password = findViewById(R.id.re_enter_password_edit_box);

    }

    public void openQuiz(View view) {
        username = edit_Enter_Username.getText().toString();
        password = edit_Enter_Password.getText().toString();
        repassword = edit_Re_Enter_Password.getText().toString();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(repassword)) {
            Toast.makeText(this, "Enter all the fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!(password.equals(repassword))) {
            Toast.makeText(this, "Passwords Mismatch", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, Login_Activity.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        startActivity(intent);
        Toast.makeText(this, "Successful SignUp", Toast.LENGTH_LONG).show();
        finish();
    }
}
