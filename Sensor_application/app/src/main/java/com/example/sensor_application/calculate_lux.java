
package com.example.sensor_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.*;

public class calculate_lux extends AppCompatActivity {

    Spinner spinner,spinner1;
    TextView textView,textView1,textView2;
    EditText editText;
    Button button,button1;
    static int total,minwatt,maxwatt,lumen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_lux);
        spinner = findViewById(R.id.spinner1);

        textView = findViewById(R.id.txt);
        textView1 = findViewById(R.id.txt1);

        editText = findViewById(R.id.edt1);
        button = findViewById(R.id.b1);
        //button1 = findViewById(R.id.b2);



        List<String> list = new ArrayList<String>();
        list.add("Leafy Greens:");
        list.add("Herbs ");
        list.add("Microgreens");
        list.add("Tomatoes");
        list.add("Peppers");
        list.add("Strawberries");
        list.add("Cucumbers");
        list.add("Sprouts");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    textView.setText("* Lux Requirement: 5,000 - 10,000 lux");
                    if (position == 0 ){
                        button.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                 total =  Integer.parseInt(editText.getText().toString());
                                 minwatt = total * 15;
                                 maxwatt = total*40;
                                textView1.setText("Minimum Light Required :"+minwatt+"Maximum Light Required:"+maxwatt);

                            }
                        });

                    }


                } else if (position == 1) {
                    textView.setText("* Lux Requirement: 5,000 - 10,000 lux");
                    if (position == 1 ){
                        button.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                total =  Integer.parseInt(editText.getText().toString());
                                minwatt = total * 15;
                                maxwatt = total*40;
                                textView1.setText("Minimum Light Required :"+minwatt+"Maximum Light Required:"+maxwatt);

                            }
                        });

                    }

                } else if (position == 2) {
                    textView.setText("* Lux Requirement: 10,000 - 15,000 lux");

                    if (position == 2 ){
                        button.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                total =  Integer.parseInt(editText.getText().toString());
                                minwatt = total * 30;
                                maxwatt = total*50;
                                textView1.setText("Minimum Light Required :"+minwatt+"Maximum Light Required:"+maxwatt);

                            }
                        });

                    }




                } else if (position == 3) {
                    textView.setText("* Lux Requirement: 10,000 - 20,000 lux during vegetative growth; 20,000 - 40,000 lux during fruiting");

                    if (position == 3 ){
                        button.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                total =  Integer.parseInt(editText.getText().toString());
                                minwatt = total * 30;
                                maxwatt = total*50;
                                textView1.setText("Minimum Light Required :"+minwatt +"Maximum Light Required:"+maxwatt);

                            }
                        });

                    }


                } else if (position == 4) {
                    textView.setText("* Lux Requirement: 10,000 - 20,000 lux during vegetative growth; 20,000 - 40,000 lux during fruiting");

                    if (position == 4 ){
                        button.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                total =  Integer.parseInt(editText.getText().toString());
                                minwatt = total * 20;
                                maxwatt = total*30;
                                textView1.setText("Minimum Light Required :"+minwatt+"Maximum Light Required:"+maxwatt);

                            }
                        });

                    }



                } else if (position == 5) {
                    textView.setText("* Lux Requirement: 5,000 - 10,000 lux during vegetative growth; 10,000 - 20,000 lux during flowering and fruiting");

                    if (position == 5 ){
                        button.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                total =  Integer.parseInt(editText.getText().toString());
                                minwatt = total * 20;
                                maxwatt = total*30;
                                textView1.setText("Minimum Light Required :"+minwatt+"Maximum Light Required:"+maxwatt);

                            }
                        });

                    }


                } else if (position == 6) {
                    textView.setText("* Lux Requirement: 10,000 - 20,000 lux during vegetative growth; 20,000 - 40,000 lux during fruiting");

                    if (position == 6 ){
                        button.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                total =  Integer.parseInt(editText.getText().toString());
                                minwatt = total * 15;
                                maxwatt = total*40;
                                textView1.setText("Minimum Light Required :"+minwatt+"Maximum Light Required:"+maxwatt);

                            }
                        });

                    }


                } else if (position == 7) {
                    textView.setText(" * Lux Requirement: 2,000 - 5,000 lux");

                    if (position == 7 ){
                        button.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                total =  Integer.parseInt(editText.getText().toString());
                                minwatt = total * 25;
                                maxwatt = total*35;
                                textView1.setText("Minimum Light Required :"+minwatt+"Maximum Light Required:"+maxwatt);

                            }
                        });

                    }


                } else {

                    textView1.setText("Select from the above list ");

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }




}

