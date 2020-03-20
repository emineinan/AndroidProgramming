package com.example.sendingtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Message extends AppCompatActivity {
    public TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        tView=findViewById(R.id.textView);

        Intent i2=getIntent();

        String gettingText=i2.getStringExtra("mytext");
        String gettingNmae=i2.getStringExtra("myname");

        tView.setText("Welcome "+gettingNmae+"\nYour message is: "+gettingText);
    }
}
