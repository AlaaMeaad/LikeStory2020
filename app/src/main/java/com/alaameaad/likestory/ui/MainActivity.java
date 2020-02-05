package com.alaameaad.likestory.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.alaameaad.likestory.R;
import com.alaameaad.likestory.test.ForegroundService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static MainActivity m ;
    Toolbar toolbar;
    private NavController navController;
    private NavHostFragment navHostFragment;
    private Toolbar mToolbar;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.tool_bar);
        m = this;
        setSupportActionBar(toolbar);

//        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black);

//        Intent startIntent = new Intent(MainActivity.this, ForegroundService.class);
//        startIntent.setAction(com.alaameaad.likestory.test.Constants.ACTION.STARTFOREGROUND_ACTION);
//        startService(startIntent);

    }










}
