package com.example.zakiva.outalk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

public class Feed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Firebase.setAndroidContext(this);
    }

    public void chatButtonClicked(View view) {
        // Start quick chat of 'group_ex1' (easy to debug chat screen)
        Intent chat = new Intent(Feed.this, Chat.class);
        chat.putExtra("username", ((EditText) findViewById(R.id.editText)).getText().toString());
        chat.putExtra("name", "group_ex1");
        startActivity(chat);
    }

    public void createGroupButtonClicked(View view) {
        // Creating new groups
        Intent groups = new Intent(Feed.this, Groups.class);
        groups.putExtra("username", ((EditText) findViewById(R.id.editText)).getText().toString());
        //storeInLocalDatabae("username", ((EditText) findViewById(R.id.editText)).getText().toString());
        startActivity(groups);
    }




}
