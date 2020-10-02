package com.alaameaad.likestory.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.alaameaad.likestory.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoToWebFragment extends Fragment {

    private WebView webView;
    View view;
    public GoToWebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view= inflater.inflate(R.layout.fragment_gotoweb, container, false);

        webView= view.findViewById(R.id.wv_youtube);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.google.com/search?client=firefox-b-d&sxsrf=ACYBGNRT6KBivb9X" +
                "_NG1U1sZ55TCkctVmQ%3A1581871734560&ei=dnJJXr7vIYzAa-22g5gE&q=%D9%84%D8%A7%D9%8A%D9%83" +
                "+%D8%B3%D8%AA%D9%88%D8%B1%D9%8A+-+Like+Story&oq=%D9%84%D8%A7%D9%8A%D9%83+%D8%B3%" +
                "D8%AA%D9%88%D8%B1%D9%8A+-+Like+Story&gs_l=psy-ab.3...1524.1524..2325...0.3..0.131." +
                "131.0j1......0....2j1..gws-wiz.......0i71.RLdyPWScnY8&ved=0ahUKEwi-gsa2w9bnAhUM4BoKHW" +
                "3bAEMQ4dUDCAo&uact=5");

        return view;
    }

}
