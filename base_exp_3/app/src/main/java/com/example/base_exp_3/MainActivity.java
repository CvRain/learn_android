package com.example.base_exp_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFetchPreferences();

        Button loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(this::onLoginButtonClicked);
    }

    private void onLoginButtonClicked(View view){
        String userName = fetchInputText(findViewById(R.id.account_input));
        String password = fetchInputText(findViewById(R.id.password_input));
        boolean isLogin = userLogin(userName, password);

        if(!isLogin){
            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        CheckBox remember_me = findViewById(R.id.checkBox);
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(remember_me.isChecked()){
            editor.putString("user_name", userName);
            editor.putString("password", password);
            editor.apply();
        } else {
            editor.remove("user_name");
            editor.remove("password");
            editor.apply();
        }
        Intent intent = new Intent(this, UsersActivity.class);
        startActivity(intent);

    }

    private void initFetchPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("user_name", "");
        String savedPassword = sharedPreferences.getString("password", "");
        setInputText(findViewById(R.id.account_input), savedUsername);
        setInputText(findViewById(R.id.password_input), savedPassword);
    }

    private String fetchInputText(AppCompatEditText editText){
        //check edit text is empty
        if(Objects.requireNonNull(editText.getText()).toString().isEmpty()){
            return "";
        }else{
            return editText.getText().toString();
        }
    }

    private void setInputText(AppCompatEditText editText, String text){
        editText.setText(text);
    }

    private boolean userLogin(String userName, String password){
        return userName.equals("admin") && password.equals("123456");
    }
}