package com.example.flowerbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> nameArray;
    ArrayList<Integer> idArray;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        nameArray=new ArrayList<String>();
        idArray=new ArrayList<Integer>();

        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,nameArray);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent=new Intent(MainActivity.this,Main2Activity.class);
               intent.putExtra("flowerId",idArray.get(i));
               intent.putExtra("info","old");
               startActivity(intent);
            }
        });

        getData();
    }

    public void getData(){
    try{
        SQLiteDatabase database=this.openOrCreateDatabase("Flowers",MODE_PRIVATE,null);

        Cursor cursor=database.rawQuery("SELECT * FROM flowers",null);
        int nameIx=cursor.getColumnIndex("flowername");
        int idIx=cursor.getColumnIndex("id");

        while(cursor.moveToNext()){
            nameArray.add(cursor.getString(nameIx));
            idArray.add(cursor.getInt(idIx));
        }
        arrayAdapter.notifyDataSetChanged();
        cursor.close();

    }catch (Exception e){

    }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //we determine which menu we show in this activity.
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.addflowermenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//we determine what to do if the user chooses any item.
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("info","new");
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
