package com.example.drawline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawLine extends View {

    private Paint paint = new Paint();

    private PointF pointA, pointB;

    public DrawLine(Context context) {
        super(context);
    }

    public DrawLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(20);
        canvas.drawLine(pointA.x, pointA.y, pointB.x, pointB.y, paint);
        super.onDraw(canvas);
    }

    public void setPointA(PointF point) {
        pointA = point;
    }

    public void setPointB(PointF point) {
        pointB = point;
    }

    public void draw() {
        invalidate();
        requestLayout();
    }
}
