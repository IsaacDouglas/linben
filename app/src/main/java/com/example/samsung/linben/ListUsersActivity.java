package com.example.samsung.linben;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Raquel on 15/06/2016.
 */
public class ListUsersActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listusers);

        View listView_users = findViewById(R.id.listView_users);
    }
}