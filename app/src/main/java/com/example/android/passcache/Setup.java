package com.example.android.passcache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Setup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
    }

    public void onClick(View v) {
        //findViewById(R.id.enter_password).
        Intent i = new Intent(Setup.this, Login_Activity.class);
        startActivity(i);
    }
}
