package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class DisplayPatientDetails extends AppCompatActivity {

    TextView tvPatientName, tvPatientEmail, tvPatientDOB;
    TextView tvInsuranceCompany, tvPolicyNumber, tvExpiryDate;
    TextView tvPatientPhoneNumber, tvPatientAddress;
    TextView tvRating;
    TextView tvReviews;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patient_details);

        initializeUI();
        loadUserData();
        loadUserInsurance();
        loadUserRatings();
    }

    private void initializeUI() {
        tvPatientName = findViewById(R.id.tvPatientName);
        tvPatientEmail = findViewById(R.id.tvPatientEmail);
        tvPatientDOB = findViewById(R.id.tvPatientDOB);
        tvInsuranceCompany = findViewById(R.id.tvInsuranceCompany);
        tvPolicyNumber = findViewById(R.id.tvPolicyNumber);
        tvExpiryDate = findViewById(R.id.tvExpiryDate);
        tvRating = findViewById(R.id.tvRating);
        tvReviews = findViewById(R.id.tvReviews);
        tvPatientPhoneNumber = findViewById(R.id.tvPatientPhoneNumber);
        tvPatientAddress = findViewById(R.id.tvPatientAddress);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(view -> finish());
    }

//    private void loadUserData() {
//        fetchDataFromFirestore("users", (document) -> {
//            tvPatientName.setText(document.getString("Name"));
//            tvPatientEmail.setText(document.getString("Email"));
//            tvPatientDOB.setText(document.getString("DOB"));
//            tvPatientPhoneNumber.setText(document.getString("Phone Number"));
//            tvPatientAddress.setText(document.getString("address"));
//        });
//    }

    private void loadUserData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            String userEmail = user.getEmail();
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            db.collection("users")
                    .whereEqualTo("Email", userEmail)
                    .get()
                    .addOnSuccessListener(queryDocumentSnapshots -> {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            DocumentSnapshot document = queryDocumentSnapshots.getDocuments().get(0);
                            tvPatientName.setText(document.getString("Name"));
                            tvPatientEmail.setText(document.getString("Email"));
                            tvPatientDOB.setText(document.getString("DOB"));
                            tvPatientPhoneNumber.setText(document.getString("Phone Number"));
                            tvPatientAddress.setText(document.getString("address"));
                        }
                    })
                    .addOnFailureListener(e -> showToastAndLogError("Error loading user data", e));
        }
    }

    private void loadUserInsurance() {
        fetchDataFromFirestore("Insurance_details", (document) -> {
            tvInsuranceCompany.setText(document.getString("InsuranceCompany"));
            tvPolicyNumber.setText(document.getString("policyNumber"));
            tvExpiryDate.setText(document.getString("expiryDate"));
        });
    }


    private void loadUserRatings() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("ratings")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    StringBuilder allRatings = new StringBuilder();
                    StringBuilder allFeedback = new StringBuilder();

                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                        Long rating = document.getLong("rating");
                        String feedback = document.getString("feedback");

                        if (rating != null) {
                            allRatings.append("Rating: ").append(rating.toString()).append("\n");
                        }

                        if (feedback != null && !feedback.trim().isEmpty()) {
                            allFeedback.append("Feedback: ").append(feedback).append("\n\n");
                        }
                    }

                    tvRating.setText(allRatings.toString().trim());
                    tvReviews.setText(allFeedback.toString().trim());
                })
                .addOnFailureListener(e -> showToastAndLogError("Error loading ratings", e));
    }




    private void fetchDataFromFirestore(String collection, FirestoreCallback callback) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(collection)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                        if (document != null) {
                            callback.onCallback(document);
                        }
                    }
                })
                .addOnFailureListener(e -> showToastAndLogError("Error loading data from " + collection, e));
    }





    private void showToastAndLogError(String message, Exception e) {
        Toast.makeText(this, message + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        Log.e("DisplayPatientDetails", message, e);
    }

    private interface FirestoreCallback {
        void onCallback(QueryDocumentSnapshot document);



    }
}