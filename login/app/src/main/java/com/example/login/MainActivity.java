package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView passwordInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widgetInit();
        widgetSignal();
    }

    protected void widgetInit() {
        loginButton = findViewById(R.id.loginButton);
        passwordInput = findViewById(R.id.passwordInput);
    }

    protected void widgetSignal() {
        loginButton.setOnClickListener(view -> {
            CharSequence message = passwordInput.getText();
            if (message.toString().isEmpty()) {
                message = "it is an empty password";
            }
            Toast.makeText(getApplicationContext(), "password: " + message, Toast.LENGTH_SHORT).show();
        });
    }
}