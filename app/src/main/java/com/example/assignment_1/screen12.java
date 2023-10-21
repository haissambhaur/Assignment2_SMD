package com.example.assignment_1;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class screen12 extends AppCompatActivity {
    EditText itemname, rate, description;
    Button save;
    ImageView uploadphoto;

    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    int DP_REQUEST_CODE = 200;
    String imageUrl;
    Uri selectedImage = null;
    private StorageReference storageReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen12);

        itemname = findViewById(R.id.itemname);
        rate = findViewById(R.id.rate);
        description = findViewById(R.id.description);
        save = findViewById(R.id.postItem_btn_sc12);
        uploadphoto = findViewById(R.id.uploadphoto);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("item");

        uploadphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the image picker
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, DP_REQUEST_CODE);
            }

        });


        Spinner spinner_city = findViewById(R.id.spinner_city);
        String selectedCity = "";
        if (spinner_city.getSelectedItem() != null) {
            selectedCity = spinner_city.getSelectedItem().toString();
        }


        String finalSelectedCity = selectedCity;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedImage != null) {
                    StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                    storageReference = storageReference.child("abc/dp.jpg");
                    storageReference.putFile(selectedImage)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    Task<Uri> task = taskSnapshot.getStorage().getDownloadUrl();
                                    task
                                            .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                @Override
                                                public void onSuccess(Uri uri) {
                                                    String dp = uri.toString();

                                                    reference.push().setValue(new Items(itemname.getText().toString(), description.getText().toString(),rate.getText().toString(), finalSelectedCity,"10/19/2023",dp));
                                                    Toast.makeText(screen12.this, "Data uploaded successfully.", Toast.LENGTH_LONG).show();
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(screen12.this, "Failed to upload the Image.", Toast.LENGTH_LONG).show();
                                                }
                                            });
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(screen12.this, "Failed to upload the Image.", Toast.LENGTH_LONG).show();
                                }
                            });
                }
                else {
                    Toast.makeText(screen12.this, "Select an Image", Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(screen12.this, screen10.class);
                startActivity(intent);
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200 & resultCode==RESULT_OK) {
            selectedImage = data.getData();
            uploadphoto.setImageURI(selectedImage);
        }
    }
}
