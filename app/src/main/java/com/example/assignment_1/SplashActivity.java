package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mAuth = FirebaseAuth.getInstance();

        // Create a handler with a delay of 5 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(SplashActivity.this, screen5.class);
                    Toast.makeText(SplashActivity.this, mAuth.getUid().toString(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                } else {
                    // Start the next activity
                    Intent intent = new Intent(SplashActivity.this, screen1.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 5000); // 5000 milliseconds (5 seconds)
    }
}