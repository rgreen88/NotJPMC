package com.example.android.notjpmc.view;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.notjpmc.R;
import com.example.android.notjpmc.model.NotJPMCContract;
import com.example.android.notjpmc.viewmodel.NotJPMCDbHelper;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "NotJPMC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //must run first for Db
        SQLiteDatabase.loadLibs(this);

        //calling database...will run exception error if above isn't called first
        NotJPMC();
    }

    //creating method to run database at start using NotJPMCDbHelper
    private void NotJPMC(){

        SQLiteDatabase db = NotJPMCDbHelper.getInstance(this).getWritableDatabase("somePass");

        ContentValues values = new ContentValues();
        values.put(NotJPMCContract.NotJPMCEntry.COLUMN_NAME_ENTRY, 1);
        values.put(NotJPMCContract.NotJPMCEntry.COLUMN_NAME_FIRST_NAME, "Linda");
        values.put(NotJPMCContract.NotJPMCEntry.COLUMN_NAME_LAST_NAME, "Mellinda");

        db.insert(NotJPMCContract.NotJPMCEntry.TABLE_NAME, null, values);

        Cursor cursor = db.rawQuery("SELECT * FROM '" + NotJPMCContract.NotJPMCEntry.TABLE_NAME + "';", null);
        Log.d(TAG, "Rows count: " + cursor.getCount());
        cursor.close();
        db.close();

    }
}
