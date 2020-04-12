package com.example.fragmentcommunication;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    private TextView tvDisplay;
    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_display, container, false);
       tvDisplay=view.findViewById(R.id.txtDisplay);
       Bundle bundle=getArguments();
       String message=bundle.getString("message");
       tvDisplay.setText(message);
       return view;
    }

}
