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
public class FacebookFragment extends Fragment {
    private WebView webView;
    View view;

    public FacebookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_facebook, container, false);
        webView = view.findViewById(R.id.wv_face);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.facebook.com/");

        return view;
    }

}
