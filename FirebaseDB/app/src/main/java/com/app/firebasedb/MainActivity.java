package com.app.firebasedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.firebasedb.firebase.FirebaseService;

public class MainActivity extends AppCompatActivity {


    EditText textMessage;
    Button updateMessageButton;
    FirebaseService firebaseService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseService = new FirebaseService();
        initComponents();
        setupListeners();
    }

    public void initComponents(){
        textMessage = (EditText) findViewById(R.id.editText);
        updateMessageButton = (Button) findViewById(R.id.updateButton);
    }

    public void setupListeners(){
        updateMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseService.updateMessage(textMessage.getText().toString());
            }
        });
    }
}
