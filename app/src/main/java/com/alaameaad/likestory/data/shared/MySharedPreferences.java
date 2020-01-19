package com.alaameaad.likestory.data.shared;

import android.app.Activity;
import android.content.SharedPreferences;

import com.alaameaad.likestory.constant.AppConstant;


public class MySharedPreferences {
    private static SharedPreferences sharedPreferences = null;
    private static SharedPreferences.Editor editor;
    private static String USER_TOKEN = "user_token";
    private static String USER_NAME = "user_name";
    private static String USER_ID = "user_id";
    private static String FIREBASE_ID = "firebase_id";
    private static String USER_TYPE = "user_type";

    public MySharedPreferences(Activity activity) {
        setSharedPreferences(activity);
    }

    public static void setSharedPreferences(Activity activity) {
        if (sharedPreferences == null) {
            sharedPreferences = activity.getSharedPreferences(
                    "\"PREF\"", activity.MODE_PRIVATE);
           editor = sharedPreferences.edit();
        }
    }

    public void setUserToken(String userToken) {
        editor.putString(USER_TOKEN, userToken).commit();
    }

    public String getUserToken(){
        return sharedPreferences.getString(USER_TOKEN, "");
    }

    public void logout() {
        editor.remove(USER_TOKEN).commit();
        editor.remove(USER_ID).commit();
        editor.remove(USER_NAME).commit();
        editor.remove(USER_TYPE).commit();
    }

    public void setUserId(String id) {
        editor.putString(USER_ID, id).commit();
    }

    public String getUserId(){
        return sharedPreferences.getString(USER_ID,"");
    }

    public void setUserName(String username) {
        editor.putString(USER_NAME, username).commit();
    }

    public String getUserName(){
        return sharedPreferences.getString(USER_NAME, AppConstant.STRING_DEFAULT_VALUE);
    }
    public String getFirebaseId(){
        return sharedPreferences.getString(AppConstant.FIREBASE_ID,AppConstant.STRING_DEFAULT_VALUE);
    }


    public void setUserType(String type) {
        editor.putString(USER_TYPE, type).commit();
    }

    public String getUserType(){
        return sharedPreferences.getString(USER_TYPE,AppConstant.STRING_DEFAULT_VALUE);
    }
}
