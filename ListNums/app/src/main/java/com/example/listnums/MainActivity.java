package com.example.listnums;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> Nums = new ArrayList<>();

        Nums.add(1);
        Nums.add(2);
        Nums.add(2);
        Nums.add(3);

        SystemClock.sleep(1000);

        System.out.println("Size of array is: " + Nums.size());
        int arrCount = Nums.size();
        System.out.println("arrCount is: " + arrCount);
        for (int i = 0; i < Nums.size(); i++){
            System.out.println("Value in array is: " + Nums.get(i));
        }
    }
}