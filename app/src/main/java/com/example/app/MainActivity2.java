package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    ImageView imageView;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);

        findViewById(R.id.btn_login).setOnClickListener(v -> loginUser());
        findViewById(R.id.regNow).setOnClickListener(v -> navigateToMainActivity3());
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            navigateToMainActivity4();
        }
    }


    private void loginUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity2.this, "Please enter email and password", Toast.LENGTH_LONG).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            progressBar.setVisibility(View.GONE);
            if (task.isSuccessful()) {
                Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                navigateToMainActivity4();
            } else {
                Toast.makeText(MainActivity2.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToMainActivity3() {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(intent);
        finish();
    }

    private void navigateToMainActivity4() {
        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
        startActivity(intent);
        finish();
    }


}
