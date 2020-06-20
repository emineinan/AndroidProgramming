package com.example.chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int count;
    Runnable runnable;
    Handler handler;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        count=0;

    }

    public void start(View view){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: "+count);
                count++;
                textView.setText("Time: "+count);
                handler.postDelayed(runnable,1000);

            }
        };
        handler.post(runnable);
        button.setEnabled(false);
 }

    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        count=0;
        textView.setText("Time: "+count);



    }


}
