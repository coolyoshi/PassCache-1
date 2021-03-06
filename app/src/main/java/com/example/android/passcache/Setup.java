package com.example.android.passcache;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Setup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        if (PrefUtilis.getFromPrefs(this, PrefUtilis.PREFS_LOGIN_FIRST_TIME_KEY, null) != null) {
            Intent i = new Intent(Setup.this, Login_Activity.class);
            startActivity(i);
        }
    }

    /**
     * Retrieve password and security question answer from user input
     * @param v
     */
    public void onClick(View v) {
        /* Variables storing info from edit text views */
        String password = ((EditText) findViewById(R.id.enter_password)).getText().toString();
        String passConfirm = ((EditText) findViewById(R.id.confirm_password)).getText().toString();
        String securityAnswer = ((EditText) findViewById(R.id.security_answer)).getText().toString();
        String securityQuestion = ((Spinner) findViewById(R.id.sp_Question)).getSelectedItem().toString();

        /* Validates the user inputs if passwords are same and not empty, etc.
           Display error message if violation occurred */




        if (password.equals("")) {
            displayWrongPassDialog("Password cannot be empty!");
        } else if (!password.equals(passConfirm)) {
            displayWrongPassDialog("Passwords don\'t match!");
        } else if (securityAnswer.equals("")) {
            displayWrongPassDialog("Security answer cannot be empty!");
        } else if (password.length() < 4) {
            displayWrongPassDialog("Password is too short!");
        } else {
            /* Save the password and security answer */
            PrefUtilis.saveToPrefs(this, PrefUtilis.PREFS_LOGIN_PASSWORD_KEY, password);
            PrefUtilis.saveToPrefs(this, PrefUtilis.PREFS_LOGIN_SECURITY_KEY, securityAnswer);
            PrefUtilis.saveToPrefs(this, PrefUtilis.PREFS_LOGIN_QUESTION_KEY, securityQuestion);
            PrefUtilis.saveToPrefs(this, PrefUtilis.PREFS_LOGIN_FIRST_TIME_KEY, "something");



            Intent i2 = new Intent(Setup.this, ForgetPass_Activity.class);
            i2.putExtra("sNumber", securityAnswer);
            startActivity(i2);


            Intent i3 = new Intent(Setup.this, ForgetPass_Activity.class);
            i3.putExtra("sNumber2", securityQuestion);
            startActivity(i3);

            Intent i = new Intent(Setup.this, Login_Activity.class);
            startActivity(i);


        }
    }

    /**
     * Display error message box
     * @param message
     */
    private void displayWrongPassDialog(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Error registering");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}
