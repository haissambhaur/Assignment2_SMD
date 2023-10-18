package com.example.assignment_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class screen5 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private FirebaseAuth mAuth;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    DatabaseReference databaseReference1;
    DatabaseReference databaseReference2;
    DatabaseReference databaseReference3;
    MyAdapter myAdapter1,myAdapter2,myAdapter3;
    ArrayList<Items> list1,list2,list3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen5);

        recyclerView1 = findViewById(R.id.recyclerViewFeaturedItems);
        recyclerView2 = findViewById(R.id.recyclerViewRecentItems);
        recyclerView3 = findViewById(R.id.recyclerViewYourItems);

        databaseReference1 = FirebaseDatabase.getInstance().getReference("FeaturedItems");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("RecentItems");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("YourItems");

        recyclerView1.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setHasFixedSize(true);

        recyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();

        myAdapter1 = new MyAdapter(list1, this);
        myAdapter2 = new MyAdapter(list2, this);
        myAdapter3 = new MyAdapter(list3, this);

        recyclerView1.setAdapter(myAdapter1);
        recyclerView2.setAdapter(myAdapter2);
        recyclerView3.setAdapter(myAdapter3);

// Add ValueEventListener for each database reference (databaseReference1, databaseReference2, databaseReference3)
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1.clear(); // Clear the list before adding new data
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Items item = dataSnapshot.getValue(Items.class);
                    list1.add(item);
                }
                myAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors if needed
            }
        });

        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2.clear(); // Clear the list before adding new data
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Items item = dataSnapshot.getValue(Items.class);
                    list2.add(item);
                }
                myAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors if needed
            }
        });

        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3.clear(); // Clear the list before adding new data
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Items item = dataSnapshot.getValue(Items.class);
                    list3.add(item);
                }
                myAdapter3.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors if needed
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setSelectedItemId(R.id.homeItem);

        mAuth = FirebaseAuth.getInstance();

        // Find the "Logout" button by its ID
        Button logoutButton = findViewById(R.id.Logout);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.homeItem) {
                    Intent intent = new Intent(screen5.this,screen5.class);
                    startActivity(intent);
                    finish();
                    return true;
                } else if (id==R.id.searchItem) {
                    Intent intent = new Intent(screen5.this,screen6.class);
                    startActivity(intent);
                    finish();
                    return true;
                } else if (id==R.id.addItem) {
                    Intent intent = new Intent(screen5.this,screen12.class);
                    startActivity(intent);
                    finish();
                    return true;

                } else if (id==R.id.chatItem) {
                    Intent intent = new Intent(screen5.this,screen8.class);
                    startActivity(intent);
                    finish();
                    return true;

                } else if (id==R.id.profileItem) {
                    Intent intent = new Intent(screen5.this,screen10.class);
                    startActivity(intent);
                    finish();
                    return true;

                }
                return false;
            }
        });
//        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView = findViewById(R.id.item_btn_sc5);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create an intent to start the new activity
//                Intent intent = new Intent(screen5.this, screen11.class);
//
//                // Start the new activity
//                startActivity(intent);
//            }
//        });

        // Assuming you have access to the user's UID
        String userUID = mAuth.getCurrentUser().getUid();

        // Reference to the database node where user information is stored

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
        DatabaseReference userReference = databaseReference.child(userUID);

        // Query the database to retrieve the user's name
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Retrieve the user's name
                    String userName = dataSnapshot.child("name").getValue(String.class);

                    // Now, you have the user's name and can use it as needed
                    // For example, set it to a TextView
                    TextView nameTextView = findViewById(R.id.name);
                    nameTextView.setText(userName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        // Set an OnClickListener for the "Logout" button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sign the user out
                mAuth.signOut();

                // You can add any additional actions you want to perform after logout here.
                // For example, you can navigate to another activity or display a message.

                // Example: Navigate to the login or splash screen after logout
                Intent intent = new Intent(screen5.this, screen1.class);
                startActivity(intent);
                finish(); // Finish the current activity to prevent going back.
            }
        });
    }
}