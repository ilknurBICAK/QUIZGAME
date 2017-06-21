package com.example.mercimek.quizgame;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Teach extends AppCompatActivity {

    TextView word;
    Button mean,forward,rearward;

    ArrayList<Dictionary> d;
    ArrayList<Dictionary> d2;
    ArrayList<Dictionary> d3;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach);
        Bundle data = getIntent().getExtras();

        d= (ArrayList<Dictionary>) data.getSerializable("dictionary");



        word=(TextView)findViewById(R.id.word);
        mean=(Button)findViewById(R.id.mean);
        forward=(Button)findViewById(R.id.forward);
        rearward=(Button)findViewById(R.id.rearward);
        word.setText(d.get(i).getWord());

        mean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mean.setText(d.get(i).getMean());

            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mean.setText("click and learn :)");
                i++;
                if(i<d.size()){
                word.setText(d.get(i).getWord());}
                else{
                    i=0;
                    word.setText(d.get(i).getWord());
                }

            }
        });
        rearward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mean.setText("click and learn :)");
                i--;
                if(i<0){
                    i=d.size()-1;
                    word.setText(d.get(i).getWord());

                }
                else{
                    word.setText(d.get(i).getWord());
                }
            }
        });





    }



}
