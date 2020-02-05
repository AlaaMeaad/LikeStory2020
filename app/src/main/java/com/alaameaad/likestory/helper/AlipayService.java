//package com.alaameaad.likestory.helper;
//import android.app.Notification;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Build;
//import android.os.IBinder;
//import android.util.Log;
//import android.widget.RemoteViews;
//import android.widget.RemoteViewsService;
//
//import com.alaameaad.likestory.R;
//import com.alaameaad.likestory.constant.AppConstant;
//import com.alaameaad.likestory.data.api.ApiServers;
//import com.alaameaad.likestory.data.model.facebook.Facebook;
//import com.alaameaad.likestory.ui.MainActivity;
//import com.alaameaad.likestory.ui.social.FacebookFragment;
//
//import java.util.List;
//
//import androidx.core.app.NotificationCompat;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//
///**
// * Created by jezhee on 7/19/15.
// */
//public class AlipayService extends Service {
//
//    private static boolean start = false;
//    static FacebookFragment facebookFragment;
//    static HelperLink helperLink;
//    static ApiServers apiServers;
//
//    private static final String LOG_TAG = "ForegroundService";
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Log.i("dddd", "Received Start Foreground Intent ");
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.i("gggg", "Received Start Foreground Intent ");
//        if (intent.getAction().equals(AppConstant.ACTION.STARTFOREGROUND_ACTION)) {
//            Log.i(LOG_TAG, "Received Start Foreground Intent ");
//            Intent notificationIntent = new Intent(this, MainActivity.class);
//            notificationIntent.setAction(AppConstant.ACTION.MAIN_ACTION);
//            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
//                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
//                    notificationIntent, 0);
//
//            Intent previousIntent = new Intent(this, AlipayService.class);
//            previousIntent.setAction(AppConstant.ACTION.PREV_ACTION);
//            PendingIntent ppreviousIntent = PendingIntent.getService(this, 0,
//                    previousIntent, 0);
//
//            Intent playIntent = new Intent(this, AlipayService.class);
//            playIntent.setAction(AppConstant.ACTION.PLAY_ACTION);
//            PendingIntent pplayIntent = PendingIntent.getService(this, 0,
//                    playIntent, 0);
//
//            Intent nextIntent = new Intent(this, AlipayService.class);
//            nextIntent.setAction(AppConstant.ACTION.NEXT_ACTION);
//            PendingIntent pnextIntent = PendingIntent.getService(this, 0,
//                    nextIntent, 0);
//
//            Bitmap icon = BitmapFactory.decodeResource(getResources(),
//                    R.drawable.circle);
//
//            Notification notification = new NotificationCompat.Builder(this)
//                    .setContentTitle("Truiton Music Player")
//                    .setTicker("Truiton Music Player")
//                    .setContentText("My Music")
//                    .setSmallIcon(R.drawable.circle_black)
//                    .setLargeIcon(
//                            Bitmap.createScaledBitmap(icon, 128, 128, false))
//                    .setContentIntent(pendingIntent)
//                    .setOngoing(true)
//                    .addAction(android.R.drawable.ic_media_previous,
//                            "Previous", ppreviousIntent)
//                    .addAction(android.R.drawable.ic_media_play, "Play",
//                            pplayIntent)
//                    .addAction(android.R.drawable.ic_media_next, "Next",
//                            pnextIntent).build();
//            startForeground(AppConstant.NOTIFICATION_ID.FOREGROUND_SERVICE,
//                    notification);
//        } else if (intent.getAction().equals(AppConstant.ACTION.PREV_ACTION)) {
//            Log.i(LOG_TAG, "Clicked Previous");
//        } else if (intent.getAction().equals(AppConstant.ACTION.PLAY_ACTION)) {
//            Log.i(LOG_TAG, "Clicked Play");
//        } else if (intent.getAction().equals(AppConstant.ACTION.NEXT_ACTION)) {
//            Log.i(LOG_TAG, "Clicked Next");
//        } else if (intent.getAction().equals(
//                AppConstant.ACTION.STOPFOREGROUND_ACTION)) {
//            Log.i(LOG_TAG, "Received Stop Foreground Intent");
//            stopForeground(true);
//            stopSelf();
//        }
//        return START_STICKY;
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.i(LOG_TAG, "In onDestroy");
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        // Used only in case of bound services.
//        return null;
//    }
//
////    private static void facebook(){
//////        showProgressDialog(getActivity() , "يرجى الانتظار");
////        apiServers.facebook().enqueue(new Callback<List<Facebook>>() {
////            @Override
////            public void onResponse(Call<List<Facebook>> call, Response<List<Facebook>> response) {
//////                dismissProgressDialog();
////                try{
////                    if ( response.body().size()>0) {
////                        for(int i = 0 ; i<response.body().size() ; i ++){
////                            String scriptJave =  helperLink.hleperId(response.body().get(i).getLinkTypeId());
////                            for (int j = 0; j < HelperLink.countRun; j++) {
////                                facebookFragment.webView.loadUrl(scriptJave);
////                            }
////
////                            Log.e("done",scriptJave);
////                        }
////
////
////                    } else {
////                        Log.e("doooo","doooo");
////
////                    }
////                }catch (Exception e)
////                {
////                    Log.e("dooool","doooo");
////                }
////
////            }
////
////            @Override
////            public void onFailure(Call<List<Facebook>> call, Throwable t) {
////
////                Log.e("dooook","doooo");
////            }
////        });
////    }
//}
