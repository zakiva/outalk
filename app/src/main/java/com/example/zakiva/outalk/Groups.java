package com.example.zakiva.outalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class Groups extends AppCompatActivity {
    private Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        firebase = new Firebase("https://vivid-inferno-9487.firebaseio.com/");
    }

    public void buttonCreateGroupClicked(View view) {
        // Pass arguments to chat
        final Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        EditText inputText = (EditText) findViewById(R.id.groupName);
        String groupName = inputText.getText().toString();
        Intent chat = new Intent(Groups.this, Chat.class);
        chat.putExtra("username", username);
        chat.putExtra("name", groupName);
        // Create new group in database
        GroupInfo groupInfo = new GroupInfo(groupName, "1");
        Post post = new Post("Welcome to the group!", "Groupy");
        firebase.child("groups").child(groupName).child("info").push().setValue(groupInfo);
        firebase.child("groups").child(groupName).child("posts").push().setValue(post);

        startActivity(chat);
    }
}
