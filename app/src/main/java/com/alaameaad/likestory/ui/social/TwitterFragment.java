package com.alaameaad.likestory.ui.social;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alaameaad.likestory.R;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwitterFragment extends Fragment {
    private WebView webView;
    View view;

    public TwitterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_twitter, container, false);
        webView= view.findViewById(R.id.wv_twitter);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://twitter.com/login");

        return view;
    }

}
