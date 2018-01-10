package com.example.android.notjpmc.viewmodel;

import android.content.Context;

import com.example.android.notjpmc.model.NotJPMCContract;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by Ryne on 1/10/2018.
 */

public class NotJPMCDbHelper extends SQLiteOpenHelper{

    //TODO: Solve mem leak caused by static instance variable
    private static NotJPMCDbHelper notJPMCDbHelper;

    //database ver and name creation
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "NotJPMC.db";

    //sql entries and data type used
    private static final String TEXT_TYPE = "TEXT";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NotJPMCContract.NotJPMCEntry.TABLE_NAME + " (" +
                    NotJPMCContract.NotJPMCEntry._ID + " INTEGER PRIMARY KEY," + //id primary key
                    NotJPMCContract.NotJPMCEntry.COLUMN_NAME_ENTRY + TEXT_TYPE + "," +
                    NotJPMCContract.NotJPMCEntry.COLUMN_NAME_TITLE + TEXT_TYPE + "," +
                    NotJPMCContract.NotJPMCEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE +
                    " )"; //Took class variables to populate database in Helper from Contract

    //SQL_DELETE_ENTRIES for locating table if it exists
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " +
            NotJPMCContract.NotJPMCEntry.TABLE_NAME;

    //implemented after extending SQLiteOpenHelper
    private NotJPMCDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //synchronization to access a table once per activity
    static public synchronized NotJPMCDbHelper getInstance (Context context){
        if (notJPMCDbHelper == null){
            notJPMCDbHelper = new NotJPMCDbHelper(context);
        }
        return notJPMCDbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
