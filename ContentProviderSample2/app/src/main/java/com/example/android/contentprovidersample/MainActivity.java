package com.example.android.contentprovidersample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(UserDictionary.Words.CONTENT_URI,null,null,null,null);
        //contentResolver.update()

        ListView listsView = (ListView) findViewById(R.id.words);
        //textView.setText("The UserDictionary contains "+cursor.getCount()+ " words\n");

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,
                cursor,
                new String[]{UserDictionary.Words.WORD,UserDictionary.Words.FREQUENCY},
                new int[]{android.R.id.text1,android.R.id.text2},
                0);

        listsView.setAdapter(adapter);

        //textView.append("COLUMNS: "+cursor.getColumnName(3)+" - "+cursor.getColumnName(2) +" - "+cursor.getColumnName(4)+"\n");

        //cursor.close();
    }
}
