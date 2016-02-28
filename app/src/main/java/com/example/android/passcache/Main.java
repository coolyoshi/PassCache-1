package com.example.android.passcache;

import android.content.Context;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
import java.util.List;
import java.util.ArrayList;
import android.util.Log;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    private Button button;
    private EditText editTextMainScreen;
    final Context context = this;
    private List<Circle> circleList;

    Button[] btns = new Button[10];
    int[] idx = new int[10];
    int cnt = 0;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleList = new ArrayList<Circle>();
        circleList = PrefUtilis.getFromPrefs2(this, PrefUtilis.PREFS_CIRCLE_KEY, null);

        // components from main.xml
        button = (Button) findViewById(R.id.btnAdd);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // get prompts.xml view
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View promptView = layoutInflater.inflate(R.layout.dialogbox_activity, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set prompts.xml to be the layout file of the alertdialog builder
                alertDialogBuilder.setView(promptView);
                final EditText title = (EditText) promptView.findViewById(R.id.titleInput);
                final EditText username = (EditText) promptView.findViewById(R.id.usernameInput);
                final EditText password = (EditText) promptView.findViewById(R.id.passwordInput);

                // setup a dialog window
                alertDialogBuilder.setCancelable(false).setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        if (cnt >= 10) {
                            Context context = getApplicationContext();
                            CharSequence text = "Error! System cannot hold anymore accounts";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
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

                            btns[cnt].setVisibility(View.VISIBLE);
                            cnt++;
                        }

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });

                // create an alert dialog
                AlertDialog alertD = alertDialogBuilder.create();
                alertD.show();
            }
        });
    }


    public void Add(View v) {

        //when play is clicked show stop button and hide play button
        if (cnt >= 10) {
            Context context = getApplicationContext();
            CharSequence text = "Error! System cannot hold anymore accounts";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
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

            btns[cnt].setVisibility(View.VISIBLE);
            cnt++;
        }
    }

    /*
    *Just a quick test to test storing an array list of circles into shared preferences
     */
    public void circleListTest() {
        List<Circle> circleList = new ArrayList<Circle>();
        Circle testCircle = new Circle("TitleTest", "User_Test", "Pass_Test");
        Circle testCircle2 = new Circle("TitleTest2", "User_Test2", "Pass_Test2");
        circleList.add(testCircle);
        circleList.add(testCircle2);
        PrefUtilis.saveToPrefs2(this, PrefUtilis.PREFS_CIRCLE_KEY, circleList);
        List<Circle> getList = new ArrayList<Circle>();
        getList = PrefUtilis.getFromPrefs2(this, PrefUtilis.PREFS_CIRCLE_KEY, null);
        Log.d("TAG", "FINAL_TEST... EXPECT: 'Pass_Test2', RESULT: " + getList.get(1).getPassword().toString());
    }
}
