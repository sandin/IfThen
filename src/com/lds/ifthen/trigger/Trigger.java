package com.lds.ifthen.trigger;

import android.content.Context;

import com.lds.ifthen.action.Action;

public interface Trigger {

    void addOnActionListener(Context context, Action action);
    
    void removeOnActionListener(Context context, Action action);

}
