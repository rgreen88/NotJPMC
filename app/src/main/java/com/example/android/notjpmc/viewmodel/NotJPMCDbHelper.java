package com.example.android.notjpmc.viewmodel;

import com.example.android.notjpmc.model.NotJPMCContract;

/**
 * Created by Ryne on 1/10/2018.
 */

public class NotJPMCDbHelper {

    //TODO: Solve mem leak caused by static instance variable
    private static NotJPMCDbHelper notJPMCDbHelper;

    //database ver and name creation
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "NotJPMC.db";

    //sql entries and data type used
    public static final String TEXT_TYPE = "TEXT";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NotJPMCContract.NotJPMCEntry.TABLE_NAME + " (" +
                    NotJPMCContract.NotJPMCEntry._ID + " INTEGER PRIMARY KEY," + //id primary key
                    NotJPMCContract.NotJPMCEntry.COLUMN_NAME_ENTRY + TEXT_TYPE + "," +
                    NotJPMCContract.NotJPMCEntry.COLUMN_NAME_TITLE + TEXT_TYPE + "," +
                    NotJPMCContract.NotJPMCEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE +
                    " )"; //Took class variables to populate database in Helper from Contract

}
