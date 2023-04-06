package ca.georgiancollege.comp1011winter2023thursdayafternoon;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CalculatorActivity extends BaseActivity {

    private EditText calcResults;
    private CalcModel model = new CalcModel();

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button current = (Button) findViewById(view.getId());
            String buttonText = current.getText().toString();

            //calcResults.setText(buttonText);
            model.buttonPressed(buttonText);
            //get the result
            calcResults.setText(model.getResult());
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calcResults = findViewById(R.id.calcResults);
        calcResults.setText("0");
        Button eventToAddToButton;



        for(int i = 1; i <= 16; i++){
            int resourceId = getResources().getIdentifier("button" + i, "id", getPackageName());
            eventToAddToButton = findViewById(resourceId);

            eventToAddToButton.setOnClickListener(onClickListener);
        }

    }


}