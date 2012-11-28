package com.lds.ifthen;

import android.content.Context;

import com.lds.ifthen.action.Action;
import com.lds.ifthen.trigger.Trigger;

public class Rule {

    private Trigger trigger;
    private Action action;

    public Rule() {

    }

    public Rule(Trigger trigger, Action action) {
        this.setTrigger(trigger);
        this.setAction(action);
    }

    public void register(Context context) {
        trigger.addOnActionListener(context, action);
    }

    public void unRegister(Context context) {
        trigger.removeOnActionListener(context, action);
    }

    //

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

}
