package com.practice.saadnewpractice;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SYMPTOM_RECORD";
    private static final String TABLE_NAME = "SYMPTOM_DATA";

    private static final String SYMPTOM_ID = "SYMPTOM_ID";
    private static final String SYMPTOM_TITLE = "SYMPTOM_TITLE";
    private static final String SYMPTOM_DESCRIPTION = "SYMPTOM_DESCRIPTION";
    private static final String SYMPTOM_SEVERITY = "SYMPTOM_SEVERITY";
    private static final String START_DATE = "START_DATE";
    private static final String START_TIME = "START_TIME";
    private static final String END_DATE = "END_DATE";
    private static final String END_TIME = "END_TIME";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DatabaseHelper", "onCreate: Creating table");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME+ "(SYMPTOM_ID INTEGER PRIMARY KEY AUTOINCREMENT, SYMPTOM_TITLE TEXT, SYMPTOM_DESCRIPTION TEXT, SYMPTOM_SEVERITY TEXT, START_DATE TEXT, START_TIME TEXT, END_DATE TEXT, END_TIME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String title, String description, String severity, String startdate, String starttime, String enddate, String endtime)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SYMPTOM_TITLE, title);
        values.put(SYMPTOM_DESCRIPTION, description);
        values.put(SYMPTOM_SEVERITY, severity);
        values.put(START_DATE, startdate);
        values.put(START_TIME, starttime);
        values.put(END_DATE, enddate);
        values.put(END_TIME, endtime);

        long var = db.insert(TABLE_NAME, null, values);
        if (var == -1)
        {
            Log.e("DatabaseHelper", "Error inserting data into the database");
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME+  "WHERE SYMPTOM_ID='" + id+"'";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }



}
