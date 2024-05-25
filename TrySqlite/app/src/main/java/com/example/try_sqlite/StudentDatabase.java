package com.example.try_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME = "class_b21-9.db";
    private static final int DB_VERSION = 2;

    //学生表名称和列名称
    public static final String TABLE_STUDENT = "student";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CLASS = "class";
    public static final String COLUMN_NAME = "name";

    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE " + TABLE_STUDENT + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_CLASS + " TEXT," +
            COLUMN_NAME + " TEXT)";

    public StudentDatabase(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENT);
        db.execSQL("INSERT INTO " + TABLE_STUDENT + " VALUES(2311653, '计科B21-9', '郭天宇');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }
}
