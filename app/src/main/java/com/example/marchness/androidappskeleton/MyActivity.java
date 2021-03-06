package com.example.marchness.androidappskeleton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import com.firebase.client.Firebase;
//Time
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;



public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));

        setContentView(R.layout.activity_my);

        //Firebase
        Firebase.setAndroidContext(this);

        /*
        Button clicker = (Button) findViewById(R.id.clickButton);
        clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text_display = (TextView) findViewById(R.id.textView);
                text_display.setText("Changed!");
            }
        });*/


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    */

    }
    public void login(View submit) {
        Firebase myFirebaseRef = new Firebase("https://vivid-inferno-1606.firebaseio.com/");
        EditText nameEditText = (EditText) findViewById(R.id.username);
        EditText passwordEditText = (EditText) findViewById(R.id.password);

        String username = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        User user = new User();
        user.setName(username);
        user.setUserPassword(password);
        myFirebaseRef.child(user.getUserId()).setValue(username);

        Intent output = new Intent();
        setResult(RESULT_OK, output);
        finish();

    }

    public void signUp(View signup) {
        Firebase myFirebaseRef = new Firebase("https://vivid-inferno-1606.firebaseio.com/");
        setContentView(R.layout.activity_signup);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        System.out.println("hit on create options menu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
