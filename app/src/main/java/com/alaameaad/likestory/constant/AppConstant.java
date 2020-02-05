package com.alaameaad.likestory.constant;

public class AppConstant {

    public static final String SUCCESS_STATUS = "1";
    public static final String ERROR_STATUS = "0";
    public static final String STRING_DEFAULT_VALUE = "null";
    public static final String FIREBASE_ID = "firebase_id";
    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";
    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";
    // id to handle the notification in the notification tray
//    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;
    public static final String DEFAULT_IMG = "default_img.png";
    public static final String AGENT = "AGENT";
    public static final String USER = "USER";

    public interface ACTION {
        public static String MAIN_ACTION = "com.truiton.foregroundservice.action.main";
        public static String PREV_ACTION = "com.truiton.foregroundservice.action.prev";
        public static String PLAY_ACTION = "com.truiton.foregroundservice.action.play";
        public static String NEXT_ACTION = "com.truiton.foregroundservice.action.next";
        public static String STARTFOREGROUND_ACTION = "com.truiton.foregroundservice.action.startforeground";
        public static String STOPFOREGROUND_ACTION = "com.truiton.foregroundservice.action.stopforeground";
    }

    public interface NOTIFICATION_ID {
        public static int FOREGROUND_SERVICE = 101;
    }
}
