package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class screen14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen14);
        @SuppressLint({"MissingInflatedId", "LocalSuppress", "WrongViewCast"}) ImageView backView = findViewById(R.id.back_btn_sc14);

        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the new activity
                Intent intent = new Intent(screen14.this, screen11.class);

                // Start the new activity
                startActivity(intent);
            }
        });
    }
}