package com.example.fooddelivery.ui.auth;

import androidx.annotation.NonNull;

public enum AuthTab {
    LOGIN("Login"),
    SIGNUP("Sign-up");

    private final String title;

    AuthTab(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
