package com.example.activity_jump;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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
            showDialog();
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_d, null);

        EditText editText = dialogView.findViewById(R.id.editText);
        Button buttonConfirm = dialogView.findViewById(R.id.button_confirm);

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                String reversedText = new StringBuilder(text).reverse().toString();
                Toast.makeText(ActivityC.this, reversedText, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });



        dialog.show();
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
