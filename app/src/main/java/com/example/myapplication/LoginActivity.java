package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etAccount;
    private EditText etPassword;
    private TextView tvError;
    private PrefsManager prefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefsManager = new PrefsManager(this);
        prefsManager.ensureDefaultUser();

        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        tvError = findViewById(R.id.tv_error);
        Button btnLogin = findViewById(R.id.btn_login);
        View btnWechat = findViewById(R.id.btn_wechat_login);
        View btnApple = findViewById(R.id.btn_apple_login);

        btnLogin.setOnClickListener(v -> handleLogin());

        View.OnClickListener otherLoginClickListener = v -> {
            int id = v.getId();
            if (id == R.id.btn_wechat_login) {
                Toast.makeText(LoginActivity.this, "微信登录功能暂未实现", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.btn_apple_login) {
                Toast.makeText(LoginActivity.this, "Apple 登录功能暂未实现", Toast.LENGTH_SHORT).show();
            }
        };

        btnWechat.setOnClickListener(otherLoginClickListener);
        btnApple.setOnClickListener(otherLoginClickListener);
    }

    private void handleLogin() {
        String account = etAccount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            tvError.setVisibility(View.VISIBLE);
            tvError.setText("账号或密码不能为空");
            return;
        }

        if (prefsManager.checkLogin(account, password)) {
            tvError.setVisibility(View.GONE);
            prefsManager.ensureDefaultProfile();
            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish();
        } else {
            tvError.setVisibility(View.VISIBLE);
            tvError.setText("账号或密码错误");
        }
    }
}

