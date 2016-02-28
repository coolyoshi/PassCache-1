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

import java.util.HashMap;

public class ForgetPass_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_);

        final Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"When is your birthday?","What is your Mother's maiden name?",
                "What is your favorite food?","Where would you love to travel?"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        HashMap <String,String>Password = new HashMap<String, String>();

        Button btnReset = (Button) findViewById(R.id.button3);
        btnReset.setOnClickListener(new View.OnClickListener() {

                                        String Spinner =dropdown.getSelectedItem().toString();

                                        EditText editText = (EditText) findViewById(R.id.editText2);
                                        @Override

                                        public void onClick(View v) {

                                            String inputText = editText.getText().toString();


                                            String PassWord = "";
                                            if(inputText.equals(PassWord))
                                            {
                                                TextView t = (TextView) findViewById(R.id.textView3);
                                                t.setText("Password");

                                            }
                                            else{
                                                TextView t = (TextView) findViewById(R.id.textView3);
                                               t.setText("Answer is not correct,please try again");

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
