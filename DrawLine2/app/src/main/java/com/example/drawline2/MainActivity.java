package com.example.drawline2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;

public class MainActivity extends AppCompatActivity {

    Drawline drawLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawLine = new Drawline(this);
        drawLine.setPivotX(100f);
        drawLine.setPivotY(100f);
        setContentView(drawLine);

        ValueAnimator animator = ValueAnimator.ofFloat(0f, 20f);
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float x = (float) animation.getAnimatedValue();

                drawLine.setRotation(x);
                drawLine.invalidate();
            }
        });
        animator.start();
    }
}