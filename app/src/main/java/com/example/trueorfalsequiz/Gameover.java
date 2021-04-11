package com.example.trueorfalsequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gameover extends AppCompatActivity {

    private Button playAgain;
    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        getSupportActionBar().hide();

        playAgain = (Button) findViewById(R.id.play_again_btn);
        scoreText = (TextView) findViewById(R.id.final_score);

        int score = getIntent().getIntExtra("keyname", 0);

        scoreText.setText("Your score: " + score + "/5");


        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent); // return to main activity
            }
        });
    }
}