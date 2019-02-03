package com.udacity.gradle.builditbigger;

import android.support.annotation.UiThread;

public interface JokelistenerInterface {

    @UiThread
    void onSearchJokeStart();

    @UiThread
    void onSearchJokeFinish( String result);
}
