package com.example.taskbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton personalButton, workButton, educationButton;
    private RadioButton lastSelectedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        personalButton = findViewById(R.id.personalRadioButton);
        workButton = findViewById(R.id.workRadioButton);
        educationButton = findViewById(R.id.educationRadioButton);

        personalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkSelection();
            }
        });

        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkSelection();
            }
        });

        educationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkSelection();
            }
        });
    }
    private boolean checkSelection() {
        // Vérifie si au moins une option est sélectionnée
        if (personalButton.isChecked() || workButton.isChecked() || educationButton.isChecked()) {
            // Si oui, active le bouton "Continue"
            findViewById(R.id.continueButton).setEnabled(true);
        } else {
            // Sinon, désactive le bouton "Continue"
            findViewById(R.id.continueButton).setEnabled(false);
        }
        return true;
    }
    public void goToNextActivity(View view) {
        if (checkSelection()) {
            Intent intent = new Intent(MainActivity.this, Activity_register.class);
            startActivity(intent);
        }
        else {
            // Affichez un message à l'utilisateur pour sélectionner une option
            Toast.makeText(MainActivity.this, "Veuillez sélectionner une option", Toast.LENGTH_SHORT).show();
        }
    }


}
