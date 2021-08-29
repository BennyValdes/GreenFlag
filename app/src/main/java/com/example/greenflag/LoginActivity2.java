package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView tv_inc_email, tv_inc_pass1, tv_inc_pass2;
        ImageView iv_ac1, iv_ac2, iv_ac3;
        String email, pass1, pass2;

        ed_email = findViewById(R.id.et_email);
        tv_inc_email = findViewById(R.id.tv_bad_email);
        ed_password1 = findViewById(R.id.et_password);
        tv_inc_pass1 = findViewById(R.id.tv_bad_password1);
        ed_password2 = findViewById(R.id.et_password2);
        tv_inc_pass2 = findViewById(R.id.tv_bad_password2);
        iv_ac1 = findViewById(R.id.iv_email);
        iv_ac2 = findViewById(R.id.iv_password1);
        iv_ac3 = findViewById(R.id.iv_password2);


        email = ed_email.getText().toString();
        pass1 = ed_password1.getText().toString();
        pass2 = ed_password2.getText().toString();

        Log.d(TAG, "create_an_account: Avanzando " + email + ", " + pass1 + ", " + pass2);

        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Pattern capitalL = Pattern.compile("(.*[A-Z].*)");
        Pattern lowerL = Pattern.compile("(.*[a-z]*.)");
        Pattern numbers = Pattern.compile("(.*[0-9]*.)");
        Matcher mat = pattern.matcher(email);
        Matcher matPass1 = capitalL.matcher(pass1);
        Matcher matPass2 = lowerL.matcher(pass1);
        Matcher matPass3 = numbers.matcher(pass1);

        if (mat.matches()) {
            Log.d(TAG, "create_an_account: Valid email address");
            if (pass1.compareTo(pass2) != 0) {
                Log.d(TAG, "create_an_account: Passwords don't match");
                tv_inc_email.setVisibility(View.INVISIBLE);
                tv_inc_pass1.setVisibility(View.VISIBLE);
                tv_inc_pass2.setVisibility(View.VISIBLE);
                ed_email.setBackgroundResource(R.drawable.success);
                iv_ac1.setVisibility(View.VISIBLE);
                ed_password1.setBackgroundResource(R.drawable.fail);
                ed_password2.setBackgroundResource(R.drawable.fail);
            }
            else {
                if (pass1.length()>=8) {
                    if (matPass1.matches() && matPass2.matches() && matPass3.matches()){
                        Log.d(TAG, "create_an_account: Everything is fine");
                        ed_email.setBackgroundResource(R.drawable.success);
                        ed_email.setVisibility(View.VISIBLE);
                        ed_password1.setBackgroundResource(R.drawable.success);
                        ed_password1.setVisibility(View.VISIBLE);
                        ed_password2.setBackgroundResource(R.drawable.success);
                        ed_password2.setVisibility(View.VISIBLE);
                        tv_inc_email.setVisibility(View.INVISIBLE);
                        tv_inc_pass1.setVisibility(View.INVISIBLE);
                        tv_inc_pass2.setVisibility(View.INVISIBLE);
                        iv_ac1.setVisibility(View.VISIBLE);
                        iv_ac2.setVisibility(View.VISIBLE);
                        iv_ac3.setVisibility(View.VISIBLE);
                    }
                    else{
                        Log.d(TAG, "create_an_account: Passwords isn't valid");
                        tv_inc_email.setVisibility(View.INVISIBLE);
                        tv_inc_pass1.setVisibility(View.VISIBLE);
                        ed_email.setBackgroundResource(R.drawable.success);
                        iv_ac1.setVisibility(View.VISIBLE);
                        ed_password1.setBackgroundResource(R.drawable.fail);
                        ed_password2.setBackgroundResource(R.drawable.fail);
                    }
                }
                else{
                    Log.d(TAG, "create_an_account: Passwords isn't 8");
                    tv_inc_email.setVisibility(View.INVISIBLE);
                    tv_inc_pass1.setVisibility(View.VISIBLE);
                    ed_email.setBackgroundResource(R.drawable.success);
                    iv_ac1.setVisibility(View.VISIBLE);
                    ed_password1.setBackgroundResource(R.drawable.fail);
                    ed_password2.setBackgroundResource(R.drawable.fail);
                }
            }
        } else {
            Log.d(TAG, "create_an_account: Not a valid email address");
            tv_inc_email.setVisibility(View.VISIBLE);
        }
    }
}