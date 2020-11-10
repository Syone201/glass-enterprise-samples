package com.example.newtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderClient;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int userNumberInput;
    EditText userNumber;
    Button submitButton;
    View horizonImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNumber = (EditText)findViewById(R.id.userNumber);
        submitButton = (Button)findViewById(R.id.button);
        horizonImage = (View)findViewById(R.id.horizon);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int randomNum = new Random().nextInt(61) + 20;
                userNumberInput = Integer.valueOf(userNumber.getText().toString());
                Log.d("ADebugLog", "Value: " + userNumberInput);
                Log.d("ARandomNum", "Value: " + randomNum);
                horizonImage.setRotation((Integer) randomNum );
            }
        });
    }
}