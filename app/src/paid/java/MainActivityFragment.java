package com.udacity.gradle.builditbigger.paid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.R;

public class MainActivityFragment extends Fragment {


    ProgressBar progressBar = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_main_fragment, container, false);


        progressBar = (ProgressBar) root.findViewById(R.id.joke_progressbar);


        return root;
    }


}
