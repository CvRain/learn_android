package com.example.base_exp_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentScoreDb extends SQLiteOpenHelper {
    private static final String DB_NAME = "student_score.db";
    private static final int DB_VERSION = 2;

    public static final String TABLE_NAME = "student_score";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SCORE = "score";
    public static final String COLUMN_CLASS_NAME = "class_name";

    public static String CREATE_TABLE;

    public static String CreateTable() {
        CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_NAME + " TEXT PRIMARY KEY," +
                COLUMN_SCORE + " TEXT," +
                COLUMN_CLASS_NAME + " TEXT" +
                ")";
        return CREATE_TABLE;
    }

    public StudentScoreDb(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTable());
        Insert(new UserInfo("张三", "95.0", "计科B15-1"));
        Insert(new UserInfo("李四", "90.0", "计科B15-1"));
        Insert(new UserInfo("王五", "78.0", "计科B15-2"));
        if (db.isOpen())
            System.out.println("Create table success");
        else
            System.out.println("Create table failed");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void Insert(UserInfo userInfo) {
        String userName = userInfo.getName();
        String userScore = userInfo.getScore();
        String userClass = userInfo.getClassName();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, userName);
        values.put(COLUMN_SCORE, userScore);
        values.put(COLUMN_CLASS_NAME, userClass);
        SQLiteDatabase db = getWritableDatabase();
        if (db.insert(TABLE_NAME, null, values) != -1)
            System.out.println("Insert success");
        else
            System.out.println("Insert failed");
    }

    public List<UserInfo> AllStudentScore() {
        List<UserInfo> users = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                COLUMN_NAME,
                COLUMN_SCORE,
                COLUMN_CLASS_NAME
        };

        Cursor cursor = db.query(
                TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String score = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SCORE));
            String className = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CLASS_NAME));
            UserInfo userInfo = new UserInfo(name, score, className);
            users.add(userInfo);
        }

        cursor.close();
        return users;
    }
}
