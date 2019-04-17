package com.example.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText inEmail, inPassword;
    Button signin;
    TextView signup;

    SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inEmail = findViewById(R.id.etName)   ;
        inPassword = findViewById(R.id.etPassword);
         signin = findViewById(R.id.btnSignIn);
        signup = findViewById(R.id.tvSignup);

        preference = getSharedPreferences("pref", Context.MODE_PRIVATE);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegActivity.class));
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = preference.getString("regEmail", "");
                String pass = preference.getString("regPass", "");

                Log.d("val", email+pass);

                if(inEmail.getText().toString().equals(email) && inPassword.getText().toString().equals(pass) ){
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(LoginActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
