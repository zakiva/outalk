package com.example.zakiva.outalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Intent chat = new Intent(Feed.this, Chat.class);
        chat.putExtra("username", ((EditText) findViewById(R.id.editText)).getText().toString());
        startActivity(chat);
    }
}
