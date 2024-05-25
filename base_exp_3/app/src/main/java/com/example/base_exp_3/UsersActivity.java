package com.example.base_exp_3;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class UsersActivity extends AppCompatActivity {
    private final StudentScoreDb studentScoreDb = new StudentScoreDb(this);
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_users);

        // 查询所有学生信息
//        List<UserInfo> userInfoList = studentScoreDb.AllStudentScore();
//        ListView listView = findViewById(R.id.info_list_view);
//        listView.setAdapter(new UserInfoAdapter(this, R.layout.user_info, userInfoList));
    }

    public void CreateUser(View view) {
        //获得一个0.0~100.0的随机数,保留一位小数
        double score = (int)(Math.random()*1000)/10.0;

        studentScoreDb.Insert(new UserInfo(
                "学生"+String.valueOf(studentScoreDb.AllStudentScore().size()+1),
                String.valueOf(score),
                "计科B21-9")
        );
        LookupUser(view);
    }

    public void LookupUser(View view) {
        List<UserInfo> userInfoList = studentScoreDb.AllStudentScore();
        ListView listView = findViewById(R.id.info_list_view);
        listView.setAdapter(new UserInfoAdapter(this, R.layout.user_info, userInfoList));
    }
}
