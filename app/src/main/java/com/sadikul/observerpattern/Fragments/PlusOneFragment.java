package com.sadikul.observerpattern.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.plus.PlusOneButton;
import com.sadikul.observerpattern.CustomObserver.CustomObservable;
import com.sadikul.observerpattern.CustomObserver.CustomObserver;
import com.sadikul.observerpattern.ObserverPattern.Observer;
import com.sadikul.observerpattern.ObserverPattern.Subject;
import com.sadikul.observerpattern.R;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link PlusOneFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlusOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlusOneFragment extends Fragment implements CustomObserver {
    private Subject topic;

    public static final String TAG = "<<TAGFragmentOne>>";
    private static TextView tvFragmentOne;
    public PlusOneFragment() {
        // Required empty public constructor
    }

    public static PlusOneFragment newInstance(String param1, String param2) {
        PlusOneFragment fragment = new PlusOneFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);
        CustomObservable.getmInstance().register(this);
        //Find the +1 button
        tvFragmentOne = view.findViewById(R.id.fragment_one_text);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }





    @Override
    public void update(CustomObserver obj, String message) {

        Log.d(TAG,message);

        if(message == null){
            System.out.println(TAG+":: No new message");
        }else {
            if(this.tvFragmentOne != null){
                this.tvFragmentOne.setText(message);
            }else{
                System.out.println(TAG+":: null object") ;
            }

        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
