package com.example.android.passcache;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main extends AppCompatActivity {


    private Button button;
    private EditText editTextMainScreen;
    final Context context = this;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // components from main.xml
        button = (Button) findViewById(R.id.button);
        editTextMainScreen = (EditText) findViewById(R.id.editTextResult);
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
                        // get user input and set it to result
                        editTextMainScreen.setText(title.getText());
                        editTextMainScreen.setText(username.getText());
                        editTextMainScreen.setText(password.getText());
                        System.out.println(title.getText().toString());
                        System.out.println(username.getText().toString());
                        System.out.println(password.getText().toString());
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






}
