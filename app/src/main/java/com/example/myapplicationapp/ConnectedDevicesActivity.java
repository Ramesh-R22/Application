package com.example.myapplicationapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ConnectedDevicesActivity extends AppCompatActivity {

    private ListView deviceListView;
    private List<Device> deviceList;
    private DeviceAdapter deviceAdapter;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected_devices);

        deviceListView = findViewById(R.id.device_list_view);
        deviceList = new ArrayList<>();
        deviceAdapter = new DeviceAdapter(this, deviceList);
        deviceListView.setAdapter(deviceAdapter);

        db = FirebaseFirestore.getInstance();

        fetchConnectedDevices();
    }

    private void fetchConnectedDevices() {
        db.collection("connected_devices")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            Device device = documentSnapshot.toObject(Device.class);
                            deviceList.add(device);
                        }
                        deviceAdapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ConnectedDevicesActivity.this,
                                "Error fetching connected devices: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
