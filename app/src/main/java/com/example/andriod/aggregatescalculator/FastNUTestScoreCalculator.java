package com.example.andriod.aggregatescalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class FastNUTestScoreCalculator extends AppCompatActivity {


    EditText editTextAdvancedMathsAttempted;
    EditText editTextAdvancedMathsCorrect;


    EditText editTextAnalyticalSkillsAttempted;
    EditText editTextAnalyticalSkillsCorrect;


    EditText editTextBasicMathsAttempted;
    EditText editTextBasicMathsCorrect;


    EditText editTextEnglishAttempted;
    EditText editTextEnglishCorrect;


    EditText editTextPhysicsAttempted;
    EditText editTextPhysicsCorrect;

    EditText editTextMarksInFsc;

    TextView displayTextViewFastTestScorer;
    TextView fastAggregateTextViewInTestScorer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_nutest_score_calculator);





        editTextAdvancedMathsAttempted = (EditText) findViewById(R.id.advancedMathsAttemptedEditText);
        editTextAdvancedMathsCorrect = (EditText) findViewById(R.id.advanedMathsCorrectEditText);
        editTextAnalyticalSkillsAttempted = (EditText) findViewById(R.id.analyticalSkillsAttemptedEditText);
        editTextAnalyticalSkillsCorrect = (EditText) findViewById(R.id.analyticalSkillsCorrectEditText);
        editTextBasicMathsAttempted = (EditText) findViewById(R.id.basicMathsAttemptedEditText);
        editTextBasicMathsCorrect = (EditText) findViewById(R.id.basicMathsCorrectEditText);
        editTextEnglishAttempted = (EditText) findViewById(R.id.englishAttemptedEditText);
        editTextEnglishCorrect = (EditText) findViewById(R.id.englishCorrectEditText);
        editTextPhysicsAttempted = (EditText) findViewById(R.id.physicsAttemptedEditText);
        editTextPhysicsCorrect = (EditText) findViewById(R.id.physicsCorrectEditText);

        editTextMarksInFsc = (EditText) findViewById(R.id.optionalFscEditText);


        displayTextViewFastTestScorer = (TextView) findViewById(R.id.displayTextViewFastTest);
        fastAggregateTextViewInTestScorer = (TextView) findViewById(R.id.fastAggregateTextViewInNUTestScorer);
    }

    public void buttonForNUTestScorer (View view) {

        float advMathAtmptd = 0;
        float advMathCorrect = 0;
        float analyticalAtmptd = 0;
        float analyticalCorrect = 0;
        float basicAtmptd = 0;
        float basicCorrect = 0;
        float englishAtmptd = 0;
        float englishCorrect = 0;
        float phyAtmptd = 0;
        float phyCorrect = 0;



        float hssc = 0;
        float totalMarksFsc = 520;



        // check if the fields are empty
        if (
                    TextUtils.isEmpty(editTextAdvancedMathsAttempted.getText().toString())
                || TextUtils.isEmpty(editTextAdvancedMathsCorrect.getText().toString())
                || TextUtils.isEmpty(editTextAnalyticalSkillsAttempted.getText().toString())
                || TextUtils.isEmpty(editTextAnalyticalSkillsCorrect.getText().toString())
                || TextUtils.isEmpty(editTextEnglishAttempted.getText().toString())
                || TextUtils.isEmpty(editTextEnglishCorrect.getText().toString())
                || TextUtils.isEmpty(editTextPhysicsAttempted.getText().toString())
                || TextUtils.isEmpty(editTextPhysicsCorrect.getText().toString())
                || TextUtils.isEmpty(editTextBasicMathsAttempted.getText().toString())
                || TextUtils.isEmpty(editTextBasicMathsCorrect.getText().toString())
                ) {
            displayTextViewFastTestScorer.setText("Please enter your marks.");
            return;
        }

        if(TextUtils.isEmpty(editTextMarksInFsc.getText().toString())) {
            hssc = 0;
        }


        CheckBox resultAwaited = (CheckBox) findViewById(R.id.resultAwaited);
        boolean part2ResultAwaitedChecked = resultAwaited.isChecked();
        if (!part2ResultAwaitedChecked){
            totalMarksFsc = 1100;
        }




        //assigning values to floats.
        advMathAtmptd = Float.parseFloat(editTextAdvancedMathsAttempted.getText().toString());
        advMathCorrect = Float.parseFloat(editTextAdvancedMathsCorrect.getText().toString());
        analyticalAtmptd = Float.parseFloat(editTextAnalyticalSkillsAttempted.getText().toString());
        analyticalCorrect = Float.parseFloat(editTextAnalyticalSkillsCorrect.getText().toString());
        basicAtmptd = Float.parseFloat(editTextBasicMathsAttempted.getText().toString());
        basicCorrect = Float.parseFloat(editTextBasicMathsCorrect.getText().toString());
        englishAtmptd = Float.parseFloat(editTextEnglishAttempted.getText().toString());
        englishCorrect = Float.parseFloat(editTextEnglishCorrect.getText().toString());
        phyAtmptd = Float.parseFloat(editTextPhysicsAttempted.getText().toString());
        phyCorrect = Float.parseFloat(editTextPhysicsCorrect.getText().toString());

        hssc = Float.parseFloat(editTextMarksInFsc.getText().toString());





        //checking if marks are submitted wrong.
        if (
                advMathAtmptd > 40 || advMathCorrect > advMathAtmptd
                || analyticalAtmptd > 20 || analyticalCorrect > analyticalAtmptd
                || basicAtmptd > 10 || basicCorrect > basicAtmptd
                || englishAtmptd > 20|| englishCorrect > englishAtmptd
                || phyAtmptd > 20 || phyCorrect > phyAtmptd){

            fastAggregateTextViewInTestScorer.setText("Alert!!!!!!!! : Please enter marks correctly. One or more fields have invalid marks submitted. \n To find out your aggregate in fast enter your hssc score too.");
            return;
        }



        //displaying fast test score.
        float totalAdjustedScore = adjustAdvancedMathsScore(advMathAtmptd, advMathCorrect) + adjustAnalyticalScore(analyticalAtmptd, analyticalCorrect) + adjustBasicMathsScore(basicAtmptd, basicCorrect)+adjustEnglishScore(englishAtmptd,englishCorrect) +adjustPhysicsScore(phyAtmptd,phyCorrect);
        displayTextViewFastTestScorer.setText(totalAdjustedScore + "");



        //displaying fast aggregate.
        float aggregateForFast = calculateAggregateForFast(totalAdjustedScore,hssc, totalMarksFsc);
        fastAggregateTextViewInTestScorer.setText("Your calculated aggregete for FAST NUCES is " + aggregateForFast);



    }






    private float adjustAdvancedMathsScore (float attempted,float correct){
        float a = (attempted - correct)*(1/5);
        float b = correct - a;
        return b;

    }
    private float adjustAnalyticalScore (float attempted,float correct){
        float a = (attempted - correct)*(1/5);
        float b = correct - a;
        return b;

    }
    private float adjustBasicMathsScore (float attempted,float correct){
        float a = (attempted - correct)*(1/5);
        float b = correct - a;
        return b*2;

    }
    private float adjustEnglishScore (float attempted,float correct){
        float a = (attempted - correct)*(1/5);
        float b = correct - a;
        return b*(1/2);

    }
    private float adjustPhysicsScore (float attempted,float correct){
        float a = (attempted - correct)*(1/5);
        float b = correct - a;
        return b*(1/2);

    }













    private float calculateAggregateForFast (float marksInNUTest, float marksInFsc , float totalMarksInFsc){

        float a = (marksInFsc/totalMarksInFsc)*50;
        float b = (marksInNUTest/110)*50;
        return a + b;
    }





}
