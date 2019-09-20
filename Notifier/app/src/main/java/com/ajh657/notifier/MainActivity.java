package com.ajh657.notifier;

import android.app.NotificationManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //public SnackBarController snackBarController = new SnackBarController(findViewById(R.id.MainCoordinatorLayout));
    public CustomNotificationHandler customNotificationHandler = new CustomNotificationHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customNotificationHandler.createNotificationChannel(getString(R.string.notificationChannel_1_ID),getString(R.string.notificationChannel_1_description), NotificationManager.IMPORTANCE_DEFAULT, getString(R.string.notificationChannel_1_ID));
        customNotificationHandler.createNotificationChannel(getString(R.string.notificationChannel_2_ID),getString(R.string.notificationChannel_2_description), NotificationManager.IMPORTANCE_MAX, getString(R.string.notificationChannel_2_ID));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.testNotification){
            Log.d("OptionsItemLog",Integer.toString(id) +" ?= " + R.id.testNotification);
            customNotificationHandler.sendSmallNotification(getString(R.string.notificationTest_Title), getString(R.string.notificationTest_Text), getString(R.string.notificationChannel_1_ID), 404);
            return true;
        }

        if (id == R.id.testTCP){
            Log.d("OptionsItemLog",Integer.toString(id) +" ?= " + R.id.testTCP);
            TCPController tcp = new TCPController("notifier.ajh657.net",7070, this);
            Log.d("Connection Test", Integer.toString(tcp.testConn()));
            /*switch (tcp.testConn()){
                case 200:
                    snackBarController.Show("Test was successful");
                    break;

                case 400:
                    snackBarController.Show("Connection Error");
                    break;

                case 500:
                    snackBarController.Show("Reader Error");
            }*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
