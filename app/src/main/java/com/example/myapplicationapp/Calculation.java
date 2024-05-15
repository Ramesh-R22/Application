package com.example.myapplicationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculation extends AppCompatActivity {

    EditText sourceLatitudeEditText;
    EditText sourceLongitudeEditText;
    EditText destinationLatitudeEditText;
    EditText destinationLongitudeEditText;
    EditText speedEditText;
    Button calculateButton;
    TextView estimatedTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        // Initialize all the views
        sourceLatitudeEditText = findViewById(R.id.sourceLatitudeEditText);
        sourceLongitudeEditText = findViewById(R.id.sourceLongitudeEditText);
        destinationLatitudeEditText = findViewById(R.id.destinationLatitudeEditText);
        destinationLongitudeEditText = findViewById(R.id.destinationLongitudeEditText);
        speedEditText = findViewById(R.id.speedEditText);
        calculateButton = findViewById(R.id.calculateButton);
        estimatedTimeTextView = findViewById(R.id.estimatedTimeTextView);

        // Set OnClickListener on the Calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateEstimatedTime();
            }
        });
    }

    private void calculateEstimatedTime() {
        double sourceLatitude = Double.parseDouble(sourceLatitudeEditText.getText().toString());
        double sourceLongitude = Double.parseDouble(sourceLongitudeEditText.getText().toString());
        double destinationLatitude = Double.parseDouble(destinationLatitudeEditText.getText().toString());
        double destinationLongitude = Double.parseDouble(destinationLongitudeEditText.getText().toString());

        double distanceKm = calculateDistance(sourceLatitude, sourceLongitude, destinationLatitude, destinationLongitude);

        double speed = Double.parseDouble(speedEditText.getText().toString());

        double estimatedTimeHours = distanceKm / speed;
        int estimatedTimeMinutes = (int) (estimatedTimeHours * 60);

        estimatedTimeTextView.setText("Estimated Time: " + estimatedTimeMinutes + " minutes");
    }

    private double calculateDistance(double sourceLatitude, double sourceLongitude, double destinationLatitude, double destinationLongitude) {
        final int R = 6371;

        double latDistance = Math.toRadians(destinationLatitude - sourceLatitude);
        double lonDistance = Math.toRadians(destinationLongitude - sourceLongitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(sourceLatitude)) * Math.cos(Math.toRadians(destinationLatitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        return distance;
    }
}
