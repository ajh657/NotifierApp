package com.ajh657.notifier;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarController {

    private View currentContextView;

    public SnackBarController(View contextView){
        this.currentContextView = contextView;
    }

    public void Show(String message){
        Snackbar.make(currentContextView, message, Snackbar.LENGTH_SHORT).show();
    }

}
