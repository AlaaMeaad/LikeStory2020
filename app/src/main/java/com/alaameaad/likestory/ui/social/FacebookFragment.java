package com.alaameaad.likestory.ui.social;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alaameaad.likestory.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FacebookFragment extends Fragment {
    private WebView webView;
    FloatingActionButton floatingActionButton;
    LinearLayout linearLayout;
    View view;
    View like, love, haha, woah;
    View like_1, love_1, haha_1, woah_1;
    ImageView like_circle, love_circle, haha_circle, woah_circle;
    ImageView like_circle_1, love_circle_1, haha_circle_1, woah_circle_1;
    boolean like_active, love_active, haha_active, woah_active;
    boolean like_1_active, love_1_active, haha_1_active, woah_1_active;
    public FacebookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_facebook, container, false);
        webView = view.findViewById(R.id.wv_face);
        floatingActionButton = view.findViewById(R.id.fab);
        linearLayout = view.findViewById(R.id.addPost);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.facebook.com/");
        reactions();
        return view;
    }

    void reactions() {
        like = view.findViewById(R.id.like);
        love = view.findViewById(R.id.love);
        haha = view.findViewById(R.id.haha);
        woah = view.findViewById(R.id.woah);


        like_1 = view.findViewById(R.id.like_1);
        love_1 = view.findViewById(R.id.love_1);
        haha_1 = view.findViewById(R.id.haha_1);
        woah_1 = view.findViewById(R.id.woah_1);

        like_circle = view.findViewById(R.id.like_circle);
        love_circle = view.findViewById(R.id.love_circle);
        haha_circle = view.findViewById(R.id.haha_circle);
        woah_circle = view.findViewById(R.id.woah_circle);

        like_circle_1 = view.findViewById(R.id.like_circle_1);
        love_circle_1 = view.findViewById(R.id.love_circle_1);
        haha_circle_1 = view.findViewById(R.id.haha_circle_1);
        woah_circle_1 = view.findViewById(R.id.woah_circle_1);

//        like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                like_active = !like_active;
//                if (like_active) like_circle.setImageResource(R.drawable.circle_black);
//                else like_circle.setImageResource(R.drawable.circle_white);
//            }
//        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                love_active = !love_active;
                if (love_active) love_circle.setImageResource(R.drawable.circle_black);
                else love_circle.setImageResource(R.drawable.circle_white);

            }
        });

        haha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haha_active = !haha_active;
                if (haha_active) haha_circle.setImageResource(R.drawable.circle_black);
                else haha_circle.setImageResource(R.drawable.circle_white);

            }
        });

        woah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                woah_active = !woah_active;
                if (woah_active) woah_circle.setImageResource(R.drawable.circle_black);
                else woah_circle.setImageResource(R.drawable.circle_white);
            }
        });

        like_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                like_1_active = !like_1_active;
                if (like_1_active) like_circle_1.setImageResource(R.drawable.circle_black);
                else like_circle_1.setImageResource(R.drawable.circle_white);

            }
        });

        love_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                love_1_active = !love_1_active;
                if (love_1_active) love_circle_1.setImageResource(R.drawable.circle_black);
                else love_circle_1.setImageResource(R.drawable.circle_white);

            }
        });

        haha_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haha_1_active = !haha_1_active;
                if (haha_1_active)haha_circle_1.setImageResource(R.drawable.circle_black);
                else haha_circle_1.setImageResource(R.drawable.circle_white);

            }
        });

        woah_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                woah_1_active = !woah_1_active;
                if (woah_1_active) woah_circle_1.setImageResource(R.drawable.circle_black);
                else woah_circle_1.setImageResource(R.drawable.circle_white);

            }
        });
    }
}
