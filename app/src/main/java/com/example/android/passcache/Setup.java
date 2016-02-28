package com.example.android.passcache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Setup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
    }

    /**
     *
     * @param v
     */
    public void onClick(View v) {
        String password = ((EditText) findViewById(R.id.enter_password)).getText().toString();
        String passConfirm = ((EditText) findViewById(R.id.confirm_password)).getText().toString();
        String securityAnswer = ((EditText) findViewById(R.id.security_answer)).getText().toString();

        if (!password.equals(passConfirm)) {
            ((TextView) findViewById(R.id.error_message)).setText("Passwords don\'t match!");
        }
        else if (password.equals("")) {
            ((TextView) findViewById(R.id.error_message)).setText("Password cannot be empty!");
        }
        else if (securityAnswer.equals("")){
            ((TextView) findViewById(R.id.error_message)).setText("Security answer cannot be empty!");
        }
        else {
            //findViewById(R.id.enter_password).
            PrefUtilis.saveToPrefs(this, PrefUtilis.PREFS_LOGIN_PASSWORD_KEY, password);
            Intent i = new Intent(Setup.this, Login_Activity.class);
            startActivity(i);
        }

    }
}
