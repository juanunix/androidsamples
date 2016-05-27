package com.app.firebasedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.firebasedb.firebase.FirebaseService;
import com.app.firebasedb.firebase.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    EditText editTextName;
    EditText editTextUsername;
    EditText editTextAge;

    Button addUpdateBtn;

    TextView textViewName;
    TextView textViewUsername;
    TextView textViewAge;

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
        editTextName = (EditText) findViewById(R.id.editText);
        editTextUsername = (EditText) findViewById(R.id.editText2);
        editTextAge = (EditText) findViewById(R.id.editText3);
        addUpdateBtn = (Button) findViewById(R.id.button);

        textViewName = (TextView) findViewById(R.id.textViewNameDisplay);
        textViewUsername = (TextView) findViewById(R.id.textViewUserNameDisplay);
        textViewAge = (TextView) findViewById(R.id.textViewAgeDisplay);

    }

    public void setupListeners(){
        addUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u = new User(editTextName.getText().toString(),editTextUsername.getText().toString(), Integer.parseInt(editTextAge.getText().toString()));
                firebaseService.addUpdateUser(u);
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User us = dataSnapshot.getValue(User.class);
                textViewName.setText(us.getName());
                textViewUsername.setText(us.getUsername());
                textViewAge.setText(""+us.getAge());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
