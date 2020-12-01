package za.co.virginactive.android.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import za.co.virginactive.android.R;
import za.co.virginactive.android.service.model.ClubLists;
import za.co.virginactive.android.service.model.LoginToken;
import za.co.virginactive.android.service.repository.ApiInterface;
import za.co.virginactive.android.service.repository.ProjectRepositoryAuth;
import za.co.virginactive.android.util.SharedPreference;
import za.co.virginactive.android.util.Utils;

public class LoginActivity extends AppCompatActivity {
    ImageView ivBack;
    EditText edEmail, edPassword;
    TextView tvShowPassword, tvForgotPassword;
    boolean isPasswordShown = false;
    ConstraintLayout btnContinue;
    ProjectRepositoryAuth repositoryAuth;
    private MutableLiveData<LoginToken> listLiveData = new MutableLiveData<>();
    ApiInterface apiInterface;
    SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreference = new SharedPreference(this);
        initViews();
    }

    /**
     * All view components are initialised here
     */
    private void initViews() {
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> onBackPressed());
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        tvShowPassword = findViewById(R.id.tvShowPassword);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        btnContinue = findViewById(R.id.btnContinue);

        tvShowPassword.setOnClickListener(v -> {
            if (!isPasswordShown) {
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

        btnContinue.setOnClickListener(v -> {
            if (TextUtils.isEmpty(edEmail.getText())) {
                //Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
                Utils.showToast(this, "Please enter email");
            } else if (!TextUtils.isEmpty(edEmail.getText()) &&
                    !Patterns.EMAIL_ADDRESS.matcher(edEmail.getText()).matches()) {
//                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_LONG).show();
                Utils.showToast(this, "Please enter a valid email");
            } else if (TextUtils.isEmpty(edPassword.getText())) {
                // Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
                Utils.showToast(this, "Please enter password");
            } else {
                JsonObject object = new JsonObject();
                object.addProperty("grant_type", "password");
                object.addProperty("username", edEmail.getText().toString());
                object.addProperty("password", edPassword.getText().toString());

                //repositoryAuth = new ProjectRepositoryAuth();
                //listLiveData.setValue(repositoryAuth.getLoginToken(object).getValue());
                ProjectRepositoryAuth.getRetrofitClient().getLoginToken(object.toString()).enqueue(new Callback<LoginToken>() {
                    @Override
                    public void onResponse(Call<LoginToken> call, Response<LoginToken> response) {
                        //data.setValue(response.body());
                        if (response.body() != null) {
                            //sharedPreference.saveObject(SharedPreference.loginDetails, response.body());
                            sharedPreference.saveData(SharedPreference.userToken, response.body().getAccessToken());
                            sharedPreference.saveData(SharedPreference.memberId, response.body().getMemberId().toString());
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginToken> call, Throwable t) {
                        Log.e("GETCLUBS", t.getMessage().toString());
                        //Utils.showToast(LoginActivity.this, t.getMessage());
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                /*Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);*/
            }
        });

        tvForgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }

    /*private void showToast(String message) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.custom_toast));
        TextView tvMessage = layout.findViewById(R.id.tvMessage);
        tvMessage.setText(message);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setText(message);
        toast.setView(layout);
        toast.show();
    }*/
}