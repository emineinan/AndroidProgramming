package com.example.sendingtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public Button mesButton;
    public EditText edText,edName;
    String text, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesButton=findViewById(R.id.messageButton);//we define our button.
        edText=findViewById(R.id.editText);//we define our editText.
        edName=findViewById(R.id.editName);

        mesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text=edText.getText().toString();
                name=edName.getText().toString();

                Intent i=new Intent(MainActivity.this, Message.class);
                i.putExtra("mytext",text);
                i.putExtra("myname",name);
                startActivity(i);
            }
        });
    }
}
