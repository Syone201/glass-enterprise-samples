package com.example.newtest5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.just(1, 2, 2, 3, 3, 2, 2, 1, 2, 3)
                .distinctUntilChanged()
                .subscribe(System.out::println);
//        createObservableWithJust();
    }

//        MyModel myModel = new MyModel();
//        myModel.getModelChanges()
//                .subscribe(System.out::println);
//
//        int getNum = myModel.getField1();
//        System.out.println("Returned Value is: " + getNum);
//        for ( int i = 0; i < loopCount; i++ ) {
//            myModel.setField1(Numbers.get(i));
//        }
//        int RandomNum = new Random().nextInt(61) + 20;

//    }





    private void createObservableWithJust () {
//        List<Integer> Numbers = new ArrayList<>();
//
//        Numbers.add(1);
//        Numbers.add(2);
//        Numbers.add(2);
//        Numbers.add(3);
//        Numbers.add(3);
//        Numbers.add(20);
//        Numbers.add(46);
//        Numbers.add(46);
//        Numbers.add(78);
//
//        int arrSize = Numbers.size();
//        for (int i = 0; i < arrSize; i++) {
//            int randomNum = new Random().nextInt(61) + 20;
//            Log.d("ARRAY_VALUE", "Array value is: " + i);
//            Observable<Integer> observable = Observable.just(i)
//                    .repeatWhen(o -> o.concatMap(v -> Observable.timer(1000, TimeUnit.MILLISECONDS)))
//                    .distinctUntilChanged();
//
//            observable.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(d -> Log.d("Data", "Got object " + d), e -> Log.e("Error", "Received Error: " + e));
//        }

//        Observable.just("A", "B", "B", "A", "C", "A", "A", "D")
//                .distinctUntilChanged()
//                .subscribe(abc -> Log.d("RXJAVA", abc));

    }

}