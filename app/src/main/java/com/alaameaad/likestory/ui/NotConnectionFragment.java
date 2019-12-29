package com.alaameaad.likestory.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaameaad.likestory.R;

import androidx.fragment.app.Fragment;

public class NotConnectionFragment extends Fragment {
    public NotConnectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_not_connection, container, false);
        return view;
    }
}
