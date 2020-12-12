package com.example.andriod.aggregatescalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class NustEngineering extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nust_engineering);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        display = (TextView) findViewById(R.id.textView2);


    }

    public void button (View view) {

        float num1 = 0;
        float num2 = 0;
        float num3 = 0;
        float totalInScc = 1050;



        // check if the fields are empty
        if (TextUtils.isEmpty(editText1.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())  || TextUtils.isEmpty(editText3.getText().toString())) {
            display.setText("Please enter your marks.");
            return;
        }



        CheckBox sscTotal1100 = (CheckBox) findViewById(R.id.total1100);
        boolean sscTotal1100Checked = sscTotal1100.isChecked();
        if (sscTotal1100Checked){
            totalInScc = 1100;
        }







        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(editText1.getText().toString());
        num2 = Float.parseFloat(editText2.getText().toString());
        num3 = Float.parseFloat(editText3.getText().toString());







        // check if the numbers are entered correctly
        if ( num1 > 200 || num2 > 1100  || num3 > 1100) {
            display.setText("Please enter marks correctly.");
            return;
        }





        float calculatedAggregate = calculateAggregate(num1, num2 ,num3, totalInScc);
        String toBeDisplayed = Float.toString(calculatedAggregate);


        display.setText(toBeDisplayed + "%");

    }



    private float calculateAggregate (float a , float b, float c , float sscTotal){
        float netPart = (a/200)*75;
        float fscPart = (b/1100)*15;
        float sscPart = (c/sscTotal)*10;
        float totalAggregate = netPart + fscPart + sscPart;
        return totalAggregate;
    }


    public void forOtherUniversities(View view) {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

}
