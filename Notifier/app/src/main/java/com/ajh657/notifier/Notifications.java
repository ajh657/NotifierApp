package com.ajh657.notifier;

import android.content.Context;

import androidx.core.app.NotificationCompat;

public class Notifications {

    private String ChannelID;
    private NotificationCompat.Builder NBuilder;

    public void sendNotification(Context context){
        NBuilder = new NotificationCompat.Builder(context, ChannelID);
    }
}
