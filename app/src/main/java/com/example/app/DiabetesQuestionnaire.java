package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;


public class DiabetesQuestionnaire extends AppCompatActivity {

    private EditText pregnancyEditText;
    private EditText glucoseEditText;
    private EditText bloodPressureEditText;
    private EditText skinThicknessEditText;
    private EditText insulinEditText;
    private EditText bmiEditText;
    private EditText pedigreeFunctionEditText;
    private EditText ageEditText;
    private EditText outcomeEditText;

    private Button submitButton;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_questionnaire);


        // Initialize Firebase Firestore
        db = FirebaseFirestore.getInstance();

        // Initialize EditText fields
        pregnancyEditText = findViewById(R.id.pregnancy);
        glucoseEditText = findViewById(R.id.glucose);
        bloodPressureEditText = findViewById(R.id.blood_pressure);
        skinThicknessEditText = findViewById(R.id.skin_thickness);
        insulinEditText = findViewById(R.id.insulin);
        bmiEditText = findViewById(R.id.bmi);
        pedigreeFunctionEditText = findViewById(R.id.pedigree_function);
        ageEditText = findViewById(R.id.age);
        outcomeEditText = findViewById(R.id.outcome);

        // Initialize Save button and set an onClickListener
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from EditText fields
                int pregnancy = Integer.parseInt(pregnancyEditText.getText().toString());
                int glucose = Integer.parseInt(glucoseEditText.getText().toString());
                int bloodPressure = Integer.parseInt(bloodPressureEditText.getText().toString());
                int skinThickness = Integer.parseInt(skinThicknessEditText.getText().toString());
                int insulin = Integer.parseInt(insulinEditText.getText().toString());
                double bmi = Double.parseDouble(bmiEditText.getText().toString());
                double pedigreeFunction = Double.parseDouble(pedigreeFunctionEditText.getText().toString());
                int age = Integer.parseInt(ageEditText.getText().toString());
                int outcome = Integer.parseInt(outcomeEditText.getText().toString());

                // Create a map with the values
                Map<String, Object> data = new HashMap<>();
                data.put("pregnancy", pregnancy);
                data.put("glucose", glucose);
                data.put("bloodPressure", bloodPressure);
                data.put("skinThickness", skinThickness);
                data.put("insulin", insulin);
                data.put("bmi", bmi);
                data.put("pedigreeFunction", pedigreeFunction);
                data.put("age", age);
                data.put("outcome", outcome);

                // Add the map as a new document in the Firestore collection
                db.collection("diabetes_data")
                        .add(data)
                        .addOnSuccessListener(documentReference -> {
                            // Document added successfully
                            // Show a success message using a Toast:
                            Toast.makeText(DiabetesQuestionnaire.this, "Data added successfully!", Toast.LENGTH_SHORT).show();

                            pregnancyEditText.setText("");
                            glucoseEditText.setText("");
                            bloodPressureEditText.setText("");
                            skinThicknessEditText.setText("");
                            insulinEditText.setText("");
                            bmiEditText.setText("");
                            pedigreeFunctionEditText.setText("");
                            ageEditText.setText("");
                            outcomeEditText.setText("");
                        })
                        .addOnFailureListener(e -> {

                            Toast.makeText(DiabetesQuestionnaire.this, "Error adding data: " + e.getMessage(), Toast.LENGTH_SHORT).show();

                            Log.e("Firestore", "Error adding data: " + e.getMessage());
                        });
            }
        });


    }
}