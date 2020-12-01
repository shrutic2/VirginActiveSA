package za.co.virginactive.android.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import za.co.virginactive.android.R;

public class ResetPasswordActivity extends AppCompatActivity {
    ImageView ivBack;
    EditText edPassword, edConfirmPassword;
    TextView tvShowPassword, tvShowConfirmPassword;
    ConstraintLayout btnResetPassword;
    boolean isPasswordShown = false, isConfirmPasswordShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        initViews();
    }

    private void initViews() {
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> onBackPressed());
        edPassword = findViewById(R.id.edPassword);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);

        btnResetPassword = findViewById(R.id.btnResetPassword);

        tvShowPassword = findViewById(R.id.tvShowPassword);
        tvShowConfirmPassword = findViewById(R.id.tvShowConfirmPassword);

        tvShowPassword.setOnClickListener(v -> {
            if (!isPasswordShown){
                //show password
                edPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                edPassword.setSelection(edPassword.getText().length());
                isPasswordShown = true;
                tvShowPassword.setText(getResources().getString(R.string.hidePassword));
            } else {
                //hide password
                edPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                edPassword.setSelection(edPassword.getText().length());
                isPasswordShown = false;
                tvShowPassword.setText(getResources().getString(R.string.showPassword));
            }
        });

        tvShowConfirmPassword.setOnClickListener(v -> {
            if (!isPasswordShown){
                //show password
                edConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                edConfirmPassword.setSelection(edConfirmPassword.getText().length());
                isConfirmPasswordShown = true;
                tvShowConfirmPassword.setText(getResources().getString(R.string.hidePassword));
            } else {
                //hide password
                edConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                edConfirmPassword.setSelection(edConfirmPassword.getText().length());
                isConfirmPasswordShown = false;
                tvShowConfirmPassword.setText(getResources().getString(R.string.showPassword));
            }
        });
    }
}