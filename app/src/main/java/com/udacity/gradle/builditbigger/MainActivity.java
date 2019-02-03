package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.jokeralib.ShowJokes;
import com.example.android.jokerlib.Jokes;


public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void tellJoke(View view) {
        PullJokesAsyncTask.getInstance(new JokelistenerInterface() {
            @Override
            public void onSearchJokeStart() {

            }

            @Override
            public void onSearchJokeFinish(String result) {

                ShowJokeActivity(result);

            }

        });
    }

    // Open the activity from Android library to show joke
    private void ShowJokeActivity(String result) {
        Intent myIntent = new Intent(context, ShowJokes.class );
        myIntent.putExtra("passedJoke",result);
        context.startActivity(myIntent);
    }





}
