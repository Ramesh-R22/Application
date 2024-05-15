package com.example.myapplicationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectNewDeviceActivity extends AppCompatActivity {

    private EditText deviceNameEditText;
    private EditText deviceDescriptionEditText;
    private Button connectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_new_device);

        deviceNameEditText = findViewById(R.id.device_name_edit_text);
        deviceDescriptionEditText = findViewById(R.id.device_description_edit_text);
        connectButton = findViewById(R.id.connect_button);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate input fields
                String deviceName = deviceNameEditText.getText().toString().trim();
                String deviceDescription = deviceDescriptionEditText.getText().toString().trim();

                if (deviceName.isEmpty()) {
                    deviceNameEditText.setError("Device name is required");
                    deviceNameEditText.requestFocus();
                    return;
                }

                connectNewDevice(deviceName, deviceDescription);
            }
        });
    }

    private void connectNewDevice(String deviceName, String deviceDescription) {

        String message = "Connecting device: " + deviceName;
        if (!deviceDescription.isEmpty()) {
            message += "\nDescription: " + deviceDescription;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        finish();
    }
}
