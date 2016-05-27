package com.app.firebasedb.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by zeeshanhanif-pc on 5/26/2016.
 */
public class FirebaseService {



    public FirebaseService(){

    }

    public void updateMessage(String message){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue(message);
    }

}
