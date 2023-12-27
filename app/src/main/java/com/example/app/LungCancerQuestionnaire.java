package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class LungCancerQuestionnaire extends AppCompatActivity {

    private EditText ageEditText, alcoholEditText, allergyEditText, breathShortnessEditText,
            chestPainEditText, chronicDiseaseEditText, coughingEditText, fatigueEditText,
            peerPressureEditText, smokingEditText, swallowingDifficultyEditText, wheezingEditText, yellowFingersEditText;
    private RadioGroup genderRadioGroup;
    private Button submitButton;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lung_cancer_questionnaire);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        // Initialize UI elements
        ageEditText = findViewById(R.id.age);
        alcoholEditText = findViewById(R.id.alcohol_consumption);
        allergyEditText = findViewById(R.id.allergy);
        breathShortnessEditText = findViewById(R.id.breath_shortness);
        chestPainEditText = findViewById(R.id.chest_pain);
        chronicDiseaseEditText = findViewById(R.id.chronic_disease);
        coughingEditText = findViewById(R.id.coughing);
        fatigueEditText = findViewById(R.id.fatigue);
        peerPressureEditText = findViewById(R.id.peer_pressure);
        smokingEditText = findViewById(R.id.smoking);
        swallowingDifficultyEditText = findViewById(R.id.swallowing_difficulty);
        wheezingEditText = findViewById(R.id.wheezing);
        yellowFingersEditText = findViewById(R.id.yellow_fingers);

        genderRadioGroup = findViewById(R.id.gender_group);

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get values from UI elements
                int age = Integer.parseInt(ageEditText.getText().toString());
                String alcoholConsumption = convertYesNoToBinary(alcoholEditText.getText().toString());
                String allergy = convertYesNoToBinary(allergyEditText.getText().toString());
                String breathShortness = convertYesNoToBinary(breathShortnessEditText.getText().toString());
                String chestPain = convertYesNoToBinary(chestPainEditText.getText().toString());
                String chronicDisease = convertYesNoToBinary(chronicDiseaseEditText.getText().toString());
                String coughing = convertYesNoToBinary(coughingEditText.getText().toString());
                String fatigue = convertYesNoToBinary(fatigueEditText.getText().toString());
                String peerPressure = convertYesNoToBinary(peerPressureEditText.getText().toString());
                String smoking = convertYesNoToBinary(smokingEditText.getText().toString());
                String swallowingDifficulty = convertYesNoToBinary(swallowingDifficultyEditText.getText().toString());
                String wheezing = convertYesNoToBinary(wheezingEditText.getText().toString());
                String yellowFingers = convertYesNoToBinary(yellowFingersEditText.getText().toString());

                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
                String gender = selectedGenderRadioButton.getText().toString();


                // Convert gender to the desired format
                if (gender.equalsIgnoreCase("Male")) {
                    gender = "1";
                } else if (gender.equalsIgnoreCase("Female")) {
                    gender = "0";
                }

                // Create an instance of LungCancerData with the retrieved values
                LungCancerData lungCancerData = new LungCancerData(age, alcoholConsumption, allergy, breathShortness,
                        chestPain, chronicDisease, coughing, fatigue, gender, peerPressure, smoking,
                        swallowingDifficulty, wheezing, yellowFingers);

                // Store the data in Firestore
                db.collection("lung_cancer_data")
                        .add(lungCancerData)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LungCancerQuestionnaire.this,
                                            "Data submitted successfully!", Toast.LENGTH_SHORT).show();
                                    clearForm();
                                } else {
                                    Toast.makeText(LungCancerQuestionnaire.this,
                                            "Error submitting data.", Toast.LENGTH_SHORT).show();
                                }
                            }

                            private void clearForm() {
                                // Clear all input fields
                                ageEditText.setText("");
                                alcoholEditText.setText("");
                                allergyEditText.setText("");
                                breathShortnessEditText.setText("");
                                chestPainEditText.setText("");
                                chronicDiseaseEditText.setText("");
                                coughingEditText.setText("");
                                fatigueEditText.setText("");
                                peerPressureEditText.setText("");
                                smokingEditText.setText("");
                                swallowingDifficultyEditText.setText("");
                                wheezingEditText.setText("");
                                yellowFingersEditText.setText("");

                                // Clear the selected radio button in the genderRadioGroup
                                genderRadioGroup.clearCheck();
                            }
                        });
            }
        });
    }

    // Helper function to convert "Yes" or "No" to 1 or 2
    private String convertYesNoToBinary(String input) {
        return input.equalsIgnoreCase("Yes") ? "1" : "2";
    }
}



