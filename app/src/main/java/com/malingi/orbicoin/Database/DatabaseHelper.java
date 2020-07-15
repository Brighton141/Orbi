package com.malingi.orbicoin.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "BlessedMG.db";
    public static final String TABLE_NAME1 = "Client_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRST_NAME";
    public static final String COL_3 = "LAST_NAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "PHONE";
    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "RE_PASSWORD";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME1 +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,LAST_NAME TEXT,EMAIL VARCHAR,PHONE BIGINT,PASSWORD VARCHAR," +
                "RE_PASSWORD VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public boolean insertdata(String firstName, String lastName, String email, String phone, String password, String re_password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,firstName);
        contentValues.put(COL_3,lastName);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,phone);
        contentValues.put(COL_6,password);
        contentValues.put(COL_7,re_password);

        long result = db.insert(TABLE_NAME1,null ,contentValues);
        return result != -1;
    }

    public Cursor getAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT firstName, lastName, email, phone, password, re_password FROM "+TABLE_NAME1,null);
    }

    public Cursor getClient() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT FIRST_NAME FROM "+TABLE_NAME1,null);
    }

    public boolean updateData(String id,String firstName,String lastName,String email,String phone,String password,String re_password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,firstName);
        contentValues.put(COL_3,lastName);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,phone);
        contentValues.put(COL_6,password);
        contentValues.put(COL_7,re_password);
        db.update(TABLE_NAME1, contentValues, "ID = ?",new String[] {id});
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
    return db.delete(TABLE_NAME1, "ID = ?",new String[] {id});
    }

    public Cursor getloginData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT userName, password FROM "+TABLE_NAME1,null);
    }

    public boolean checkUser(String userName, String password){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_6 + "=?";
        String[] selectionArgs = { userName, password };
        Cursor cursor = db.query(TABLE_NAME1,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    public String getuser_name() {
        String selectQuery = "SELECT  FIRST_NAME FROM " + TABLE_NAME1;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String data      = null;

        if (cursor.moveToFirst()) {
            do {
                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }
}
