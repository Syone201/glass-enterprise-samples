package com.example.drawline;

import android.graphics.PointF;
import android.os.Bundle;

import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    PointF pointA = new PointF(300, 860);
    PointF pointB = new PointF(1040, 860);

//    centrePoint x = 580

    Integer rollDegrees = 0;
    int loopIteration = 10;

    private DrawLine mDrawLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawLine = (DrawLine) findViewById(R.id.drawLine);

        mDrawLine.setPointA(pointA);
        mDrawLine.setPointB(pointB);
        mDrawLine.draw();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < loopIteration; i++ ) {

        final int randomNum = new Random().nextInt(61) + 20;
        mDrawLine.setRotation((Integer) randomNum);
        mDrawLine.draw();
//        Log.d("RANDOM_NUM", "Random number generated is: " + randomNum);
//
//        }
    }

}