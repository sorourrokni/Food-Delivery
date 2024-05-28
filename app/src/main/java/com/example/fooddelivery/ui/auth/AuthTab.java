package com.example.fooddelivery.ui.auth;

import androidx.annotation.NonNull;
/**
 * Enum representing the different authentication tabs.
 */
public enum AuthTab {
    /**
     * The login tab.
     */
    LOGIN("Login"),
    /**
     * The sign-up tab.
     */
    SIGNUP("Sign-up");

    private final String title;

    AuthTab(String title) {
        this.title = title;
    }
    /**
     * Returns the title of the authentication tab.
     *
     * @return the title of the tab.
     */
    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
