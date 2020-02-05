package com.alaameaad.likestory.helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.format.DateUtils;
import android.webkit.MimeTypeMap;

import com.alaameaad.likestory.BuildConfig;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import androidx.core.content.FileProvider;

/**
 * Created by Kosh on 8/17/2015. copyrights are reserved
 */
public class AppHelper {

     static  final String USER_AGENT = System.getProperty("http.agent");
    public static String zFile = "Json.zip";
    public static String jFile = "json.json";
    public static String zFileName = "Json";
    public static String zFileExtension = ".zip";

    public static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }


    public static List<String> getAppPermissions(Context context, String packageName) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
            return Arrays.asList(info.requestedPermissions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void installApk(Context context, File filename) {
        Intent install = new Intent(Intent.ACTION_INSTALL_PACKAGE);
        install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            install.setData(Uri.fromFile(filename));
        } else {
            Uri apkURI = FileProvider.getUriForFile(context,context.getApplicationContext()
                            .getPackageName() + ".provider", filename);

            List<ResolveInfo> resInfoList = context.getPackageManager().queryIntentActivities(install, PackageManager.MATCH_DEFAULT_ONLY);
            for (ResolveInfo resolveInfo : resInfoList) {
                String packageName = resolveInfo.activityInfo.packageName;
                context.grantUriPermission(packageName, apkURI, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }

            install.setDataAndType(apkURI, "application/vnd.android.package-archive");
            install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }

        context.startActivity(install);

    }


    public static boolean isRootEnabled(Context context) {
        SharedPreferences preferenceScreen = PreferenceManager.getDefaultSharedPreferences(context);
        return preferenceScreen.getBoolean("isRootEnabled", false);
    }

    public static void setRootEnabled(Context context, boolean isRoot) {
        SharedPreferences preferenceScreen = PreferenceManager.getDefaultSharedPreferences(context);
        preferenceScreen.edit().putBoolean("isRootEnabled", isRoot).apply();
    }



    public static long getFolderSize(File f) {
        long size = 0;
        if (f.isDirectory()) {
            for (File file : f.listFiles()) {
                size += getFolderSize(file);
            }
        } else {
            size = f.length();
        }
        return size;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static boolean isDarkTheme(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("dark_theme", false);
    }




    public static String prettifyDate(long timestamp) {
        SimpleDateFormat dateFormat;
        if (DateUtils.isToday(timestamp)) {
            dateFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        } else {
            dateFormat = new SimpleDateFormat("dd MMM hh:mm a", Locale.getDefault());
        }
        return dateFormat.format(timestamp);
    }

    public static boolean isBackupData(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("backup_data", false);
    }

    public static boolean isRestoreData(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("restore_data", false);
    }

    public static String extension(String file) {
        return MimeTypeMap.getFileExtensionFromUrl(file);
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if ( Environment.MEDIA_MOUNTED.equals( state ) ) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if ( Environment.MEDIA_MOUNTED.equals( state ) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals( state ) ) {
            return true;
        }
        return false;
    }


    public static void setHasSeenWhatsNew(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("version_code", BuildConfig.VERSION_CODE).apply();
    }

    public static boolean hasSeenWhatsNew(Context context) {
        return false; //PreferenceManager.getDefaultSharedPreferences(context).getInt("version_code", 0) == BuildConfig.VERSION_CODE;
    }

    public static boolean isSDCardPresent() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static boolean hasWhatsNew(Context context) {

        return false;
    }
}
