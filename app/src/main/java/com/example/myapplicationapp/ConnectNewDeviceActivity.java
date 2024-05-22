package com.example.myapplicationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ConnectNewDeviceActivity extends AppCompatActivity {

    private EditText deviceNameEditText;
    private EditText deviceDescriptionEditText;
    private Button connectButton;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_new_device);

        deviceNameEditText = findViewById(R.id.device_name_edit_text);
        deviceDescriptionEditText = findViewById(R.id.device_description_edit_text);
        connectButton = findViewById(R.id.connect_button);

        db = FirebaseFirestore.getInstance();

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

        Map<String, Object> deviceData = new HashMap<>();
        deviceData.put("deviceName", deviceName);
        deviceData.put("deviceDescription", deviceDescription);

        db.collection("connected_devices")
                .add(deviceData)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // Document added successfully
                        Toast.makeText(ConnectNewDeviceActivity.this,
                                "Device connected successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Error occurred while adding document
                        Toast.makeText(ConnectNewDeviceActivity.this,
                                "Error connecting device: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
