package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity2 extends AppCompatActivity {

    private static final String TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }

    public void create_an_account(View view) {
        EditText ed_email, ed_password1, ed_password2;
        String email, pass1, pass2;

        ed_email = findViewById(R.id.et_email);
        ed_password1 = findViewById(R.id.et_password);
        ed_password2 = findViewById(R.id.et_password2);

        email = ed_email.getText().toString();
        pass1 = ed_password1.getText().toString();
        pass2 = ed_password2.getText().toString();

        Log.d(TAG, "create_an_account: Avanzando " + email + ", " + pass1 + ", " + pass2);

        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);

        if (mat.matches()) {
            Log.d(TAG, "create_an_account: Valid email address");
            if (pass1.compareTo(pass2) == 0) {
                Log.d(TAG, "create_an_account: Everything is fine");
            } else
                Log.d(TAG, "create_an_account: Passwords don't match");
        } else {
            Log.d(TAG, "create_an_account: Not a valid email address");
        }
    }
}