package com.lds.ifthen;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lds.ifthen.action.Action;
import com.lds.ifthen.action.impl.SimpleToastAction;
import com.lds.ifthen.trigger.Trigger;
import com.lds.ifthen.trigger.impl.TimeTrigger;

public class IfThenService extends Service {

    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();

    /**
     * Class used for the client Binder. Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        IfThenService getService() {
            // Return this instance of LocalService so clients can call public
            // methods
            return IfThenService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        return super.onStartCommand(intent, flags, startId);
    }

    private IfThenManager ifThenManager;

    public void a() {
        ifThenManager = new IfThenManager();

        // IF time pass 10 second
        // THEN make a toast
        Calendar c = new GregorianCalendar();
        c.add(Calendar.SECOND, 10);
        Trigger trigger = new TimeTrigger(c.getTimeInMillis());
        Action action = new SimpleToastAction("on time");
        ifThenManager.addRule(new Rule(trigger, action));

        ifThenManager.start(this);
    }

    public IfThenManager getIfThenManager() {
        return ifThenManager;
    }

    public void setIfThenManager(IfThenManager ifThenManager) {
        this.ifThenManager = ifThenManager;
    }

    
    
}
