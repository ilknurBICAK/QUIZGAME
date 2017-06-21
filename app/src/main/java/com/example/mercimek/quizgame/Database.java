package com.example.mercimek.quizgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mercimek on 16.04.2017.
 */
public class Database   extends SQLiteOpenHelper  implements Serializable {
    private static final String ID="id";
    private static final String Word="word";
    private static final String  Mean="mean";
    private static final String DB_name = "DICTIONARY";
    private static final String DB_table="dictionary";
    private static final int version = 1;
    ArrayList<Dictionary> dict;

    public Database(Context cont){

      super(cont,DB_name,null,version);
        Add("belong","AÝT OLMAK");Add("table","MASA");
        Add("talk","KONUÞMAK");Add("school","OKUL");
        Add("science","BÝLÝM");Add("RACE","YARIÞ");
        Add("rain","YAÐMUR");Add("read","OKUMAK");
        Add("page","SAYFA");Add("number","SAYI");
        Add("noun","ÝSÝM");Add("mean","ANLAM");
        Add("lake","GÖL");Add("king","KRAL");
        Add("key","ANAHTAR");
        Add("law","KANUN");
        Add("now","ÞÝMDÝ");
        Add("map","HARÝTA");
        Add("picture","RESÝM");
        Add("plane","UÇAK");
        Add("ocean","OKYONUS");
        Add("sea","DENÝZ");
        Add("boss","PATRON");
        Add("borrow","ÖDÜNÇ ALMAK");
        Add("cheese","PEYNÝR");
        Add("choice","SEÇÝM");
        Add("year","YIL");
        Add("young","GENÇ");
        Add("walk","YÜRÜMEK");
        Add("wall","DUVAR");
        Add("wash","YIKAMAK");
        Add("water","SU");
        Add("west","BATI");
        Add("wheel","TEKERLEK");
        Add("uncle","AMCA");


    }


            @Override
            public void onCreate(SQLiteDatabase db) {  // Databesi olu?turuyoruz.Bu methodu biz ça??rm?yoruz. Databese de obje olu?turdu?umuzda otamatik ça??r?l?yor.
                String CREATE_TABLE = "CREATE TABLE " + DB_table + "("
                        + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + Word + " TEXT,"
                        + Mean + " TEXT"+ ")";
                db.execSQL(CREATE_TABLE);
            }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)

    {
        db.execSQL("DROP TABLE IF EXIST dictionary");
        System.out.print("buryaa grdm");
        onCreate(db);

    }


    public void Add(String word, String mean){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Word,word);
        values.put(Mean,mean);
        db.insert(DB_table,null,values);
        db.close();

    }
    public ArrayList<Dictionary> getThat(){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_table;
       dict= new ArrayList<Dictionary>();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row

            for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){

            dict.add(new Dictionary(cursor.getString(1),cursor.getString(2)));}


        cursor.close();
        db.close();
        return dict;


    }

}





