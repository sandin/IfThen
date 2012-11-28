package com.lds.ifthen.action.impl;

import android.content.Context;
import android.widget.Toast;

import com.lds.ifthen.action.Action;
import com.lds.ifthen.trigger.Trigger;

public class SimpleToastAction implements Action {
    private String message;
    
    public SimpleToastAction(String message) {
        this.message = message;
    }

    @Override
    public void onAction(Context context, Trigger trigger) {
        Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

}
