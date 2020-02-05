package com.alaameaad.likestory.helper;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.alaameaad.likestory.data.api.ApiClient;
import com.alaameaad.likestory.data.api.ApiServers;
import com.alaameaad.likestory.data.model.facebook.Facebook;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class LikerJobService extends JobService {

    ApiServers postsApi;
    ArrayList<Facebook> posts;
    int counter = 1;
    int i;
    private JsonObject jsonData;
    private File jFile;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        try {
            posts = new ArrayList<>();
            jFile = new File(getApplicationContext().getCacheDir()+ "/" + AppHelper.jFile);


            postsApi = ApiClient.getClient().create(ApiServers.class);
            facebook();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public void facebook(){
        postsApi.facebook().enqueue(new Callback<List<Facebook>>() {
            @Override
            public void onResponse(Call<List<Facebook>> call, final Response<List<Facebook>> response) {
//        webView.loadUrl(response.body()..getAsString());
                try{
                    if (response.isSuccessful() && response.body().size()>0) {

                        for( i = 0 ; i<response.body().size() ; i ++){
                            final WebView web = new WebView(getApplicationContext());
                            web.getSettings().setJavaScriptEnabled(true);
                            web.loadUrl(response.body().get(i).getLink());
                            web.setWebViewClient(new WebViewClient() {
                                @Override
                                public void onPageFinished(WebView view, String url) {
                                    HelperLink h = new HelperLink();
                                    int count = h.countRun;
                                    for (int j= 0 ; j<count ; j++) {
                                        String scriptJave = h.hleperId(response.body().get(i).getLinkTypeId());
                                        web.loadUrl(scriptJave);
                                    }
//                            Toast.makeText(getActivity(),scriptJave, Toast.LENGTH_LONG).show();

                                }

                            });

//                    String scriptJave =  helperLink.hleperId(response.body().get(i).getLinkTypeId());
//                    webView.loadUrl(scriptJave);
                        }

                    } else {

                    }
                }catch (Exception e)
                {

                }

            }

            @Override
            public void onFailure(Call<List<Facebook>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.i("JOOOOOB", "onStopJob");
        return false;
    }


//    class LikePost extends Thread {
//        ArrayList<Facebook> posts;
//        JobParameters jobParameters;
//
//        LikePost(ArrayList<Facebook> posts, JobParameters jobParameters) {
//            this.posts = posts;
//            this.jobParameters = jobParameters;
//        }
//
//        @Override
//        public void run() {
//                Log.i("JOOOOOB", "Likeee");
//                try {
//                    int i = 0;
//                    for (final Facebook post : posts) {
//                        new Handler(Looper.getMainLooper()).post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    try {
//                                        final WebView web = new WebView(getApplicationContext());
//                                        web.getSettings().setJavaScriptEnabled(true);
//                                        String url;
//                                        if (post.getLink().contains("m.facebook")) {
//                                            url = post.getLink().replace("m.facebook","mbasic.facebook");
//                                        } else {
//                                            url = post.getLink();
//                                        }
//                                        Log.d("linklink-click", url);
//                                        web.loadUrl(url);
//                                        web.setWebViewClient(new WebViewClient() {
//                                            @Override
//                                            public void onPageFinished(WebView view, final String url) {
//                                                super.onPageFinished(view, url);
//                                                // Like
//                                                if (!url.equals("about:blank")) {
//                                                    Log.i("JOOOOOB:link-click", url);
//                                                    switch (post.getType()){
//                                                        case 0:
//                                                            Log.d("JOOOOOB:link-click", acts.getLikePost());
//
//                                                            view.loadUrl(acts.getLikePost());
//                                                            break;
//                                                        case 1:
//                                                            Log.d("JOOOOOB:link-click", acts.getFollowAccount());
//
//                                                            view.loadUrl(acts.getFollowAccount());
//                                                            break;
//                                                        case 2:
//                                                            Log.d("JOOOOOB:link-click", acts.getLikePage());
//
//                                                            view.loadUrl(acts.getLikePage());
//                                                            break;
//                                                    }
//
//                                                    counter++;
//
//                                                    LikedLink likedLink = new LikedLink();
//                                                    likedLink.setLink(url);
//                                                    likedLink.setUserId(AppUtils.getCookie("https://m.facebook.com", "c_user"));
//                                                    Call<JsonObject> call = postsApi.likedLink(likedLink);
//                                                    call.enqueue(new Callback<JsonObject>() {
//                                                        @Override
//                                                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                                                            Log.d("JOOOOOB:Count Likes: " , (response.body() != null ? response.body().get("message") : null) + " " + url );
//                                                        }
//
//                                                        @Override
//                                                        public void onFailure(Call<JsonObject> call, Throwable t) {
//                                                            Log.d("JOOOOOB:Count Likes Err" , t.getMessage() + " : " + url);
//                                                        }
//                                                    });
//
//                                                }
//                                            }
//                                        });
//                                    } catch (Exception ex) {
//                                        Log.d("ex", ex.getMessage());
//                                    }
//                                }
//                            });
//
//                        i ++;
//                        try {
//                            Thread.sleep((i % 2 != 0 ? 1 : 2) * 3000);
//                        } catch (InterruptedException ex) {
//                            Log.d("Error", ex.getMessage());
//                        }
//                    }
//
//                    Log.i("JOOOOOB", "FINiiiiiiSH");
//                    jobFinished(jobParameters, false);
//                } catch (Exception e) {
//                    Log.i("JOOOOOB", "Error :(");
//                }
//        }
//    }
}