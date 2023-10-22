package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // Find the TextView
        TextView textView = findViewById(R.id.go_back_btn_scr2);
        // Set an OnClickListener for the TextView
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to screen2
                Intent intent = new Intent(screen2.this, screen1.class);
                // Start the new activity
                startActivity(intent);
            }

        });
    }
}