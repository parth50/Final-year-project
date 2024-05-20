package com.example.sensor_application;

import static androidx.lifecycle.Transformations.map;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Set;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

public class Crops extends AppCompatActivity {
    private static final String TAG = "LedControlActivity";

    private SeekBar brightnessSeekBar;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothSocket bluetoothSocket;
    private OutputStream outputStream;
    private TextView luxTextView;

    // Define the maximum lux value
    private static final int MAX_LUX = 10000;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_crops);
            brightnessSeekBar = findViewById(R.id.brightnessSeekBar);

            // Initialize BluetoothAdapter
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (bluetoothAdapter == null) {
                // Device doesn't support Bluetooth
                // Handle accordingly
                return;
            }

            // Connect to the Bluetooth device
            connectBluetooth();

            // Set listener for SeekBar changes
            brightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // Send brightness value to HC-05
                    sendBrightness(progress);
                    //int luxValue = map(progress, 0, 100, 0, MAX_LUX);
                    // Update lux text view
                    //luxTextView.setText("Lux: " + luxValue);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}
            });
        }

    //private int map(int value, int fromLow, int fromHigh, int toLow, int toHigh) {
       // return (value - fromLow) * (toHigh - toLow) / (fromHigh - fromLow) + toLow;
    //}

    private void connectBluetooth() {
        String address = "00:00:13:00:37:F8"; // Replace with HC-05 MAC address
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);
        try {
            UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // Standard SerialPortService ID
            bluetoothSocket = device.createRfcommSocketToServiceRecord(uuid);
            bluetoothSocket.connect();
            outputStream = bluetoothSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendBrightness(int brightness) {
        try {
            outputStream.write(brightness);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            bluetoothSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}