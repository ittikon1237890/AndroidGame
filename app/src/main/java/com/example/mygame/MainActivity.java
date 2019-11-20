package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btstart = findViewById(R.id.buttonStartGame);
        Button btviewhighscore = findViewById((R.id.buttonViewHighscore));

        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data data = new Data();

                Intent startgame = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(startgame);
                finish();
            }
        });

        btviewhighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewhighscore = new Intent(MainActivity.this, HighScoreActivity.class);
                startActivity(viewhighscore);
            }
        });

    }
}
