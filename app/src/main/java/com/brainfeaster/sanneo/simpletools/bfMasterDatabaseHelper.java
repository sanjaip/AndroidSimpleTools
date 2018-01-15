/* package com.brainfeaster.sanneo.simpletools;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class bfMasterDatabaseHelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "SimpleTools";

    // Table Names
    private static final String TABLE_TODO = "todos";
    private static final String TABLE_TAG = "tags";
    private static final String TABLE_TODO_TAG = "todo_tags";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // NOTES Table - column nmaes
    private static final String KEY_TODO = "todo";
    private static final String KEY_STATUS = "status";

    // TAGS Table - column names
    private static final String KEY_TAG_NAME = "tag_name";

    // NOTE_TAGS Table - column names
    private static final String KEY_TODO_ID = "todo_id";
    private static final String KEY_TAG_ID = "tag_id";



    public bfMasterDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_TODO);
        db.execSQL(CREATE_TABLE_TAG);
        db.execSQL(CREATE_TABLE_TODO_TAG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_TAG);

        // create new tables
        onCreate(db);
    }

}*/
