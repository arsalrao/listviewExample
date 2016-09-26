package com.boost.entertainment.listviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.listview);
        Button insertButton = (Button) findViewById(R.id.insert);
        final EditText nameText = (EditText) findViewById(R.id.edittext);
        //creating Arraylist

        ArrayList<String> names = new ArrayList<>();

        //unfortunately ArrayAdapter not provide two or more views so I create custom Adapter

        final CustomAdapter  adapter = new CustomAdapter(this , R.layout.name_view , R.id.list_name, names);

        listView.setAdapter(adapter);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString() ;
                adapter.add(name);
                nameText.setText("");
                Toast.makeText(MainActivity.this, name+" is added", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                


            }
        });



    }





}
