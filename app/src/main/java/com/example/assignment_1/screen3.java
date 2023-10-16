package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class screen3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);// Find the TextView for "Sign Up"
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView loginTextView = findViewById(R.id.login_btn_sc3);
        // Set an OnClickListener for the "Sign Up" TextView
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to screen2
                Intent intent = new Intent(screen3.this, screen1.class);
                // Start the new activity
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button forgotPw = findViewById(R.id.signup_btn_sc3);
        forgotPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the new activity
                Intent intent = new Intent(screen3.this, screen4.class);

                // Start the new activity
                startActivity(intent);
            }
        });

        // Initialize the Spinner
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Spinner country_spinner = findViewById(R.id.spinner_country);

        // Create an ArrayAdapter using a string array and a default spinner layout
        ArrayAdapter<CharSequence> country_adapter = ArrayAdapter.createFromResource(
                this, R.array.country_items, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        country_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        country_spinner.setAdapter(country_adapter);

        // Set a listener to handle item selections
        country_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected item
                String selectedItem = parentView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing when nothing is selected
            }
        });

        // Initialize the Spinner
        Spinner city_spinner = findViewById(R.id.spinner_city);

        // Create an ArrayAdapter using a string array and a default spinner layout
        ArrayAdapter<CharSequence> city_adapter = ArrayAdapter.createFromResource(
                this, R.array.spinner_items, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        city_spinner.setAdapter(city_adapter);

        // Set a listener to handle item selections
        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected item
                String selectedItem = parentView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing when nothing is selected
            }
        });
    }
}