package com.example.hp.projectbpb_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstMainActivity extends AppCompatActivity {
    private Button mExit;
    private Button mStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_main);

        mExit = findViewById(R.id.exit_button);
        mStart = findViewById(R.id.start_button);

        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstMainActivity.this,select.class);
                startActivity(intent);
            }
        });


    }
}
