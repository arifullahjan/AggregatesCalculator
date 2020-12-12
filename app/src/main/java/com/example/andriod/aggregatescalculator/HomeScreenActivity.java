package com.example.andriod.aggregatescalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

        public void nust(View view) {
            Intent nustEngineeringIntent = new Intent(this, NustEngineering.class);
            startActivity(nustEngineeringIntent);
        }


        public void uet(View view) {
            Intent uetIntent = new Intent(this, Uet.class);
            startActivity(uetIntent);
        }


        public void fast(View view) {
            Intent fastIntent = new Intent(this, Fast.class);
            startActivity(fastIntent);
        }


        public void giki(View view) {
            Intent gikiIntent = new Intent(this, Giki.class);
            startActivity(gikiIntent);
        }


        public void nums(View view) {
            Intent numsIntent = new Intent(this, Nums.class);
            startActivity(numsIntent);
        }


        public void etea(View view) {
            Intent eteaIntent = new Intent(this, Etea.class);
            startActivity(eteaIntent);
        }


        public void fastTestScore(View view) {
            Intent fastTestScoreIntent = new Intent(this, FastNUTestScoreCalculator.class);
            startActivity(fastTestScoreIntent);
        }
}
