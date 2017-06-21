package com.example.mercimek.quizgame;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Database database;
    Button btn1,exit;
    Button btn2;
    Button btn3;
    ArrayList<Dictionary> dictionaries;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exit=(Button)findViewById(R.id.exit);


        btn1= (Button) findViewById(R.id.button1);
        btn2= (Button) findViewById(R.id.button2);
        btn3= (Button) findViewById(R.id.button3);
        database=new Database(this);
        dictionaries=database.getThat();



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Teach.class);
                i.putExtra("dictionary",dictionaries);
                startActivity(i);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Add.class);
                i.putExtra("dictionary",dictionaries);
                startActivity(i);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Quiz.class);
                i.putExtra("dictionary",dictionaries);
                startActivity(i);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
                System.exit(0);
            }
        });

    }
}
