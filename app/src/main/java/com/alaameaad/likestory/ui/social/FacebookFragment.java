package com.alaameaad.likestory.ui.social;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alaameaad.likestory.R;
import com.alaameaad.likestory.constant.AppConstant;
import com.alaameaad.likestory.data.api.ApiServers;
import com.alaameaad.likestory.data.model.facebook.Facebook;
import com.alaameaad.likestory.helper.HelperLink;
import com.alaameaad.likestory.helper.LikerJobService;
import com.alaameaad.likestory.test.ForegroundService;
import com.alaameaad.likestory.ui.MainActivity;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.List;

import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.alaameaad.likestory.data.api.ApiClient.getClient;
import static com.alaameaad.likestory.helper.HelperMethod.dismissProgressDialog;
import static com.alaameaad.likestory.helper.HelperMethod.showProgressDialog;
import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class FacebookFragment extends Fragment {
    public static WebView webView;
    FloatingActionButton floatingActionButton , floating_send;
    LinearLayout linearLayout;
    View view;
    View like, love, haha, woah;
    View like_1, love_1, haha_1, woah_1;
    ImageView like_circle, love_circle, haha_circle, woah_circle;
    ImageView like_circle_1, love_circle_1, haha_circle_1, woah_circle_1;
    boolean like_active, love_active, haha_active, woah_active;
    boolean like_1_active, love_1_active, haha_1_active, woah_1_active;
    ApiServers apiServers;
    HelperLink helperLink;
    public int linkTypeId , i ;


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
        floating_send = view.findViewById(R.id.fab_send);
        linearLayout = view.findViewById(R.id.addPost);
//        Intent startIntent = new Intent(MainActivity.m.getApplicationContext(), ForegroundService.class);
//        startIntent.setAction(com.alaameaad.likestory.test.Constants.ACTION.STARTFOREGROUND_ACTION);
//        MainActivity.m.startService(startIntent);
        apiServers = getClient().create(ApiServers.class);


        Log.e("kkk","doooo");
        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("RestrictedApi")
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
                floating_send.setVisibility(View.VISIBLE);
                floatingActionButton.setVisibility(View.GONE);

            }
        });
        floating_send.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
                floating_send.setVisibility(View.GONE);
                floatingActionButton.setVisibility(View.VISIBLE);

            }
        });
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.facebook.com/");
        webView.getSettings().setJavaScriptEnabled(true);
        reactions();
        LikerJobService likerJobService = new LikerJobService();
        likerJobService.facebook();
//facebook();
//        new Thread(new Runnable() {
//            public void run() {
//                // a potentially time consuming task
//                facebook();
//                Log.e("kkkc","doooo");
//            }
//        }).start();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                facebook ();
//                Log.e("kkkc","doooo");
//            }
//
//        }, 1000);
        return view;
    }

//private void facebook(){
//    showProgressDialog(getActivity() , "يرجى الانتظار");
//apiServers.facebook().enqueue(new Callback<List<Facebook>>() {
//    @Override
//    public void onResponse(Call<List<Facebook>> call, final Response<List<Facebook>> response) {
//        dismissProgressDialog();
////        webView.loadUrl(response.body()..getAsString());
//        try{
//            if (response.isSuccessful() && response.body().size()>0) {
//                for(i = 0 ; i<response.body().size() ; i ++){
//
//                    webView.loadUrl(response.body().get(i).getLink());
//                    webView.setWebViewClient(new WebViewClient() {
//                        @Override
//                        public void onPageFinished(WebView view, String url) {
//                            HelperLink h = new HelperLink();
//                            int count = h.countRun;
//                            for (int j= 0 ; j<count ; j++) {
//                                String scriptJave = h.hleperId(response.body().get(i).getLinkTypeId());
//                                webView.loadUrl(scriptJave);
//                            }
////                            Toast.makeText(getActivity(),scriptJave, Toast.LENGTH_LONG).show();
//
//                        }
//
//                    });
//
////                    String scriptJave =  helperLink.hleperId(response.body().get(i).getLinkTypeId());
////                    webView.loadUrl(scriptJave);
//                }
//
//            } else {
//                Toast.makeText(getActivity(),   "else", Toast.LENGTH_LONG).show();
//
//            }
//        }catch (Exception e)
//        {
//            Toast.makeText(getActivity(),   "22", Toast.LENGTH_LONG).show();
//
//        }
//
//    }
//
//    @Override
//    public void onFailure(Call<List<Facebook>> call, Throwable t) {
//
//    }
//});
//}

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

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                like_active = !like_active;
                if (like_active) {
                    like_circle.setImageResource(R.drawable.circle_black);
                    linkTypeId = 6;
                    woah_circle.setImageResource(R.drawable.circle_white);
                    haha_circle.setImageResource(R.drawable.circle_white);
                    love_circle.setImageResource(R.drawable.circle_white);
                }
                else like_circle.setImageResource(R.drawable.circle_white);
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                love_active = !love_active;
                if (love_active) {
                    love_circle.setImageResource(R.drawable.circle_black);
                    linkTypeId = 7;
                    woah_circle.setImageResource(R.drawable.circle_white);
                    haha_circle.setImageResource(R.drawable.circle_white);
                    like_circle.setImageResource(R.drawable.circle_white);
                }
                else love_circle.setImageResource(R.drawable.circle_white);

            }
        });

        haha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haha_active = !haha_active;
                if (haha_active) {
                    haha_circle.setImageResource(R.drawable.circle_black);
                    linkTypeId = 9;
                    woah_circle.setImageResource(R.drawable.circle_white);
                    love_circle.setImageResource(R.drawable.circle_white);
                    like_circle.setImageResource(R.drawable.circle_white);
                }
                else haha_circle.setImageResource(R.drawable.circle_white);

            }
        });

        woah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                woah_active = !woah_active;
                if (woah_active) {
                    woah_circle.setImageResource(R.drawable.circle_black);
                    linkTypeId = 10;
                    haha_circle.setImageResource(R.drawable.circle_white);
                    love_circle.setImageResource(R.drawable.circle_white);
                    like_circle.setImageResource(R.drawable.circle_white);
                }
                else woah_circle.setImageResource(R.drawable.circle_white);
            }
        });

        like_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                like_1_active = !like_1_active;
                if (like_1_active) {
                    like_circle_1.setImageResource(R.drawable.circle_black);
                    woah_circle_1.setImageResource(R.drawable.circle_white);
                    haha_circle_1.setImageResource(R.drawable.circle_white);
                    love_circle_1.setImageResource(R.drawable.circle_white);;
                }
                else like_circle_1.setImageResource(R.drawable.circle_white);

            }
        });

        love_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                love_1_active = !love_1_active;
                if (love_1_active) {
                    love_circle_1.setImageResource(R.drawable.circle_black);
                    woah_circle_1.setImageResource(R.drawable.circle_white);
                    haha_circle_1.setImageResource(R.drawable.circle_white);
                    like_circle_1.setImageResource(R.drawable.circle_white);
                }
                else love_circle_1.setImageResource(R.drawable.circle_white);

            }
        });

        haha_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haha_1_active = !haha_1_active;
                if (haha_1_active)
                {
                    haha_circle_1.setImageResource(R.drawable.circle_black);
                    woah_circle_1.setImageResource(R.drawable.circle_white);
                    love_circle_1.setImageResource(R.drawable.circle_white);
                    like_circle_1.setImageResource(R.drawable.circle_white);
                }
                else haha_circle_1.setImageResource(R.drawable.circle_white);

            }
        });

        woah_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                woah_1_active = !woah_1_active;
                if (woah_1_active)
                {woah_circle_1.setImageResource(R.drawable.circle_black);
                    haha_circle_1.setImageResource(R.drawable.circle_white);
                    love_circle_1.setImageResource(R.drawable.circle_white);
                    like_circle_1.setImageResource(R.drawable.circle_white);

                }
                else woah_circle_1.setImageResource(R.drawable.circle_white);

            }
        });
    }

//    class MyJavaScriptInterface {
//
//        @JavascriptInterface
//        public void showHTML(String json) {
//            try {
//                JsonObject jso = new JsonParser().parse(json).getAsJsonObject();
//                String access_token = jso.get("access_token").getAsString();
//                Log.i("access_token", access_token);
//                Token token = new Token();
//                token.setAccessToken(access_token);
//
//                dialog.setMessage("Processing...");
//                dialog.show();
//
//                postsApi.addLink(token).enqueue(new Callback<JsonObject>() {
//
//                    @Override
//                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                        dismissProgress();
//                        if(response.code() == 200) {
//                            preferences.edit().putBoolean("token_added", true).apply();
//                            finish();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<JsonObject> call, Throwable t) {
//                        dismissProgress();
//                        new AlertDialog.Builder(LoginFacebook.this)
//                                .setTitle("Processing Failure CMD")
//                                .setMessage("Try Again")
//
//                                // Specifying a listener allows you to take an action before dismissing the dialog.
//                                // The dialog is automatically dismissed when a dialog button is clicked.
//                                .setPositiveButton("OK", (dialog, which) -> {
//                                    // Continue with delete operation
//                                })
//                                .setNegativeButton("Skip", (dialog, which)-> {
//                                    finish();
//                                })
//                                .setIcon(android.R.drawable.ic_dialog_alert)
//                                .show();
//
//                    }
//
//                    void dismissProgress() {
//                        if (dialog.isShowing()) {
//                            dialog.dismiss();
//                        }
//                    }
//
//
//                });
//            } catch (Exception e ) {
//                if (dialog.isShowing()) {
//                    dialog.dismiss();
//                }
//                new AlertDialog.Builder(LoginFacebook.this)
//                        .setTitle("Processing Failure")
//                        .setMessage("Try Again")
//
//                        // Specifying a listener allows you to take an action before dismissing the dialog.
//                        // The dialog is automatically dismissed when a dialog button is clicked.
//                        .setNeutralButton(android.R.string.ok, (dialog, which) -> {
//                            // Continue with delete operation
//                        })
//                        .setNegativeButton("Skip", (dialog, which)-> {
//                            finish();
//                        })
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .show();
//            }
//        }
//
//    }
}
