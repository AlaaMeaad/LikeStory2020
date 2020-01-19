package com.alaameaad.likestory.ui;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alaameaad.likestory.R;
import com.alaameaad.likestory.data.api.ApiServers;
import com.alaameaad.likestory.data.model.facebook.Facebook;
import com.alaameaad.likestory.helper.HelperLink;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.alaameaad.likestory.helper.HelperMethod.dismissProgressDialog;
import static com.alaameaad.likestory.helper.HelperMethod.showProgressDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private LinearLayout linearLayout1 , linearLayout2 ,linearLayout3 , linearLayout4 ;
    View view;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        linearLayout1 = view.findViewById(R.id.line1);
        linearLayout2 = view.findViewById(R.id.line2);
        linearLayout3 = view.findViewById(R.id.line3);
        linearLayout4 = view.findViewById(R.id.line4);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_facebookFragment);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_twitterFragment);

            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_instagramFragment);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_youtubeFragment);
            }
        });


        return  view;
    }





}
