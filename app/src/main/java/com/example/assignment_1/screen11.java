package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class screen11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen11);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView reportTextView = findViewById(R.id.rprt_btn_sc11);
        // Set an OnClickListener for the "Sign Up" TextView
        reportTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to screen2
                Intent intent = new Intent(screen11.this, screen14.class);
                // Start the new activity
                startActivity(intent);
            }
        });
    }
}