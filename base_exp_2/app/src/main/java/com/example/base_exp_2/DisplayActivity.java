package com.example.base_exp_2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private ListView infoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_user_info);

        infoListView = findViewById(R.id.info_list_view);

        // 获取传递的数据
        String studentId = getIntent().getStringExtra("studentId");
        String name = getIntent().getStringExtra("name");
        String major = getIntent().getStringExtra("major");
        String sex = getIntent().getStringExtra("sex");
        String stuClass = getIntent().getStringExtra("class");
        String college = getIntent().getStringExtra("college");

        // 创建列表项
        List<UserInfo> infoList = new ArrayList<>();
        infoList.add(new UserInfo(R.drawable.credit_card_black, studentId));
        infoList.add(new UserInfo(R.drawable.account_box_black, name));
        infoList.add(new UserInfo(R.drawable.wc_black, sex));
        infoList.add(new UserInfo(R.drawable.account_balance_black, college));
        infoList.add(new UserInfo(R.drawable.school_black, stuClass));
        infoList.add(new UserInfo(R.drawable.assignment_ind_black, major));
        UserInfoAdapter userInfoAdapter = new UserInfoAdapter(this, R.layout.user_info, infoList);
        infoListView.setAdapter(userInfoAdapter);

    }
}

