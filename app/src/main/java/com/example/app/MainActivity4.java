package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<HealthData> arrayList = new ArrayList<>();

    FirebaseAuth auth;
    FirebaseUser user;
    TextView textView;

    Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView = findViewById(R.id.tv_email);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        logoutBtn = findViewById(R.id.logoutButton);



        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }


        else {
            textView.setText(user.getEmail());
        }


        // In MainActivity4.java or where you want to handle the logout
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sign out from Firebase
                auth.signOut();

                // Display a Toast message
                Toast.makeText(MainActivity4.this, "You have logged out.", Toast.LENGTH_SHORT).show();

                // After logout, start the LoginActivity and clear the activity stack
                Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish(); // Finish the current activity
            }
        });



        // Health Recycler


        String [] health_name = getResources().getStringArray(R.array.screen_names);


        //Health page: dashboard
        arrayList.add(new HealthData(R.drawable.insurance, health_name[0]));
        arrayList.add(new HealthData(R.drawable.edit_patient_details, health_name[1]));
        arrayList.add(new HealthData(R.drawable.profile_profile, health_name[2]));
        arrayList.add(new HealthData(R.drawable.rating, health_name[3]));
        arrayList.add(new HealthData(R.drawable.request_professional, health_name[4]));
        arrayList.add(new HealthData(R.drawable.insuranceform, health_name[5]));
        arrayList.add(new HealthData(R.drawable.patientform, health_name[6]));
        arrayList.add(new HealthData(R.drawable.gp_details, health_name[7]));
        arrayList.add(new HealthData(R.drawable.diabetes, health_name[8]));
        arrayList.add(new HealthData(R.drawable.heart, health_name[9]));
        arrayList.add(new HealthData(R.drawable.lung, health_name[10]));


        //Display Recycler View
        HealthRecycler healthRecycler = new HealthRecycler(this, arrayList, logoutBtn);
        recyclerView.setAdapter(healthRecycler);

    }
}