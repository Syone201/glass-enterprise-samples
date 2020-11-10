package com.example.rotateimage;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    Button rotate;
    Integer iVal = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = (ImageView)findViewById(R.id.imageView1);
        rotate = (Button)findViewById(R.id.button1);
        rotate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ++iVal;
                imgView.setRotation((Integer) iVal);
                Log.d("MainActivity", "Button Clicked");
                Log.d("ADebugTag", "Value: " + Integer.toString(iVal));
            }
        });
    }
}