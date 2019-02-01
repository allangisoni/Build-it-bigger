import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.PullJokesAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class PullJokesAsyncTest {

    @Test
    public void testDoInBackground() throws Exception {
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.testFlag = true;
        new PullJokesAsyncTask().execute(fragment);
        Thread.sleep(5000);
        assertTrue("Error: Fetched Joke = " + fragment.jokeLoaded, fragment.jokeLoaded != null);
    }

}
