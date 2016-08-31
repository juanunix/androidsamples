package com.example.android.contentprovidersample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(UserDictionary.Words.CONTENT_URI,null,null,null,null);
        //contentResolver.update()

        TextView textView = (TextView) findViewById(R.id.words);
        textView.setText("The UserDictionary contains "+cursor.getCount()+ " words\n");

        textView.append("COLUMNS: "+cursor.getColumnName(3)+" - "+cursor.getColumnName(2) +" - "+cursor.getColumnName(4)+"\n");
        while(cursor.moveToNext()){
            /*Log.d("MainActivity",cursor.getColumnName(0));
            Log.d("MainActivity",cursor.getColumnName(1));
            Log.d("MainActivity",cursor.getColumnName(2));
            Log.d("MainActivity",cursor.getColumnName(3));
            Log.d("MainActivity",cursor.getColumnName(4));
            Log.d("MainActivity",cursor.getColumnName(5));*/
            textView.append(cursor.getString(3)+" - "+cursor.getString(2) +" - "+cursor.getString(4)+"\n");

        }
        cursor.close();
    }
}
