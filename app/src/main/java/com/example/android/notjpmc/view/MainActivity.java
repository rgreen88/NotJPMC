package com.example.android.notjpmc.view;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.notjpmc.R;
import com.example.android.notjpmc.model.NotJPMCContract;
import com.example.android.notjpmc.viewmodel.NotJPMCDbHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "NotJPMC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calling instance to write to firebase database for now
        getInstance();

        //must run first for Db
        SQLiteDatabase.loadLibs(this);

        //calling database...will run exception error if above isn't called first
        NotJPMC();
    }

    //creating method to run database at start using NotJPMCDbHelper
    private void NotJPMC() {

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

    private void getInstance() {

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

    }
}
