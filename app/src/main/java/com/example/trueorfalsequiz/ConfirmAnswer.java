package com.example.trueorfalsequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmAnswer extends AppCompatActivity {

    private Button showAnswer;
    private TextView solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_answer);
        getSupportActionBar().hide();

        showAnswer = (Button) findViewById(R.id.show_answer_btn);
        solution = (TextView) findViewById(R.id.solution_q);

        boolean solutionForCurrentQuestion = getIntent().getExtras().getBoolean("answer");

        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solution.setText("Solution: " + solutionForCurrentQuestion);
            }
        });
    }
}