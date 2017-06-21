package com.example.mercimek.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActiviy extends AppCompatActivity {

    TextView Suggestion,trueedit,falseedit,scoreedit,emptyedit;
    Button GO;
    Bundle data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_activiy);
        trueedit=(TextView)findViewById(R.id.trueedit);
        falseedit=(TextView)findViewById(R.id.falseedit);
        scoreedit=(TextView)findViewById(R.id.scoreedit);
        Suggestion=(TextView)findViewById(R.id.Suggestion);
        emptyedit=(TextView)findViewById(R.id.emptyedit);
        GO=(Button)findViewById(R.id.GO);

         data = getIntent().getExtras();
        trueedit.setText(String.valueOf(data.getInt("numberofTrue")));
        falseedit.setText(String.valueOf(data.getInt("numberofFalse")));
        scoreedit.setText(String.valueOf(data.getDouble("score")));
        emptyedit.setText(String.valueOf(5-(data.getInt("numberofTrue")+data.getInt("numberofFalse"))));

        if(data.getDouble("score")<0){
            Suggestion.setText("Your result is bad.We suggest Teaching part!!");
        }
        else{
            Suggestion.setText("Succesfull");
        }


        GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.getDouble("score")<0){
                    Intent i=new Intent(ScoreActiviy.this,Teach.class);
                    startActivity(i);
                }
                else{
                    Intent i=new Intent(ScoreActiviy.this,MainActivity.class);
                    startActivity(i);

                }



            }
        });


    }
}
