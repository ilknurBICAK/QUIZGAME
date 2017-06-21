package com.example.mercimek.quizgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Add extends AppCompatActivity {
    EditText word,meaning;
    Button add,finish;
    TextView t,t1;
    ArrayList<Dictionary> d;
   Database database;
    boolean flag;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database=new Database(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        word=(EditText)findViewById(R.id.word);
        meaning=(EditText)findViewById(R.id.mean);
        finish=(Button)findViewById(R.id.exit) ;
        t=(TextView)findViewById(R.id.textword);
        t1=(TextView)findViewById(R.id.textmean) ;
        final Bundle data = getIntent().getExtras();
        d=(ArrayList<Dictionary>)data.getSerializable("dictionary");

        sharedPreferences = this.getSharedPreferences("Dictionary", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        add=(Button)findViewById(R.id.buttonadd);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                if(!word.getText().toString().equals("") && !meaning.getText().toString().equals("")){

                    for(int i=0;i<d.size();i++){
                        if(d.get(i).getWord().equals(word.getText().toString())){
                            Toast.makeText(getApplicationContext(),"\n" + "AVAILABLE",Toast.LENGTH_SHORT).show();
                           flag=false;
                            break;

                        }

                    }
                    if(flag==true){

                        database.Add(word.getText().toString(),meaning.getText().toString());
                        d=database.getThat();
                        Intent i=new Intent(Add.this,Teach.class);
                        i.putExtra("adding",d);



                       Toast.makeText(getApplicationContext(),"ADDING",Toast.LENGTH_SHORT).show();}



                }
                else{

                    if(word.getText().toString().equals("") && meaning.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"PLEASE, ENTER WORD AND MEANING",Toast.LENGTH_LONG).show();

                    }
                    else if(word.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"PLEASE, ENTER WORD",Toast.LENGTH_LONG).show();}

                    else if( meaning.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"PLEASE, ENTER MEANING",Toast.LENGTH_LONG).show(); }

                }

                }



        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Add.this,MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
            }
        });

    }




}
