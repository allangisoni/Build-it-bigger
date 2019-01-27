package com.example.android.jokeralib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowJokes extends AppCompatActivity {

    String displayJoke = "";
    @BindView(R.id.tvJoke) TextView tvJokes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jokes);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        displayJoke = intent.getStringExtra("passedJoke");
         if (displayJoke != null){
         tvJokes.setText(displayJoke);
         } else{
             tvJokes.setText("No joke found in Java lib");
         }
    }
}
