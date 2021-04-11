package com.example.trueorfalsequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueBTN;
    private Button falseBTN;
    private Button answerBTN;
    private Button nextBTN;
    private TextView questionNumberTitle;
    private TextView question;
    private int currentQuestion = 0;
    private int score = 0;

    // array of the questions and answers
    private Questions[] setOfQuestion = new Questions[] {
            new Questions(R.string.question1, true),
            new Questions(R.string.question2, false),
            new Questions(R.string.question3, false),
            new Questions(R.string.question4, true),
            new Questions(R.string.question5, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        trueBTN = findViewById(R.id.true_button);
        falseBTN = findViewById(R.id.false_button);
        answerBTN = findViewById(R.id.answer_button);
        nextBTN = findViewById(R.id.next_button);
        questionNumberTitle = findViewById(R.id.questionNumber);
        question = findViewById(R.id.given_question);

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(trueBTN.getId());
            }
        });

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(falseBTN.getId());
            }
        });

        answerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(answerBTN.getId());
            }
        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(nextBTN.getId());
            }
        });
    }

    private void start(int val) {
        switch(val)
        {
            case R.id.true_button:
                checkAnswer(true); break; // call the method and send true
            case R.id.false_button:
                checkAnswer(false); break; // call the method and send false
            case  R.id.answer_button: showSolutionForQuestion(); break;
            case R.id.next_button: goToNextQuestion(); break;
        }
    }

    private void goToNextQuestion() {
        //currentQuestion = (currentQuestion + 1) % setOfQuestion.length; // allow looping over all questions and app not crashing
        currentQuestion++;
        if(currentQuestion >= 0 && currentQuestion <= 4) {
            questionNumberTitle.setText("QUESTION " + (currentQuestion + 1));
            question.setText(setOfQuestion[currentQuestion].getAnswerId());
        }
        else {
            Intent intent = new Intent(this, Gameover.class);
            intent.putExtra("keyname", score);
            startActivity(intent);
        }
    }

    private void checkAnswer(boolean selected) {
        boolean isTrue = setOfQuestion[currentQuestion].isTrue(); // get the answer for the current question (true or false)
        int msgTd = 0;

        // compare with the selected option. If the selected option is equal to the current question's answer then display correct and increment score
        if(selected == isTrue) {
            ++score;
            Log.d("score:", String.valueOf(score));
            msgTd = R.string.correct; // correct answer
            goToNextQuestion();
        }
        else {
            msgTd = R.string.incorrect; // incorrect answer
            goToNextQuestion();
        }

        Toast.makeText(MainActivity.this, msgTd, Toast.LENGTH_SHORT).show();
    }

    private void showSolutionForQuestion() {
        Intent intent = new Intent(this, ConfirmAnswer.class);
        boolean isTrue = setOfQuestion[currentQuestion].isTrue(); // get the answer for the current question (true or false)
        intent.putExtra("answer",  isTrue); // add the solution to an intent
        startActivity(intent);
    }
}