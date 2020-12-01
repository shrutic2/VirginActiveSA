package za.co.virginactive.android.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import za.co.virginactive.android.R;

public class CheckMailActivity extends AppCompatActivity {
    TextView tvReenterDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_mail);

        initViews();
    }

    private void initViews() {
        tvReenterDetails = findViewById(R.id.tvReenterDetails);
        tvReenterDetails.setOnClickListener(v -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}