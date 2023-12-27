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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PatientDetails extends AppCompatActivity {

    Context context;
    FloatingActionButton fab;
    EditText editTextEmail, editTextPhoneNumber, editTextAddress;

    Button buttonUpdate;

    // Firebase Firestore reference
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference usersRef = db.collection("users");
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        editTextEmail = findViewById(R.id.editTextText8);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextAddress = findViewById(R.id.editTextTextPostalAddress);

        buttonUpdate = findViewById(R.id.buttonUpdate);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePatientDetails();
            }
        });

        // Initialize the fab button and set its click listener
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start MainActivity4 when FAB is clicked
                Intent intent = new Intent(PatientDetails.this, MainActivity4.class);
                startActivity(intent);
                Toast.makeText(PatientDetails.this, "FAB Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void updatePatientDetails() {
        String email = editTextEmail.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();

        // Check if any field is empty
        if (phoneNumber.isEmpty() || address.isEmpty()) {
            // Handle empty fields
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            // Update the data in Firestore using the user's UID
            usersRef.document(currentUser.getUid())
                    .update("Email", email, "Phone Number", phoneNumber, "address", address)
                    .addOnSuccessListener(aVoid -> {
                        // Disable editing of EditText fields
                        editTextEmail.setEnabled(false);
                        editTextPhoneNumber.setEnabled(false);
                        editTextAddress.setEnabled(false);

                        // Clear EditText fields
                        editTextEmail.setText("");
                        editTextPhoneNumber.setText("");
                        editTextAddress.setText("");

                        // Show a success message
                        Toast.makeText(this, "Patient details updated successfully", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        // Handle failure
                        Toast.makeText(this, "Failed to update patient details", Toast.LENGTH_SHORT).show();
                    });
        }
    }
}