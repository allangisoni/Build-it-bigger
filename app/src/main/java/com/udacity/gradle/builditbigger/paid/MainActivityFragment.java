package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.android.jokeralib.ShowJokes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.PullJokesAsyncTask;
import com.udacity.gradle.builditbigger.R;

public class MainActivityFragment extends Fragment {


    ProgressBar progressBar = null;
    public String jokeLoaded = null;
    public boolean testFlag = false;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_main_fragment, container, false);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        Button button = (Button) root.findViewById(R.id.btnJoke);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                fetchJoke();
            }
        });

        progressBar = (ProgressBar) root.findViewById(R.id.joke_progressbar);
        progressBar.setVisibility(View.GONE);


        return root;
    }

    public void fetchJoke(){

        new PullJokesAsyncTask().execute();
    }

    public void launchShowJokeActivity(){
        if(!testFlag){
            Context context = getActivity();
            Intent intent = new Intent(context, ShowJokes.class);
            intent.putExtra("passedJoke", jokeLoaded);
            //Toast.makeText(context, loadedJoke, Toast.LENGTH_LONG).show();
            context.startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }
    }
}
