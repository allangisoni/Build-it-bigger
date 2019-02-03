package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.JokelistenerInterface;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class PullJokesAsyncTaskFree extends AsyncTask<Context, Void, String> {

    private static MyApi myApiService = null;
    private Context context;
    private com.udacity.gradle.builditbigger.free.MainActivityFragment mainActivityFragment;
    private JokelistenerInterface jokelistenerInterface;


    private PullJokesAsyncTaskFree(JokelistenerInterface myjokelistenerInterface){
        jokelistenerInterface = myjokelistenerInterface;
    }

   public static void getInstance(JokelistenerInterface listener) {
        new PullJokesAsyncTaskFree(listener).execute();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        jokelistenerInterface.onSearchJokeStart();
    }

    @Override
    protected String doInBackground(Context... mainActivityFragments) {

        if(myApiService == null) {
            MyApi.Builder builder = new
                    MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }


        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {

            Log.e("PullJokesAsyncTask", e.getMessage());
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        jokelistenerInterface.onSearchJokeFinish(result);
    }
}
