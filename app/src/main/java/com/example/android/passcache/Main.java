package com.example.android.passcache;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    Button[] btns = new Button[10];
    int[] idx = new int[10];
    int cnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Add(View v) {

        //when play is clicked show stop button and hide play button
        if(cnt >= 10){
            Context context = getApplicationContext();
            CharSequence text = "Error! System cannot hold anymore accounts";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            btns[0] = (Button) findViewById(R.id.btn1);
            btns[1] = (Button) findViewById(R.id.btn2);
            btns[2] = (Button) findViewById(R.id.btn3);
            btns[3] = (Button) findViewById(R.id.btn4);
            btns[4] = (Button) findViewById(R.id.btn5);
            btns[5] = (Button) findViewById(R.id.btn6);
            btns[6] = (Button) findViewById(R.id.btn7);
            btns[7] = (Button) findViewById(R.id.btn8);
            btns[8] = (Button) findViewById(R.id.btn9);
            btns[9] = (Button) findViewById(R.id.btn10);

            //TextView txt = (TextView)findViewById(R.id.txt1);
            //txt.setText(Integer.toString(btns[1].getId()));
            btns[cnt].setVisibility(View.VISIBLE);
            cnt++;
        }
    }
}
