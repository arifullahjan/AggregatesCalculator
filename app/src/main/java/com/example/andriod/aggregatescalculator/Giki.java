package com.example.andriod.aggregatescalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Giki extends AppCompatActivity {

    EditText aax;
    EditText aay;
    EditText aaz;
    EditText bbx;
    EditText bby;
    EditText bbz;
    TextView displayForValueOfX;
    TextView displayForValueOfY;
    TextView displayForAlert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giki);


        aax = (EditText) findViewById(R.id.aX);
        aay = (EditText) findViewById(R.id.aY);
        aaz = (EditText) findViewById(R.id.aZ);
        bbx = (EditText) findViewById(R.id.bX);
        bby = (EditText) findViewById(R.id.bY);
        bbz = (EditText) findViewById(R.id.bZ);
        displayForValueOfX = (TextView) findViewById(R.id.displayTextViewForX);
        displayForValueOfY = (TextView) findViewById(R.id.displayTextViewForY);
        displayForAlert = (TextView) findViewById(R.id.alertBox);


    }

    public  void calculateValuesOfXandY (View view){
        int ax = 0;
        int ay = 0;
        int az = 0;
        int bx = 0;
        int by = 0;
        int bz = 0;





        // check if the fields are empty
        if (TextUtils.isEmpty(aax.getText().toString())
                || TextUtils.isEmpty(aay.getText().toString())
                || TextUtils.isEmpty(aaz.getText().toString())
                || TextUtils.isEmpty(bbx.getText().toString())
                || TextUtils.isEmpty(bby.getText().toString())
                || TextUtils.isEmpty(bbz.getText().toString())) {

            displayForAlert.setText("!!!!!!!!!!!! If any coefficient is 0 , please do enter it. !!!!!!!!!!!");
            return;
        }





        // read EditText and fill variables with numbers
        ax = Integer.parseInt(aax.getText().toString());
        ay = Integer.parseInt(aay.getText().toString());
        az = Integer.parseInt(aaz.getText().toString());
        bx = Integer.parseInt(bbx.getText().toString());
        by = Integer.parseInt(bby.getText().toString());
        bz = Integer.parseInt(bbz.getText().toString());



        // calculating determinants.......
        int d = calculateDeterminant(ax, ay, bx, by);
        int dx = calculateDeterminant(az, ay, bz, by);
        int dy = calculateDeterminant(ax,az, bx, bz);

        //calculating and displaying vaues......./////////////////////////////////////////////////////////
        int calculatedValueOfX = dx/d;
        String stringForX = dx + "/" + d;
        if(dx%d > 0) {
            displayForValueOfX.setText("X = " + stringForX);
        }
        else {
            displayForValueOfX.setText("X = " + calculatedValueOfX);
        }

        //.........


        int calculatedValueOfY = dy/d;
        String stringForY = dy + "/" + d;
        if(dy%d > 0) {
            displayForValueOfY.setText("Y = " + stringForY);
        }
        else {
            displayForValueOfY.setText("Y = " + calculatedValueOfY);
        }
        //.........\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\







    }
public void reset (View view){
    aax.setText("");
    aay.setText("");
    aaz.setText("");
    bbx.setText("");
    bby.setText("");
    bbz.setText("");
    displayForValueOfX.setText("X = ");
    displayForValueOfY.setText("Y = ");
    displayForAlert.setText("");
}

    private int calculateDeterminant (int a, int b, int c, int d){
        return (a*d)-(c*b);
    }













}
