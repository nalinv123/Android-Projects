package com.nvdevelopers.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edUserID, edName;
    Button btInsert, btDelete, btDisplay, btUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUserID = findViewById(R.id.edUserID);
        edName = findViewById(R.id.edName);

        btInsert = findViewById(R.id.btInsert);
        btDelete = findViewById(R.id.btDelete);
        btDisplay = findViewById(R.id.btDisplay);
        btUpdate = findViewById(R.id.btUpdate);

        doDatabaseOperation();
    }

    private void doDatabaseOperation() {
        final DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name;

                Name = edName.getText().toString();

                //Log.i("User Name", Name);
                //Log.i("Address", Address);
                if (dataBaseHelper.InsertData(Name))
                {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelper.DeleteData();
            }
        });

        btDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dataBaseHelper.DisplayData();
                String row = null;
                ListView listView = new ListView(MainActivity.this);

                List Records = new ArrayList();
                while (cursor.moveToNext())
                {
                    row = cursor.getString(0) + cursor.getString(1) ;
                    Records.add(row);
                }

                cursor.close();

                ArrayAdapter<ArrayList> arrayListArrayAdapter = new ArrayAdapter<ArrayList>(MainActivity.this, R.layout.listview_item, R.id.tvUserID, Records);
                listView.setAdapter(arrayListArrayAdapter);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setView(listView);
                alertDialog.create().show();
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserID, Name;

                UserID = edUserID.getText().toString();
                Name = edName.getText().toString();

                dataBaseHelper.UpdateData(UserID, Name);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}
