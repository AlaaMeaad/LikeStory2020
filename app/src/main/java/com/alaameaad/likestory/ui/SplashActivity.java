package com.alaameaad.likestory.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.alaameaad.likestory.helper.InternetState;
import com.alaameaad.likestory.R;

import static com.alaameaad.likestory.helper.HelperMethod.ReplaceFragment;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (InternetState.isConnected(getApplicationContext())) {

                    Intent intent = new Intent(SplashActivity.this , MainActivity.class);

                    startActivity(intent);
                } else {
                    ReplaceFragment(new NotConnectionFragment(), getSupportFragmentManager(), R.id.fragment , null, null);
                }


            }

        }, 4000);
    }
}
