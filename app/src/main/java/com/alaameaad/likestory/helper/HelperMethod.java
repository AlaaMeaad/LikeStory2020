package com.alaameaad.likestory.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.service.autofill.UserData;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.io.File;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.alaameaad.likestory.data.shared.MySharedPreferences.setSharedPreferences;


public class HelperMethod {

    private static ProgressDialog checkDialog;
    public static AlertDialog alertDialog;
    public static Snackbar snackbar;
    private static SharedPreferences sharedPreferences = null;
    private static String USER_DATA = "USER_DATA";


    //post retfit
    public static MultipartBody.Part convertFileToMultipart(String pathImageFile, String Key) {
        if (pathImageFile != null) {
            File file = new File(pathImageFile);

            RequestBody reqFileselect = RequestBody.create(MediaType.parse("image/*"), file);

            MultipartBody.Part Imagebody = MultipartBody.Part.createFormData(Key, file.getName(), reqFileselect);

            return Imagebody;
        } else {
            return null;
        }
    }


    //RequestBody
    public static RequestBody convertToRequestBody(String part) {
        try {
            if (!part.equals("")) {
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), part);
                return requestBody;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    //img url
    public static void onLoadImageFromUrl(ImageView imageView, String URl, Context context) {
        Glide.with(context)
                .load(URl)
                .into(imageView);
    }


    //tost + action
    public static void createSnackBar(View view, String message, Context context) {
        final Snackbar snackbar = Snackbar.make(view, message, 50000);
        snackbar.setAction("dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        })
                .setActionTextColor(context.getResources().getColor(android.R.color.holo_red_light))

                .show();
    }

    public static void createSnackBar(View view, String message, Context context, View.OnClickListener action, String Title) {
        snackbar = Snackbar.make(view, message, 50000);
        snackbar.setAction(Title, action)
                .setActionTextColor(context.getResources().getColor(android.R.color.holo_red_light))
                .show();
    }



    public static void showProgressDialog(Activity activity, String title) {
        try {
            checkDialog = new ProgressDialog(activity);
            checkDialog.setMessage(title);
            checkDialog.setIndeterminate(false);
            checkDialog.setCancelable(false);
            checkDialog.show();

        } catch (Exception e) {

        }
    }


    //display dialog
    public static void dismissProgressDialog() {
        try {
            if (checkDialog != null && checkDialog.isShowing()) {
                checkDialog.dismiss();
            }
        } catch (Exception e) {

        }
    }


    //call fragment
    public static void ReplaceFragment(Fragment fragment, FragmentManager supportFragmentManager, int container_id
            , TextView toolbarTitle, String title) {

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        transaction.replace(container_id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        if (toolbarTitle != null) {
            toolbarTitle.setText(title);
        }

    }
   /* public static void getDonation(Activity activity, ApiServers apiServices, String donationRequestId, String ApiToken, boolean fromDonation) {
        showProgressDialog(activity, "برجاء الانتظار ...");
        apiServices.getDonationDetails(ApiToken, donationRequestId).enqueue(new Callback<PostsData>() {
            @Override
            public void onResponse(Call<DonationDetails> call, Response<DonationDetails> response) {
                try {
                    dismissProgressDialog();
                    if (response.body().getStatus() == 1) {

                        HomeActivity navigationActivity = (HomeActivity) activity;
                        navigationActivity.setCount();
                        navigationActivity.setTitle(activity.getString(R.string.donation) + response.body().getData().getPatientName());

                        DonationDetailsFragment donationDetails = new DonationDetailsFragment();
                        donationDetails.donationData = response.body().getData();
                        donationDetails.fromDonation = fromDonation;
                        HelperMethod.replaceFragment(navigationActivity.getSupportFragmentManager(), R.id.Content_Frame_Replace, donationDetails);
                    }
                } catch (Exception e) {

                }

            }

            @Override
            public void onFailure(Call<DonationDetails> call, Throwable t) {
                dismissProgressDialog();
            }
        });
    }*/

    // a5fy elkeypord
    public static void disappearKeypad(Activity activity, View v) {
        try {
            if (v != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        } catch (Exception e) {

        }
    }

    public static void SaveData(Activity activity, String data_Key, Object data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String StringData = gson.toJson(data_Value);
            editor.putString(data_Key, StringData);
            editor.commit();
        }
    }

    public static UserData loadUserData(Activity activity) {
        UserData userData = null;

        Gson gson = new Gson();
        userData = gson.fromJson(LoadData(activity, USER_DATA), UserData.class);

        return userData;
    }

    public static String LoadData(Activity activity, String data_Key) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
        } else {
            setSharedPreferences(activity);
        }

        return sharedPreferences.getString(data_Key, null);
    }





}
