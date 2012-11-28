package com.lds.ifthen.action;

import android.content.Context;

import com.lds.ifthen.trigger.Trigger;

public interface Action {
    
    void onAction(Context context, Trigger trigger);

}
