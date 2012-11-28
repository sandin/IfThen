package com.lds.ifthen;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;


public class IfThenManager {
    
    private static final String TAG = IfThenManager.class.getSimpleName();
    private List<Rule> rules = new ArrayList<Rule>();
    
    public IfThenManager() {
        // TODO Auto-generated constructor stub
    }
    
    public void start(Context context) {
        for (Rule rule: rules) {
            Log.d(TAG, "Register Rule: " + rule);
            rule.register(context);
        }
    }
    
    public void stop(Context context) {
        for (Rule rule: rules) {
            Log.d(TAG, "Unregister Rule: " + rule);
            rule.unRegister(context);
        }
    }
    
    public void addRule(Rule rule) {
        rules.add(rule);
    }
    
    public void removeRule(Rule rule) {
        rules.remove(rule);
    }

}
