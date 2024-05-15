package com.example.myapplicationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find image buttons
        ImageButton btnConnectedDevices = findViewById(R.id.btn_connected_devices);
        ImageButton btnAddDevice = findViewById(R.id.btn_add_device);
        ImageButton btnCalculator = findViewById(R.id.btn_calculator);
        ImageButton btnDeviceLocation = findViewById(R.id.btn_device_location);

        // Set click listeners
        btnConnectedDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ConnectedDevicesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnAddDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ConnectNewDeviceActivity.class);
                startActivity(intent);
            }
        });

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Calculation.class);
                startActivity(intent);
            }
        });

        btnDeviceLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DeviceLocationActivity.class);
                startActivity(intent);
            }
        });
    }

}