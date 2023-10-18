package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

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
                    // User is logged in, redirect to screen5
                    Intent intent = new Intent(SplashActivity.this, screen5.class);
                    startActivity(intent);
                } else {
                    // No user logged in, redirect to screen1
                    Intent intent = new Intent(SplashActivity.this, screen1.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 5000); // 5000 milliseconds (5 seconds)
    }
}

