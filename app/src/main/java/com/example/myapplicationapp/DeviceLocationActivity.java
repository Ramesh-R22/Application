// DeviceLocationActivity.java
package com.example.myapplicationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DeviceLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_location);

        // Retrieve device location data from intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("device_name") && extras.containsKey("device_location")) {
            String deviceName = extras.getString("device_name");
            String deviceLocation = extras.getString("device_location");

            // Display device name and location
            TextView deviceNameTextView = findViewById(R.id.device_name_text_view);
            TextView deviceLocationTextView = findViewById(R.id.device_location_text_view);
            deviceNameTextView.setText("Device Name: " + deviceName);
            deviceLocationTextView.setText("Device Location: " + deviceLocation);
        }
    }
}
