package com.example.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegActivity extends AppCompatActivity {

    EditText name, email, pass;
    Button signup;

   SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        name = findViewById(R.id.regName);
        email =findViewById(R.id.regEmail);
        pass =findViewById(R.id.regPassword);

        preferences = getSharedPreferences("pref", Context.MODE_PRIVATE);

        signup = findViewById(R.id.regSignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                SharedPreferences.Editor mEditor = preferences.edit();
                mEditor.putString("regName", name.getText().toString());
                mEditor.putString("regEmail", email.getText().toString());
                mEditor.putString("regPass", pass.getText().toString());

                //sync
//                mEditor.commit();

                //async
                mEditor.apply();

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

            }
        });

    }
}
