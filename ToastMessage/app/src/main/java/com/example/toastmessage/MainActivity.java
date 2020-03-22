package com.example.toastmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText edMessage;
   Button butMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMessage=findViewById(R.id.editMessage);
        butMessage=findViewById(R.id.buttonMessage);

       butMessage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Toast.makeText(MainActivity.this, "You writed: "+edMessage.getText().toString(), Toast.LENGTH_SHORT).show();


           }
       });
}
}
