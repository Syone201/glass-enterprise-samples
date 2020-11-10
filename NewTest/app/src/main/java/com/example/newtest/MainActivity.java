package com.example.newtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

//    Button button;
    EditText userInput = (EditText)findViewById(R.id.input);
    RotateAnimation rotate;
    AnimationSet animationSet;
    Integer rotateAngle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button = findViewById(R.id.button);
        rotate = new RotateAnimation(0, 360);

        animationSet = new AnimationSet(this, null);
        animationSet.addAnimation(rotate);



    }

    public void store_input(View view) {
        Integer rotateAngle = userInput.getText().toString();
    }


    view.startAnimation(animationSet);

}