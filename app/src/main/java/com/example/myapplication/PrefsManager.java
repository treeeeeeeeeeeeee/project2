package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {

    private static final String PREF_NAME = "user_prefs";

    private static final String KEY_DEFAULT_ACCOUNT = "default_account";
    private static final String KEY_DEFAULT_PASSWORD = "default_password";

    private static final String KEY_USERNAME = "username";
    private static final String KEY_SIGNATURE = "signature";

    private static final String DEFAULT_ACCOUNT_VALUE = "student";
    private static final String DEFAULT_PASSWORD_VALUE = "123456";

    private static final String DEFAULT_USERNAME_VALUE = "Android 学员";
    private static final String DEFAULT_SIGNATURE_VALUE = "热爱编程，热爱生活";

    private final SharedPreferences prefs;

    public PrefsManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void ensureDefaultUser() {
        if (!prefs.contains(KEY_DEFAULT_ACCOUNT) || !prefs.contains(KEY_DEFAULT_PASSWORD)) {
            prefs.edit()
                    .putString(KEY_DEFAULT_ACCOUNT, DEFAULT_ACCOUNT_VALUE)
                    .putString(KEY_DEFAULT_PASSWORD, DEFAULT_PASSWORD_VALUE)
                    .apply();
        }
    }

    public boolean checkLogin(String account, String password) {
        String savedAccount = prefs.getString(KEY_DEFAULT_ACCOUNT, DEFAULT_ACCOUNT_VALUE);
        String savedPassword = prefs.getString(KEY_DEFAULT_PASSWORD, DEFAULT_PASSWORD_VALUE);
        return (DEFAULT_ACCOUNT_VALUE.equals(account) && DEFAULT_PASSWORD_VALUE.equals(password))
                || (savedAccount != null && savedPassword != null
                && savedAccount.equals(account) && savedPassword.equals(password));
    }

    public String getUsername() {
        return prefs.getString(KEY_USERNAME, "");
    }

    public void setUsername(String username) {
        prefs.edit().putString(KEY_USERNAME, username).apply();
    }

    public String getSignature() {
        return prefs.getString(KEY_SIGNATURE, "");
    }

    public void setSignature(String signature) {
        prefs.edit().putString(KEY_SIGNATURE, signature).apply();
    }

    public void ensureDefaultProfile() {
        if (!prefs.contains(KEY_USERNAME)) {
            setUsername(DEFAULT_USERNAME_VALUE);
        }
        if (!prefs.contains(KEY_SIGNATURE)) {
            setSignature(DEFAULT_SIGNATURE_VALUE);
        }
    }
}
