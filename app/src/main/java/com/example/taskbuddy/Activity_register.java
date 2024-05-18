package com.example.taskbuddy;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_register extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView profileImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        profileImageView = findViewById(R.id.profileImageView);
        profileImageView.setOnClickListener(v -> onProfileImageClick());
    }

    private void onProfileImageClick() {
        // Code à exécuter lors du clic sur l'image de profil
        // Par exemple, ouvrir une activité de sélection d'image
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    // Méthode pour gérer le résultat de la sélection d'image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // L'utilisateur a sélectionné une image
            profileImageView.setImageURI(data.getData());
        }
    }


}