package com.example.assignment_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class screen3 extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText email;
    EditText password;
    EditText name;
    EditText phoneno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);// Find the TextView for "Sign Up"
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

        mAuth= FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        phoneno=findViewById(R.id.phoneno);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView loginTextView = findViewById(R.id.login_btn_sc3);
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(screen3.this, screen1.class);
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button signup = findViewById(R.id.signup_btn_sc3);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Spinner country_spinner = findViewById(R.id.spinner_country);

        ArrayAdapter<CharSequence> country_adapter = ArrayAdapter.createFromResource(
                this, R.array.country_items, android.R.layout.simple_spinner_item);

        country_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        country_spinner.setAdapter(country_adapter);

        country_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = parentView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        Spinner city_spinner = findViewById(R.id.spinner_city);

        ArrayAdapter<CharSequence> city_adapter = ArrayAdapter.createFromResource(
                this, R.array.spinner_items, android.R.layout.simple_spinner_item);

        city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        city_spinner.setAdapter(city_adapter);

        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = parentView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(
                                email.getText().toString(),
                                password.getText().toString()
                        )
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // User account created successfully
                                    String userId = mAuth.getCurrentUser().getUid();
                                    String userCountry = country_spinner.getSelectedItem().toString();
                                    String userCity = city_spinner.getSelectedItem().toString();
                                    String userName = name.getText().toString();
                                    String userPhone = phoneno.getText().toString();

                                    User user = new User(userCountry, userCity, userPhone,userName);

                                    databaseReference.child(userId).setValue(user);

                                    Toast.makeText(screen3.this, "Sign up Successful", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(screen3.this, "Sign up Failed", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(screen3.this, "Sign up Failed", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}