package com.lds.ifthen.trigger.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.lds.ifthen.action.Action;
import com.lds.ifthen.trigger.Trigger;

public class TimeTrigger implements Trigger {
    private long triggerAtTime;
    private Map<Action, BroadcastReceiver> mReceivers = new HashMap<Action, BroadcastReceiver>();
    private List<Action> mActions = new ArrayList<Action>();
    
    public TimeTrigger(long triggerAtTime) {
        this.triggerAtTime = triggerAtTime;
    }

    @Override
    public void addOnActionListener(Context context, final Action action) {
        Intent intent = new Intent("alert");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        final AlarmManager alarm = ( AlarmManager) context.getSystemService(Context.ALARM_SERVICE );
//        alarm.cancel(pending);
        alarm.set(AlarmManager.RTC_WAKEUP, triggerAtTime, pendingIntent);
        
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                System.out.println("onReceive");
                action.onAction(context, TimeTrigger.this);
            }
        };
        IntentFilter filter = new IntentFilter("alert");
        context.registerReceiver(receiver, filter);
        
        mReceivers.put(action, receiver);
        mActions.add(action);
    }
    
   

    @Override
    public void removeOnActionListener(Context context, Action action) {
        context.unregisterReceiver(mReceivers.get(action));
        mReceivers.remove(action);
        mActions.remove(action);
    }
    
    public void destory(Context context) {
        Iterator<Action> it = mReceivers.keySet().iterator();
        while (it.hasNext()) {
            Action act = it.next();
            BroadcastReceiver receiver = mReceivers.get(act);
            context.unregisterReceiver(receiver);
        }
        
        mReceivers.clear();
        mActions.clear();
    }
    

}
