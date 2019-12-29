package com.alaameaad.likestory.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alaameaad.likestory.InternetState;
import com.alaameaad.likestory.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {

    private ImageView ivImage1 ,ivImage2 , ivImage3 ,ivImage4 ,ivImage5 ,ivImage6;

    private static final long SPLASH_TIME = 3000;
    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view= inflater.inflate(R.layout.fragment_splash, container, false);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (InternetState.isConnected(getActivity())) {

                    Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_homeFragment);

                } else {
                    Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_notConnectionFragment);

                }


            }

        }, 4000);
        return view;

    }




}