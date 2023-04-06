package ca.georgiancollege.comp1011winter2023thursdayafternoon;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedItemID = view.getId();

                //Intent: view or screen of android app
                Intent intent;

                //ImageView which = findViewById(selectedItemID);


                Snackbar.make(view, "Hello", Snackbar.LENGTH_LONG).show();
                switch (selectedItemID){
                    case R.id.imageMainActivityCal:
                        intent = new Intent(getApplicationContext(), CalculatorActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.imageMainActivityFM:
                        intent = new Intent(getApplicationContext(), FileManipulationActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.imageMainActivityPro:
                        intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        intent.putExtra("fun", "hello!");
                        startActivity(intent);
                        break;
                    default:
                        Snackbar.make(view, "Unknown item selected", Snackbar.LENGTH_LONG).show();
                }

            }
        };

        //document.getElementById
        //R = resources => all media (elements, strings, any type of media(
        //.id = all resource IDs

        ImageView cal = findViewById(R.id.imageMainActivityCal);
        ImageView pro = findViewById(R.id.imageMainActivityPro);
        ImageView fm = findViewById(R.id.imageMainActivityFM);



        cal.setOnClickListener(onClickListener);
        pro.setOnClickListener(onClickListener);
        fm.setOnClickListener(onClickListener);


    }
}