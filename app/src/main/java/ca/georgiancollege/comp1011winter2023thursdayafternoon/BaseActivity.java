package ca.georgiancollege.comp1011winter2023thursdayafternoon;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.zip.Inflater;

public abstract class BaseActivity extends AppCompatActivity {

    /*
    to create a menu
    1) Inflate the menu
    2) Add actions if user clicks on the menu
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent;

        switch (item.getItemId()){

            case R.id.mainMenuItemCal:
                intent = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(intent);
                break;
            case R.id.mainMenuItemPro:
                intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.mainMenuItemFM:
                intent = new Intent(getApplicationContext(), FileManipulationActivity.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

        }

        return true;
    }


}
