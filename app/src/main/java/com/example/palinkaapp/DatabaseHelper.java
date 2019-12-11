package com.example.palinkaapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Palinka.db"; //Adatbázis file neve
    public static final String TABLE_NAME = "Palinka"; //Tabla neve

    public static final String COL_1 = "ID"; //Oszlop 1
    public static final String COL_2 = "FOZO"; //Oszlop 2
    public static final String COL_3 = "GYUMOLCS"; //Oszlop 3
    public static final String COL_4 = "ALKOHOL"; //Oszlop 4

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FOZO TEXT, GYUMOLCS TEXT, ALKOHOL INTEGER, UNIQUE(FOZO, GYUMOLCS))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public Cursor adatLekerdezes()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor eredmeny = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return eredmeny;
    }
}
