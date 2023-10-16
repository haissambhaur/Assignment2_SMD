package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class screen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button forgotPw = findViewById(R.id.Login_butt_screen1);
        forgotPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the new activity
                Intent intent = new Intent(screen1.this, screen5.class);

                // Start the new activity
                startActivity(intent);
            }
        });

        // Find the TextView
        TextView textView = findViewById(R.id.frgt_btn_sc1);
        // Set an OnClickListener for the TextView
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to screen2
                Intent intent = new Intent(screen1.this, screen2.class);
                // Start the new activity
                startActivity(intent);
            }
        });

        // Find the TextView for "Sign Up"
        TextView signUpTextView = findViewById(R.id.signup_btn_sc1);
        // Set an OnClickListener for the "Sign Up" TextView
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to screen2
                Intent intent = new Intent(screen1.this, screen3.class);
                // Start the new activity
                startActivity(intent);
            }
        });
    }
}