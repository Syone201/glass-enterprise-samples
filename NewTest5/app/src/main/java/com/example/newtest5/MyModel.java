package com.example.newtest5;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class MyModel {
    private PublishSubject<MyModel> changeObservable = PublishSubject.create();
    private Integer Num1 = 0;

    public Integer getField1() {
        return Num1;
    }

    public void setField1(Integer field1) {
        this.Num1 = field1;
        changeObservable.onNext(this);
    }

    public Observable<MyModel> getModelChanges() {
        Log.d("Field1", "Value has now changed to: " + Num1);
        return changeObservable;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "field1='" + Num1 + '\'' +
                '}';
    }
}
