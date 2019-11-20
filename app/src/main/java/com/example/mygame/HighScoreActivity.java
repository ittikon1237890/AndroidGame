package com.example.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HighScoreActivity extends AppCompatActivity {
    ListView highscorelistview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        Button btbackhighscore = (Button) findViewById(R.id.buttonBackHighScore);


        btbackhighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtomain = new Intent(HighScoreActivity.this,MainActivity.class);
                startActivity(backtomain);
                finish();
            }
        });

        highscorelistview = (ListView) findViewById(R.id.highscore_ListView);

        ScoreDAO scoreDAO= new ScoreDAO(getApplicationContext());
        scoreDAO.open();
        ArrayList<String> myList = scoreDAO.getAllHighScore();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,myList);
        highscorelistview.setAdapter(adapter);
        scoreDAO.close();
    }
}
