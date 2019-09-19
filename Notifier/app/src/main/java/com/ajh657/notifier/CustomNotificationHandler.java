package com.ajh657.notifier;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class CustomNotificationHandler {

    private Context context;

    public CustomNotificationHandler(Context current){
        this.context = current;
    }

    public void createNotificationChannel(CharSequence name, String description, int importance, String CHANNEL_ID) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            Log.d("NotificationChannelCreator", "Created: " + CHANNEL_ID);
        }
    }

    public void sendSmallNoitification(String title, String text, String Channel_ID){
        NotificationCompat.Builder smallBuilder = new NotificationCompat.Builder(context, Channel_ID);
        smallBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
        smallBuilder.setContentTitle(title);
        smallBuilder.setContentText(text);
        smallBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }
}
