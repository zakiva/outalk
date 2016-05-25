package com.example.zakiva.outalk;

import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

public class Groups extends ListActivity {

    private Firebase firebase;
    String username;
    String groupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        firebase = new Firebase("https://vivid-inferno-9487.firebaseio.com/");
        final Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        setListeners();

    }

    void setListeners() {

        // Setup our view and list adapter. Ensure it scrolls to the bottom as data changes
        final ListView listView = getListView();
        // Tell our list adapter that we only want 50 messages at a time
        final GroupListAdapter mGroupListAdapter = new GroupListAdapter(firebase.child("groups").child("list of groups"), this, R.layout.group_element, username);
        listView.setAdapter(mGroupListAdapter);
        mGroupListAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(mGroupListAdapter.getCount() - 1);
            }
        });
    }

    public void buttonCreateGroupClicked(View view) {
        // Pass arguments to chat

        EditText inputText = (EditText) findViewById(R.id.groupName);
        groupName = inputText.getText().toString();
        Intent chat = new Intent(Groups.this, Chat.class);
        chat.putExtra("username", username);
        chat.putExtra("name", groupName);
        // Create new group in database
        List users = new ArrayList();
        users.add(username);
        GroupInfo groupInfo = new GroupInfo(groupName, 1, users);
        Post post = new Post("Welcome to the group!", "Groupy");
        firebase.child("groups").child(groupName).child("info").push().setValue(groupInfo);
        firebase.child("groups").child("list of groups").push().setValue(groupInfo);
        firebase.child("groups").child(groupName).child("posts").push().setValue(post);
        startActivity(chat);
    }

}
