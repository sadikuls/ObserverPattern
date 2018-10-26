package com.sadikul.observerpattern.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sadikul.observerpattern.ObserverPattern.Observer;
import com.sadikul.observerpattern.ObserverPattern.Subject;
import com.sadikul.observerpattern.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment implements Observer {
    private Subject topic;
    public static TextView fragTwoText;
    public static final String TAG = "<<TAGFragmentTwo>>";

    public FragmentTwo() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"oncreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG,"onViewCreated");
        //Inflate the layout for this fragment
        fragTwoText = (TextView) view.findViewById(R.id.fragment_two_text);

    }

    @Override
    public void update() {

        String msg = (String) topic.getUpdate(this);

        Log.d(TAG,msg);

        if(msg == null){
            System.out.println(TAG+":: No new message");
        }else {
            if(this.fragTwoText != null){
                this.fragTwoText.setText(msg);
            }else{
                System.out.println(TAG+":: null object") ;
            }

        }
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic = sub;
    }
}
