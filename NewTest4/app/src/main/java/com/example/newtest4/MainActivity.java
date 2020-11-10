package com.example.newtest4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        final ImageView image1 = (ImageView) findViewById(R.id.image1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer randomNum = new Random().nextInt(61) + 20;
                Log.d("RANDOM_NUM", "Value is: " + randomNum);

//                float deg = (image1.getRotation() == 60F) ? 0F : 60F;
//                image1.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
                float deg = (image1.getRotation() == randomNum) ? 0F : randomNum;
                Log.d("TAG", "randomNum is: " + deg);
                image1.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });
    }
}