package com.example.sensor_application;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Service;
import android.app.usage.UsageEvents;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener  {

    TextView textView,textview2,textView3;
    Sensor sensor;
    SensorManager sensorManager;
    Button calc,Save,measure;
    float store;
    ImageView Off,On,Status;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.luxmeter);
        sensorManager= (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        textview2 = findViewById(R.id.text2);
        calc= findViewById(R.id.calculate);
        Status = findViewById(R.id.status);
        On = findViewById(R.id.bright);
        Off = findViewById(R.id.off);
        measure = findViewById(R.id.measure);

        measure.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,calculate_lux.class);
                startActivity(intent);
            }
        });



        calc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Crops.class);
                startActivity(intent);
            }
        });


    }



    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_LIGHT);
        {
            textView.setText("" + event.values[0]);

            if(event.values[0] > 250  ){
                Status.setImageResource(R.drawable.bright);
            }

            else{
                Status.setImageResource(R.drawable.off);
            }


            if(event.values[0]  == 0 ){
                textview2.setText("Dark");
            }
            else if(event.values[0] > 0 && event.values[0] <= 2000 ){
                textview2.setText("low bright");
            }
            else if(event.values[0] > 2001  && event.values[0] <5000 ){
                textview2.setText("bright");
            }
            else if(event.values[0] >= 5000  && event.values[0] <30000 ){
                textview2.setText(" very bright");
            }
            else{
                textview2.setText("Can't calculate");
            }



        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}