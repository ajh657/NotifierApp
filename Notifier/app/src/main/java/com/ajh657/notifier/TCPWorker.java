package com.ajh657.notifier;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class TCPWorker extends Worker {

    public TCPWorker(@NonNull Context context, @NonNull WorkerParameters params){
        super(context,params);
    }

    @Override
    public Result doWork() {

        TCPController tcp = new TCPController("notifier.ajh657.net",7070, getApplicationContext());

        if (tcp.testConn() != 200){
            return Result.failure();
        }

        return Result.success();
    }
}
