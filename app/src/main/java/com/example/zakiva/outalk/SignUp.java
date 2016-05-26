package com.example.zakiva.outalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Firebase.setAndroidContext(this);
    }

    public void storeInLocalDatabae(String key, String value ){
        SharedPreferences sharedPref = getSharedPreferences("FILE1", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void buttonQuickChatClicked(View view) {
        Intent chat = new Intent(SignUp.this, Chat.class);
        chat.putExtra("username", ((EditText) findViewById(R.id.signupName)).getText().toString());
        chat.putExtra("name", "group_ex1");
        startActivity(chat);
    }

    public void buttonSignUpClicked(View view) {
        Intent groups = new Intent(SignUp.this, Groups.class);
        groups.putExtra("username", ((EditText) findViewById(R.id.signupName)).getText().toString());
        storeInLocalDatabae("username", ((EditText) findViewById(R.id.signupName)).getText().toString());
        startActivity(groups);
    }
}
