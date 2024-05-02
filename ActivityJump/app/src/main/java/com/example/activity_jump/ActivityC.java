package com.example.activity_jump;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityC extends AppCompatActivity {

    private static final int REQUEST_CODE_D = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        Button buttonJumpA = findViewById(R.id.button_jump_a);
        Button buttonJumpB = findViewById(R.id.button_jump_b);

        buttonJumpA.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityC.this, MainActivity.class);
            startActivity(intent);
        });

        buttonJumpB.setOnClickListener(v -> {

            //隐式跳转到Activity_b
            Intent intent = new Intent();
            intent.setAction("com.example.activity_jump.activity_b");
            startActivity(intent);

        });

        Button buttonJumpD = findViewById(R.id.button_jump_d);


        buttonJumpD.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityC.this, ActivityD.class);
            startActivityForResult(intent, REQUEST_CODE_D);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_D) {
            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra("text");
                // Reverse the text
                assert text != null;
                String reversedText = new StringBuilder(text).reverse().toString();
                // Show toast
                Toast.makeText(this, reversedText, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
