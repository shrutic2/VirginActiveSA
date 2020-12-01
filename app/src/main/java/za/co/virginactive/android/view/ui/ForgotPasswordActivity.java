package za.co.virginactive.android.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import za.co.virginactive.android.R;
import za.co.virginactive.android.util.Utils;

public class ForgotPasswordActivity extends AppCompatActivity {
    ImageView ivBack;
    EditText edEmail, edMember;
    ConstraintLayout btnContinue;
    TextView tvResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initViews();
    }

    private void initViews() {
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> onBackPressed());
        edEmail = findViewById(R.id.edEmail);
        edMember = findViewById(R.id.edMember);

        btnContinue = findViewById(R.id.btnContinue);
        tvResetPassword = findViewById(R.id.tvResetPassword);


        btnContinue.setOnClickListener(v -> {
            if (edEmail.getText().toString().trim().length() == 0 &&
                    edMember.getText().toString().trim().length() == 0){
//                Toast.makeText(this, "Please enter one of the fields", Toast.LENGTH_LONG).show();
                Utils.showToast(this, "Please enter one of the fields");
            } else if (!TextUtils.isEmpty(edEmail.getText()) &&
                    !Patterns.EMAIL_ADDRESS.matcher(edEmail.getText()).matches()){
//                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_LONG).show();
                Utils.showToast(this, "Please enter a valid email");
            } else {
                Intent intent = new Intent(ForgotPasswordActivity.this, CheckMailActivity.class);
                startActivity(intent);
            }
        });

        tvResetPassword.setOnClickListener(v -> {
            Intent intent = new Intent(ForgotPasswordActivity.this, ResetPasswordMailActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}