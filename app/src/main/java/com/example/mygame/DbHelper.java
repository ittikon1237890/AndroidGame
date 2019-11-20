package com.example.mygame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String mdatabaseName = "highscore.sqlite";
    private static final int mdatabaseVersion = 1;
    Context mcontext;

    private static final String tableCreateSQL = "CREATE TABLE high_score ("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "score TEXT"+
            //"score TEXT"+
            ");";

    public DbHelper(@Nullable Context context) {
        super(context,mdatabaseName,null,mdatabaseVersion);
        this.mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreateSQL);
        //String insertData1 = "INSERT INTO high_score (score) VALUES ('Test Man');";
        //String insertData2 = "INSERT INTO high_score (score) VALUES ('9999');";
        //db.execSQL(insertData1);
        //db.execSQL(insertData2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
