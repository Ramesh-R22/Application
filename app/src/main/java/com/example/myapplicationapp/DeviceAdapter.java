package com.example.myapplicationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DeviceAdapter extends ArrayAdapter<Device> {

    private Context mContext;
    private List<Device> mDeviceList;

    public DeviceAdapter(@NonNull Context context, List<Device> deviceList) {
        super(context, 0, deviceList);
        mContext = context;
        mDeviceList = deviceList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_device, parent, false);
        }

        Device currentDevice = mDeviceList.get(position);

        TextView deviceNameTextView = listItem.findViewById(R.id.device_name);
        TextView deviceDescriptionTextView = listItem.findViewById(R.id.device_description);

        deviceNameTextView.setText(currentDevice.getDeviceName());
        deviceDescriptionTextView.setText(currentDevice.getDeviceDescription());

        return listItem;
    }
}
