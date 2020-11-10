package com.example.drawline2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Drawline extends View {
    Paint paint = new Paint();

    private void init() {
        paint.setColor(Color.BLACK);
    }

    public Drawline(Context context) {
        super(context);
        init();
    }

    public Drawline(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Drawline(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(100, 100, 150, 150, paint);
    }

}