import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.JokelistenerInterface;
import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.PullJokesAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class PullJokesAsyncTest implements JokelistenerInterface {

    private String myJoke = null;
    private CountDownLatch myCountDownLatch;


    @Test
    public void AsyncTest() {
        try {
            myCountDownLatch = new CountDownLatch(1);
            PullJokesAsyncTask.getInstance(this);
            myCountDownLatch.await(15, TimeUnit.SECONDS);

            assertNotNull("Joke is null", myJoke);
            assertFalse("Joke is empty", myJoke.isEmpty());
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
    }





    @Override
    public void onSearchJokeStart() {

    }

    @Override
    public void onSearchJokeFinish(String result) {
      myJoke = result;
      myCountDownLatch.countDown();
    }
}
