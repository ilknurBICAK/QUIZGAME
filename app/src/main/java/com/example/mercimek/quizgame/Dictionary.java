package com.example.mercimek.quizgame;

import java.io.Serializable;

/**
 * Created by mercimek on 14.04.2017.
 */
public class Dictionary implements Serializable {

    String mean;
    String word;




    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }



    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }



    public Dictionary(String word, String mean) {

        this.word = word;
        this.mean = mean;
    }





}