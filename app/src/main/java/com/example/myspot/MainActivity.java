package com.example.myspot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button buttonCalculate;
    public Button buttonReset;
    public EditText setNumSpots;
    public TextView txtResults;
    public String numSpots = "1";
    public int spots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculate = findViewById(R.id.calc);
        buttonReset = findViewById(R.id.reset);
        setNumSpots = findViewById(R.id.numSpots);
        txtResults = findViewById(R.id.results);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                spots = 1;
                numSpots = "1";
                txtResults.setText("Sit in spot: ");

                numSpots = setNumSpots.getText().toString();

                if(numSpots.equals(" ")){
                    numSpots = "1";
                }

                spots = Integer.parseInt(numSpots);
                spots = josephusCalculations(spots);

                numSpots = String.valueOf(spots);
                txtResults.append(numSpots);

            }

        });

        buttonReset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                spots = 1;
                numSpots = "1";
                txtResults.setText("Sit in spot: ");
            }

        });
    }

    public int josephusCalculations(int spots){

        return ((((spots << 1) - (int) Math.pow(2, (int)(((Math.log(spots << 1) / Math.log(2)))))) + 1)
                | (spots >> (((int) ((Math.log(spots) / Math.log(2)))))));
    }
}
