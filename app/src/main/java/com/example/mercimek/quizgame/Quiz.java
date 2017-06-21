package com.example.mercimek.quizgame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {


    Button choose1,choose2,choose3,choose4,finish,forward;
    TextView score,question;
    double recordScore=0.0;
    Random r;
    ArrayList<Dictionary> d;
    String ar[] = new String[4];
    int numberofquestion=0;
    int numberofTrue=0;
    int numberofFalse=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        choose1=(Button)findViewById(R.id.choose1);
        choose2=(Button)findViewById(R.id.choose2);
        choose3=(Button)findViewById(R.id.choose3);
        choose4=(Button)findViewById(R.id.choose4);
        score=(TextView)findViewById(R.id.score);
        choose1.setBackgroundColor(Color.BLUE);
        choose2.setBackgroundColor(Color.BLUE);
        choose3.setBackgroundColor(Color.BLUE);
        choose4.setBackgroundColor(Color.BLUE);

        question=(TextView)findViewById(R.id.question);
        forward=(Button)findViewById(R.id.ileri);
        finish=(Button)findViewById(R.id.bitti);
        Bundle data = getIntent().getExtras();
        d = (ArrayList<Dictionary>) data.getSerializable("dictionary");
        //arrayi karÄ±ÅŸtÄ±rÄ±yoruz
        shuffleArray();
        question.setText(d.get(numberofquestion).getWord());
        //ÅŸÄ±klarÄ± karÄ±ÅŸtÄ±rmak iÃ§in yeni arraya atÄ±rÄ±yoruz.
        for(int i=0;i<4;i++){
            ar[i]=d.get(i).getMean();
        }

        String[]c =shuffleArray2(ar);
        choose1.setText(c[0]);
        choose2.setText(c[1]);
        choose3.setText(c[2]);
        choose4.setText(c[3]);

        choose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d.get(numberofquestion).getMean().equals(choose1.getText().toString())){
                    recordScore=recordScore+1;
                    numberofTrue++;
                    Log.d("reco",String.valueOf(recordScore));
                    choose1.setBackgroundColor(Color.GREEN);
                    score.setText(String.valueOf(recordScore));
                }

                else{
                    numberofFalse++;
                    recordScore=recordScore-0.5;
                    Log.d("reco",String.valueOf(recordScore));
                    score.setText(String.valueOf(recordScore));

                    choose1.setBackgroundColor(Color.RED);
                    if(d.get(numberofquestion).getMean().equals(choose2.getText().toString())){
                        choose2.setBackgroundColor(Color.GREEN);

                    }
                    else if(d.get(numberofquestion).getMean().equals(choose3.getText().toString())){
                        choose3.setBackgroundColor(Color.GREEN);

                    }
                    else{
                        choose4.setBackgroundColor(Color.GREEN);

                    }

                }
            }

        });
        choose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d.get(numberofquestion).getMean().equals(choose2.getText().toString())){
                    recordScore+=1;
                    numberofTrue++;
                    choose2.setBackgroundColor(Color.GREEN);
                    score.setText(String.valueOf(recordScore));
                }

                else{
                    numberofFalse++;
                    recordScore-=0.5;
                    score.setText(String.valueOf(recordScore));
                    choose2.setBackgroundColor(Color.RED);
                    if(d.get(numberofquestion).getMean().equals(choose1.getText().toString())){
                        choose1.setBackgroundColor(Color.GREEN);

                    }
                    else if(d.get(numberofquestion).getMean().equals(choose3.getText().toString())){
                        choose3.setBackgroundColor(Color.GREEN);

                    }
                    else{
                        choose4.setBackgroundColor(Color.GREEN);

                    }

                }
            }

        });


        choose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d.get(numberofquestion).getMean().equals(choose3.getText().toString())){
                    recordScore+=1;
                    numberofTrue++;
                    score.setText(String.valueOf(recordScore));
                    choose3.setBackgroundColor(Color.GREEN);
                }

                else{
                    numberofFalse++;
                    recordScore-=0.5;
                    score.setText(String.valueOf(recordScore));
                    choose3.setBackgroundColor(Color.RED);
                    if(d.get(numberofquestion).getMean().equals(choose2.getText().toString())){
                        choose2.setBackgroundColor(Color.GREEN);

                    }
                    else if(d.get(numberofquestion).getMean().equals(choose3.getText().toString())){
                        choose3.setBackgroundColor(Color.GREEN);

                    }
                    else{
                        choose1.setBackgroundColor(Color.GREEN);

                    }

                }
            }

        });


        choose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d.get(numberofquestion).getMean().equals(choose4.getText().toString())){
                    recordScore+=1;
                    numberofTrue++;
                    score.setText(String.valueOf(recordScore));
                    choose4.setBackgroundColor(Color.GREEN);
                }

                else{
                    recordScore-=0.5;
                    numberofFalse++;
                    score.setText(String.valueOf(recordScore));
                    choose4.setBackgroundColor(Color.RED);
                    if(d.get(numberofquestion).getMean().equals(choose2.getText().toString())){
                        choose2.setBackgroundColor(Color.GREEN);

                    }
                    else if(d.get(numberofquestion).getMean().equals(choose3.getText().toString())){
                        choose3.setBackgroundColor(Color.GREEN);

                    }
                    else{
                        choose1.setBackgroundColor(Color.GREEN);

                    }

                }
            }

        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberofquestion++;

                if(numberofquestion>=5){
                    Intent i=new Intent(Quiz.this,ScoreActiviy.class);
                    Bundle extras = new Bundle();
                    i.putExtra("numberofTrue",numberofTrue);
                    i.putExtra("numberofFalse",numberofFalse);
                    i.putExtra("score",recordScore);
                    i.putExtras(extras);
                    startActivity(i);

                }
                else{

                    if(numberofquestion==4){

                    }

                    choose1.setBackgroundColor(Color.BLUE);
                    choose2.setBackgroundColor(Color.BLUE);
                    choose3.setBackgroundColor(Color.BLUE);
                    choose4.setBackgroundColor(Color.BLUE);

                    Log.d("numberog",String.valueOf(numberofquestion));
                    question.setText(d.get(numberofquestion).getWord());
                    Log.d("question",d.get(numberofquestion).getWord());
                    ar[0]=d.get(numberofquestion).getMean();
                    int j=1;
                    int random=0;
                    boolean flag=true;

                    while(j<4){

                        r=new Random();
                        random=r.nextInt(d.size());
                        for(int i=0;i<3;i++){


                            if(ar[i].equals(d.get(random).getMean())){
                                flag=false;
                                break;

                            }

                        }//for bitti
                        if(flag==true) {

                            ar[j] = d.get(random).getMean();
                            j++;
                        }
                    }//while bitti


                    String[]c =shuffleArray2(ar);
                    choose1.setText(c[0]);
                    choose2.setText(c[1]);
                    choose3.setText(c[2]);
                    choose4.setText(c[3]);




                }


            }


        });



        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Quiz.this,ScoreActiviy.class);
                Bundle extras = new Bundle();
                i.putExtra("numberofTrue",numberofTrue);
                i.putExtra("numberofFalse",numberofFalse);
                i.putExtra("score",recordScore);
                i.putExtras(extras);
                startActivity(i);

            }
        });


    }





    public void shuffleArray()
    {
        r=new Random();

        for (int i = d.size() - 1; i > 0; i--)
        {
            int index = r.nextInt(i + 1);
            // Simple swap
            String a = d.get(index).getWord();
            String mean=d.get(index).getMean();
            d.get(index).setWord(d.get(i).getWord());
            d.get(index).setMean(d.get(i).getMean());
            d.get(i).setWord(a);
            d.get(i).setMean(mean);

        }
    }
    public String[] shuffleArray2(String[] ar)
    {
        r=new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = r.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;

    }
}
