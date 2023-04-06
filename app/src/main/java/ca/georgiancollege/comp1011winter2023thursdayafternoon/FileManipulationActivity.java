package ca.georgiancollege.comp1011winter2023thursdayafternoon;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileManipulationActivity extends BaseActivity {

    private final String filename = "myfile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manipulation);

        try{
            readContents();
            popUpMessage("Successfully read file");
        }
        catch (Exception e){
            popUpMessage("Could not read file");
        }
    }


    public void onSaveClick(View view){

        EditText toWrite = findViewById(R.id.contentToWrite);

        try{
            writeContents(toWrite.getText().toString());
            popUpMessage("Successfully written to file");
            readContents();
            toWrite.setText("");
        }
        catch (Exception e){
            popUpMessage("Could not write to file");
        }



    }
    public void onClearClick(View view){
        try{
            FileOutputStream fos = getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write("".getBytes());

            popUpMessage("Successfully cleared file");
        }
        catch (Exception e){
            popUpMessage("Could not clear file");
        }
    }

    private void readContents() throws Exception{

        EditText sendTo = findViewById(R.id.fileContent);

        StringBuilder sb = new StringBuilder();

        FileInputStream fis = openFileInput(filename);

        Scanner scanner = new Scanner(fis);

        while(scanner.hasNext()){
            sb.append(scanner.nextLine()).append(". ");
        }
        scanner.close();


        sendTo.setText(sb.toString());


    }
    private void writeContents(String content) throws Exception{
        FileOutputStream fos = getApplicationContext().openFileOutput(filename, Context.MODE_APPEND);
        fos.write(content.getBytes());


    }
}