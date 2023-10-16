package com.example.assignment_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

    public class screen1 extends AppCompatActivity {
        FirebaseAuth mAuth;
        EditText email;
        EditText password;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_screen1);

            mAuth= FirebaseAuth.getInstance();
            email = findViewById(R.id.email);
            password=findViewById(R.id.password);

            @SuppressLint({"MissingInflatedId", "LocalSuppress"})
            Button loginTextView = findViewById(R.id.Login_butt_screen1);
            loginTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAuth.signInWithEmailAndPassword(
                                    email.getText().toString(),
                                    password.getText().toString()
                            )
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // Create an Intent to navigate to screen2
                                    Intent intent = new Intent(screen1.this, screen5.class);
                                    // Start the new activity
                                    startActivity(intent);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(screen1.this,"Login Failed",Toast.LENGTH_LONG).show();

                                }
                            });
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