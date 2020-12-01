package za.co.virginactive.android.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import za.co.virginactive.android.R;

public class LandingActivity extends AppCompatActivity {

    ConstraintLayout btnCurrentMember, btnNewMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        btnCurrentMember = findViewById(R.id.btnCurrentMember);
        btnCurrentMember.setOnClickListener(v -> {
            Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}