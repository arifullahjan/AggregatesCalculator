package com.example.andriod.aggregatescalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Uet extends AppCompatActivity {

    EditText editTextFsc;
    EditText editTextEcat;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uet);



        editTextFsc = (EditText) findViewById(R.id.marksInFsc);
        editTextEcat = (EditText) findViewById(R.id.marksInEcat);
        display = (TextView) findViewById(R.id.displayTextView);

    }
    public void buttonUet (View view) {

        float fsc = 0;
        float ecat = 0;


        // check if the fields are empty
        if (TextUtils.isEmpty(editTextFsc.getText().toString()) || TextUtils.isEmpty(editTextEcat.getText().toString())  ) {
            display.setText("Please enter your marks.");
            return;
        }







        // read EditText and fill variables with numbers
        fsc = Float.parseFloat(editTextFsc.getText().toString());
        ecat = Float.parseFloat(editTextEcat.getText().toString());







        // check if the numbers are entered correctly
        if ( fsc > 1100 || ecat > 400 ) {
            display.setText("Please enter marks correctly.");
            return;
        }





        float calculatedAggregate = calculateAggregate(fsc, ecat);
        String toBeDisplayed = Float.toString(calculatedAggregate);


        display.setText(toBeDisplayed + "%");

    }



    private float calculateAggregate (float a , float b ){
        float fscPart = (a/1100)*70;
        float ecatScore = (b/400)*30;
        float totalAggregate = ecatScore + fscPart;
        return totalAggregate;
    }
}






















