package com.example.android.notjpmc.viewmodel;

/**
 * Created by Ryne on 1/10/2018.
 */

public class NotJPMCDbHelper {

    //TODO: Solve mem leak caused by static instance variable
    private static NotJPMCDbHelper notJPMCDbHelper;

    //database ver and name creation
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "NotJPMC.db";



}
