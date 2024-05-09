package com.example.base_exp_2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText studentIdEditText, nameEditText, majorEditText, classEditText;
    private RadioGroup sexRadioGroup;
    private Spinner collegeSpinner;
    private Button explicitButton, implicitButton;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        studentIdEditText = findViewById(R.id.student_id_edit_text);
        nameEditText = findViewById(R.id.name_edit_text);
        majorEditText = findViewById(R.id.major_edit_text);
        classEditText = findViewById(R.id.class_edit_text);
        sexRadioGroup = findViewById(R.id.sex_input_radio);
        collegeSpinner = findViewById(R.id.spinner);

        explicitButton = findViewById(R.id.explicit_button);
        implicitButton = findViewById(R.id.implicit_button);

        explicitButton.setOnClickListener(this::onExplicitButtonClick);
        implicitButton.setOnClickListener(this::onImplicitButtonClick);
    }

    private void InitializeIntent(boolean isExplicit) {
        if(isExplicit){
            intent = new Intent(MainActivity.this, DisplayActivity.class);
        }else{
            intent = new Intent("com.example.DISPLAY_ACTIVITY");
        }
        // 添加数据到Intent
        intent.putExtra("studentId", studentIdEditText.getText().toString());
        intent.putExtra("name", nameEditText.getText().toString());
        intent.putExtra("major", majorEditText.getText().toString());

        if (sexRadioGroup.getCheckedRadioButtonId() == R.id.male_radio) {
            intent.putExtra("sex", "男");
        } else {
            intent.putExtra("sex", "女");
        }

        intent.putExtra("class", classEditText.getText().toString());
        intent.putExtra("college", collegeSpinner.getSelectedItem().toString());
    }

    public void onExplicitButtonClick(View view) {
        InitializeIntent(true);

        startActivity(intent);
    }

    public void onImplicitButtonClick(View view) {
        InitializeIntent(false);
        startActivity(intent);
    }
}

