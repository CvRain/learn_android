package com.example.try_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentDatabase dbHelper = new StudentDatabase(this);
        db = dbHelper.getWritableDatabase();

        String[] projection = {
                StudentDatabase.COLUMN_ID,
                StudentDatabase.COLUMN_CLASS,
                StudentDatabase.COLUMN_NAME
        };

        Cursor cursor = db.query(
                StudentDatabase.TABLE_STUDENT,   // 表名
                projection,                      // 要查询的列
                null,                            // 查询条件
                null,                            // 查询条件的参数
                null,                            // 分组条件
                null,                            // 过滤条件
                null                             // 排序条件
        );

        TextView student_id = findViewById(R.id.view_student_id);
        TextView student_class = findViewById(R.id.view_student_class);
        TextView student_name = findViewById(R.id.view_student_name);

        if (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(StudentDatabase.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(StudentDatabase.COLUMN_NAME));
            String className = cursor.getString(cursor.getColumnIndexOrThrow(StudentDatabase.COLUMN_CLASS));
            student_id.setText(String.valueOf(id));
            student_name.setText(name);
            student_class.setText(className);
            System.out.println("id: " + id + " name: " + name + " class: " + className);
        }

        cursor.close();;
    }
}
