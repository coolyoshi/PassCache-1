package com.example.android.passcache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView;
import android.content.DialogInterface;

import java.util.HashMap;

public class ForgetPass_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_);


        String receive = PrefUtilis.getFromPrefs(this, PrefUtilis.PREFS_LOGIN_QUESTION_KEY, "wtf");
        System.out.println(receive);
     //   String test = PrefUtilis.getFromPrefs(this, PrefUtilis.PREFS_LOGIN_QUESTION_KEY, "wtf");

        String[] item =new String[1];
        item[0] = receive;
        final TextView dropdown = (TextView)findViewById(R.id.spinner);
        dropdown.setText(receive);
        String[] items = new String[]{"When is your birthday?","What is your Mother's maiden name?",
                "What is your favorite food?","Where would you love to travel?"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, item);


        Button btnReset = (Button) findViewById(R.id.button3);
        btnReset.setOnClickListener(new View.OnClickListener() {


                                        EditText editText = (EditText) findViewById(R.id.editText2);
                                        @Override

                                        public void onClick(View v) {

                                            String inputText = editText.getText().toString();

                                            String sec = PrefUtilis.getFromPrefs(ForgetPass_Activity.this, PrefUtilis.PREFS_LOGIN_SECURITY_KEY, "wtf");

                                            if(inputText.equals(sec))
                                            {
                                                TextView t = (TextView) findViewById(R.id.textView3);
                                                t.setText(PrefUtilis.getFromPrefs(ForgetPass_Activity.this, PrefUtilis.PREFS_LOGIN_PASSWORD_KEY, "wtf"));;

                                            }
                                            else{
                                                TextView t = (TextView) findViewById(R.id.textView3);
                                               t.setText("Answer is not correct, please try again.");

                                            }
                                        }
                                    }
        );
        Button btnReset2 = (Button) findViewById(R.id.button4);

        btnReset2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                             Intent I = new Intent(ForgetPass_Activity.this, Login_Activity.class);
                                             startActivity(I);
                                        }
        }
        );
    }
}
