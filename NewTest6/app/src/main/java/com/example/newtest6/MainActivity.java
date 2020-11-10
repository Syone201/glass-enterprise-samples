package com.example.newtest6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;

import io.reactivex.rxjava3.core.Observable;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        final EditText mEditText = (EditText) findViewById(R.id.editText);
        View horizon = (View) findViewById(R.id.horizon);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextValue = mEditText.getText().toString();
                Integer finalValue = Integer.parseInt(editTextValue);

                observableCheck(finalValue);
            }

            private void observableCheck(Integer finalValue){
                Observable.just(finalValue)
                        .distinctUntilChanged()
                        .subscribe(s -> Log.d("OBSERVABLE_CHECK", "Rotate Line by " + finalValue + " degrees") );
                int deg = (horizon.getRotation() == finalValue) ? 0 : finalValue;
                horizon.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });


    }
}