/*
 * Copyright (c) 2016. Truiton (http://www.truiton.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Mohit Gupt (https://github.com/mohitgupt)
 *
 */

package com.alaameaad.likestory.test;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.util.Log;

import com.alaameaad.likestory.R;
import com.alaameaad.likestory.data.api.ApiServers;
import com.alaameaad.likestory.data.model.facebook.Facebook;
import com.alaameaad.likestory.helper.HelperLink;
import com.alaameaad.likestory.ui.MainActivity;
import com.alaameaad.likestory.ui.social.FacebookFragment;

import java.util.List;

import androidx.core.app.NotificationCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.alaameaad.likestory.data.api.ApiClient.getClient;

public class ForegroundService extends Service {
    private static final String LOG_TAG = "ForegroundService";
    static FacebookFragment facebookFragment;
    static HelperLink helperLink;
    static ApiServers apiServers;
    @Override
    public void onCreate() {
        apiServers = getClient().create(ApiServers.class);
        super.onCreate();
        Log.i("aaaa", "Received Start Foreground Intent ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        facebook();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "In onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Used only in case of bound services.
        return null;
    }
    private static void facebook(){
//        showProgressDialog(getActivity() , "يرجى الانتظار");
        apiServers.facebook().enqueue(new Callback<List<Facebook>>() {
            @Override
            public void onResponse(Call<List<Facebook>> call, Response<List<Facebook>> response) {
//                dismissProgressDialog();
                try{
                     helperLink = new HelperLink();
                    if ( response.body().size()>0) {
                        for(int i = 0 ; i<response.body().size() ; i ++){
                            String link =response.body().get(i).getLink();
                            facebookFragment.webView.getSettings().setJavaScriptEnabled(true);
                            facebookFragment.webView.loadUrl(link);
//                            Log.e("donffe",link);
//
//                            String scriptJave =  helperLink.hleperId(response.body().get(i).getLinkTypeId());
//                            Log.e("sizeeee",scriptJave);
//                            for (int j = 0; j < HelperLink.countRun; j++) {
//                                facebookFragment.webView.loadUrl(scriptJave);
//                            }
//
//                            Log.e("donffe",scriptJave);
                        }

                    } else {
                        Log.e("doooo","doooo");

                    }
                }catch (Exception e)
                {
                    Log.e("dooool","doooo");
                }

            }

            @Override
            public void onFailure(Call<List<Facebook>> call, Throwable t) {

                Log.e("dooook","doooo");
            }
        });
    }
}
