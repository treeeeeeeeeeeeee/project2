package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private PrefsManager prefsManager;
    private TextView tvUsername;
    private TextView tvSignature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        prefsManager = new PrefsManager(this);
        prefsManager.ensureDefaultProfile();

        tvUsername = findViewById(R.id.tv_username);
        tvSignature = findViewById(R.id.tv_signature);

        tvUsername.setText(prefsManager.getUsername());
        tvSignature.setText(prefsManager.getSignature());

        LinearLayout itemProfileInfo = findViewById(R.id.item_profile_info);
        LinearLayout itemFavorite = findViewById(R.id.item_favorite);
        LinearLayout itemHistory = findViewById(R.id.item_history);
        LinearLayout itemSettings = findViewById(R.id.item_settings);
        LinearLayout itemAbout = findViewById(R.id.item_about);
        LinearLayout itemFeedback = findViewById(R.id.item_feedback);

        View.OnClickListener listener = v -> {
            int id = v.getId();
            String msg = "";
            if (id == R.id.item_profile_info) {
                msg = "个人信息";
            } else if (id == R.id.item_favorite) {
                msg = "我的收藏";
            } else if (id == R.id.item_history) {
                msg = "浏览历史";
            } else if (id == R.id.item_settings) {
                msg = "设置";
            } else if (id == R.id.item_about) {
                msg = "关于我们";
            } else if (id == R.id.item_feedback) {
                msg = "意见反馈";
            }
            Toast.makeText(ProfileActivity.this, "点击了：" + msg, Toast.LENGTH_SHORT).show();
        };

        itemProfileInfo.setOnClickListener(listener);
        itemFavorite.setOnClickListener(listener);
        itemHistory.setOnClickListener(listener);
        itemSettings.setOnClickListener(listener);
        itemAbout.setOnClickListener(listener);
        itemFeedback.setOnClickListener(listener);
    }
}

