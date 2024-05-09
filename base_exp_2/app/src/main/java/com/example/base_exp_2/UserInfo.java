package com.example.base_exp_2;

public class UserInfo {
    private final int icon;
    private final String data;

    public UserInfo(int icon, String data) {
        this.icon = icon;
        this.data = data;
    }

    public int getIcon() {
        return icon;
    }

    public String getData() {
        return data;
    }
}
