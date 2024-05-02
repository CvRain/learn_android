package com.example.activity_jump;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Button gotoWebSite = findViewById(R.id.button_open_web);
        Button gotoActivityA = findViewById(R.id.button_jump_a);
        Button gotoActivityC = findViewById(R.id.button_jump_c);

        gotoWebSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = getIntent().getStringExtra("searchText");
                String url = "https://www.baidu.com/s?wd=" + searchText;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        gotoActivityA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, MainActivity.class);
                startActivity(intent);
            }
        });

        gotoActivityC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, ActivityC.class);
                startActivity(intent);
            }
        });
    }
}
