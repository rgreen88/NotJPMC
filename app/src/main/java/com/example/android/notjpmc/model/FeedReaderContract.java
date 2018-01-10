package com.example.android.notjpmc.model;

import android.provider.BaseColumns;

/**
 * Created by Ryne on 1/10/2018.
 */

public final class FeedReaderContract {

    public FeedReaderContract(){} //empty constructor for place holders

    /*Defining table contents to be created*/
    public static abstract class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "person";
        public static final String COLUMN_NAME_ENTRY = "person_id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
