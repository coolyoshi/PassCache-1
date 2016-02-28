package com.example.android.passcache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void buttonLoginClick(View view) {
        Intent intent = new Intent(Login_Activity.this, Main.class);
        startActivity(intent);
    }

    public void buttonForget(View view) {
        Intent intent = new Intent(Login_Activity.this, ForgetPass_Activity.class);
        startActivity(intent);
    }
}
