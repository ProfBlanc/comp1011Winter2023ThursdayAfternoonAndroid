package ca.georgiancollege.comp1011winter2023thursdayafternoon;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //use threads

        //create a runnable that navigates to the Main Activity

        Runnable task = () ->{

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        };

        //schedule this runnable to execute after 3 seconds
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.schedule(task, 3, TimeUnit.SECONDS);


    }
}