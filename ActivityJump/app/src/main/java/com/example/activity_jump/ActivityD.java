package com.example.activity_jump;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityD extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        editText = findViewById(R.id.editText);
        Button buttonConfirm = findViewById(R.id.button_confirm);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                // Create an intent to return the text to ActivityC
                Intent intent = new Intent();
                intent.putExtra("text", text);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
