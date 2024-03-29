package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Insurance extends AppCompatActivity {

    Context context;
    FloatingActionButton fab;
    EditText InsuranceCompanyEditText, policyNumberEditText, expiryDateEditText;
    Button submitButton;

    // Firebase Firestore reference
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference InsuranceDetailsRef = db.collection("Insurance_details");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);

        InsuranceCompanyEditText = findViewById(R.id.editTextText6);
        policyNumberEditText = findViewById(R.id.editTextText8);
        expiryDateEditText = findViewById(R.id.editTextDate3);
        submitButton = findViewById(R.id.button4);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInsuranceDetails();
            }
        });

        // Initialize the fab button and set its click listener
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start MainActivity4 when FAB is clicked
                Intent intent = new Intent(Insurance.this, MainActivity4.class);
                startActivity(intent);
                Toast.makeText(Insurance.this, "FAB Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void saveInsuranceDetails() {
        String InsuranceCompany = InsuranceCompanyEditText.getText().toString().trim();
        String policyNumber = policyNumberEditText.getText().toString().trim();
        String expiryDate = expiryDateEditText.getText().toString().trim();

        // Check if any field is empty
        if (InsuranceCompany.isEmpty() || policyNumber.isEmpty() || expiryDate.isEmpty()) {
            // Handle empty fields
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a Map to store the Insurance details
        Map<String, Object> InsuranceData = new HashMap<>();
        InsuranceData.put("InsuranceCompany", InsuranceCompany);
        InsuranceData.put("policyNumber", policyNumber);
        InsuranceData.put("expiryDate", expiryDate);

        // Add the data to Firestore
        InsuranceDetailsRef.add(InsuranceData)
                .addOnSuccessListener(documentReference -> {
                    // Clear the input fields
                    InsuranceCompanyEditText.setText("");
                    policyNumberEditText.setText("");
                    expiryDateEditText.setText("");

                    // Show a success message
                    Toast.makeText(this, "Insurance details saved successfully", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    // Handle failure
                    Toast.makeText(this, "Failed to save Insurance details", Toast.LENGTH_SHORT).show();
                });
        
    }
}