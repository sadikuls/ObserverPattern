package com.sadikul.observerpattern;

import android.app.Activity;
import android.content.Context;
import android.drm.DrmStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.sadikul.observerpattern.CustomObserver.CustomObservable;
import com.sadikul.observerpattern.Fragments.FragmentTwo;
import com.sadikul.observerpattern.Fragments.PlusOneFragment;
import com.sadikul.observerpattern.ObserverPattern.MyTopic;
import com.sadikul.observerpattern.ObserverPattern.MyTopicSubscriber;
import com.sadikul.observerpattern.ObserverPattern.Observer;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {


    //create subject
    MyTopic topic = new MyTopic();

    EditText inputEdittext = null;
    Button btnSubmit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inputEdittext = findViewById(R.id.editText_input_text);




/*
        //create observers
        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new FragmentTwo();
        Observer obj3 = new PlusOneFragment();

        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        //attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);
*/


     /*   //check if any update is available
        obj1.update();
        obj2.update();
        obj3.update();*/

        inputEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                CustomObservable.getmInstance().postMessage(inputEdittext.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }


}
