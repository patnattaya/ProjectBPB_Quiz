package com.example.hp.projectbpb_quiz;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.projectbpb_quiz.model.Quiz;

public class QuizDataDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_data_details);

        ImageView animalImageView = (ImageView)findViewById(R.id.animalImageView);
        TextView detailTextView = (TextView)findViewById(R.id.detailTextView);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        QuizData quizData = QuizData.getInstance();
        Quiz quiz = quizData.quizDataList.get(position);

        String name = quiz.name;
        String detail = quiz.detail;
        Drawable drawable = quiz.getPictureDrawable(this);

        animalImageView.setImageDrawable(drawable);
        detailTextView.setText(detail);

        getSupportActionBar().setTitle(name);
    }
}
