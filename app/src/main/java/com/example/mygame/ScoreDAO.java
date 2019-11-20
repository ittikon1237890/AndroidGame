package com.example.mygame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ScoreDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public ScoreDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }
    public  void close(){
        dbHelper.close();
    }

    public ArrayList<String> getAllHighScore(){
        ArrayList<String> highScore = new ArrayList<String>();
        Cursor cursor = database.rawQuery("SELECT * FROM high_score;",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            highScore.add(cursor.getString(1));
            cursor.moveToNext();
            //highScore.add(cursor.getString(2));
        }
        cursor.close();
        return highScore;
    }

    public void add(String score){
        Score newScore = new Score();
        ContentValues values = new ContentValues();
        values.put("score",score);
        this.database.insert("high_score",null,values);

    }
}

