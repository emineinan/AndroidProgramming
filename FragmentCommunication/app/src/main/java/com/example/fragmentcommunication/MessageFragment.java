package com.example.fragmentcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    OnMessageSendListener messageSendListener;
    private Button sendButton;
    private EditText edText;

    public interface OnMessageSendListener //this function's name is depend on you so you can change.
    {
        public void onMessageSend(String message);
    }


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_message, container, false);
        sendButton=view.findViewById(R.id.button);
        edText=view.findViewById(R.id.editText);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String message=edText.getText().toString();
             messageSendListener.onMessageSend(message);
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity=(Activity) context;

        try{
             messageSendListener = (OnMessageSendListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }

    }
}
