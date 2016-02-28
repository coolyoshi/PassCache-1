package com.example.android.passcache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import java.util.List;
import java.util.ArrayList;
import android.util.Log;

public class Main extends AppCompatActivity {

    private List<Circle> circleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleList = new ArrayList<Circle>();
        circleList = PrefUtilis.getFromPrefs2(this, PrefUtilis.PREFS_CIRCLE_KEY, null);
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
        Log.d("TAG","FINAL_TEST... EXPECT: 'Pass_Test2', RESULT: " + getList.get(1).getPassword().toString());

    }

    public void onClick(View v){

    }



}
