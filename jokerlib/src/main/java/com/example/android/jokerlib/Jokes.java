package com.example.android.jokerlib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Jokes {

    List<String> jokesList = asList("How do you prevent a summer cold? Catch it in the winter!","Did you hear about the crook who stole a calendar? He got twelve months.",
            "I own the world’s worst thesaurus. Not only is it awful, it’s awful.", "The best thing about good old days is that we were neither good nor old.",
            "I have clean conscience. I haven’t used it once till now.", "If we shouldn’t eat at night, why do they put a light in the fridge?");

    public String tellJoke() {
        int randomInt= new Random().nextInt(3);
        return jokesList.get(randomInt);
    }
}
