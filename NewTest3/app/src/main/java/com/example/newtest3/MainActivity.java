package com.example.newtest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int loopIteration = 10;
    View horizonImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizonImage = (View)findViewById(R.id.horizon);
        horizonImage.setRotation((Integer) 0x0);
        horizonImage.invalidate();
        for (int i = 0; i < loopIteration; i++ ) {

            final int randomNum = new Random().nextInt(61) + 20;
            horizonImage.setRotation((Integer) randomNum);
            horizonImage.invalidate();
            Log.d("RANDOM_NUM", "Random number generated is: " + randomNum);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}