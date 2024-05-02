package com.example.activity_jump;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText editText = findViewById(R.id.editTextText);
        Button buttonJumpB = findViewById(R.id.button_jump_b);
        Button buttonJumpC = findViewById(R.id.button_jump_c);

        buttonJumpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = editText.getText().toString();

                //隐式跳转到Activity_b
                Intent intent = new Intent();
                intent.setAction("com.example.activity_jump.activity_b");
                intent.putExtra("searchText", searchText);
                startActivity(intent);

            }
        });

        buttonJumpC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式跳转到Activity_c
                Intent intent = new Intent();
                intent.setAction("com.example.activity_jump.activity_c");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_call_10000) {
            dialNumber("10000");
        } else if (itemId == R.id.action_call_10010) {
            dialNumber("10010");
        } else if (itemId == R.id.action_call_10086) {
            dialNumber("10086");
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void dialNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }
}