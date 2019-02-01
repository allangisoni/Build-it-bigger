package com.example.android.jokeralib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;




public class ShowJokes extends AppCompatActivity {

    String displayJoke = "";
    TextView tvJokes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jokes);

        tvJokes = findViewById(R.id.tvJoke);
      // ButterKnife.bind(this);

        Intent intent = getIntent();
        displayJoke = intent.getStringExtra("passedJoke");
         if (displayJoke != null){
         tvJokes.setText(displayJoke);
         } else{
             tvJokes.setText("No joke found in Java lib");
         }
    }
}
