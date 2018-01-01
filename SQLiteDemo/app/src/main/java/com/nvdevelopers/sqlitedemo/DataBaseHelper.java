package com.nvdevelopers.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nalin on 31/12/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper
{
    private static final int DatabaseVersion = 1;
    private static final String DATABASE_NAME = "demo.db";
    private static final String TABLE_NAME = "UserInfo";
    private static final String COLUMN_NAME_ID = "UserID";
    private static final String COLUMN_NAME_NAME = "Name";
    private static final String COLUMN_NAME_ADDRESS = "Address";
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + COLUMN_NAME_ID + " integer primary key, " + COLUMN_NAME_NAME
            + " text, " + COLUMN_NAME_ADDRESS + " text )";
    private static final String DELETE_TABLE = "drop table if exists" + TABLE_NAME;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }

    protected boolean InsertData(String Name)
    {
        //Gets Database in write mode
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long iResult = 0 ;

        //create object of ContentValues and using put() method put the data that we want to store in database table
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COLUMN_NAME_ID, UserID);
        contentValues.put(COLUMN_NAME_NAME, Name);
        //Insert new record in table
        iResult = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (iResult == 0)
        {
            return false;
        }
        sqLiteDatabase.close();
        return true;
    }

    protected Cursor DisplayData()
    {
        String[] projection = {
                COLUMN_NAME_ID,
                COLUMN_NAME_NAME,
                COLUMN_NAME_ADDRESS
        };

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        //create a Cursor object to gets rows from database
        /*Cursor cursor = sqLiteDatabase.query(
                TABLE_NAME,                 //Name of table on which you want to query
                projection,                 //Name of columns to be return
                null,              //Columns for where clause
                null,           //Values for where clause
                null,               //values for group by clause
                null,                //values for having clause
                null                //value for sort order
        );*/
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);

        return cursor;
    }

    public void DeleteData() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, null, null);
        sqLiteDatabase.close();
    }

    public int UpdateData(String userID, String name) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_NAME, name);

        String selection = COLUMN_NAME_ID + " = ? ";
        String selctionargs[] = {userID};

        int count = sqLiteDatabase.update(TABLE_NAME, contentValues, selection, selctionargs);
        return count;
    }
}
