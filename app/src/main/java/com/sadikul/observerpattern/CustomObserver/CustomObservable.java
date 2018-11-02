package com.sadikul.observerpattern.CustomObserver;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class CustomObservable {
    private static final String TAG = "<<customOB>>";
    private Context mContext = null;
    private List<CustomObserver> observers = new ArrayList<>();;

    private static CustomObservable mInstance = null;
    private boolean changed = false;
    private String message = null;

    private final Object MUTEX = new Object();

    public CustomObservable( ) {
    }

    public static CustomObservable getmInstance() {

        if( null == mInstance){
            mInstance = new CustomObservable();
        }
        return mInstance;
    }

    public boolean register(CustomObserver observer) {

        System.out.println(TAG + observer.getClass().getName());
        synchronized (this) {
            return observers.add(observer);
        }
    }

    public boolean unRegister(CustomObserver observer) {
        System.out.println(TAG + observer.getClass().getName());
        synchronized (this) {
            return (observers.contains(observer)) ? observers.remove(observer) : false;
        }
    }


    public void notifyObservers() {

        System.out.println(TAG+"number of observers :" + observers.size());
        List<CustomObserver> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (this) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (CustomObserver obj : observersLocal) {
            System.out.println(TAG+"observer "+obj.getClass().getName());
            obj.update(obj, message);
        }
    }

    //method to post message to the topic
    public void postMessage(String msg) {
        System.out.println(TAG+"Message Posted to Topic: " + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }


}
