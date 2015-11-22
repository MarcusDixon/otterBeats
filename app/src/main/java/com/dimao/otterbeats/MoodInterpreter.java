package com.dimao.otterbeats;

import android.content.Context;

/**
 * Created by harrisonoglesby on 11/21/15.
 */
public class MoodInterpreter {

    public MoodInterpreter instance = null;

    private Context context = null;

    private int mode = 0;
    //1 = keep mood      2 = elevate mood

    public MoodInterpreter getInstance(){
        return instance;
    }

    public MoodInterpreter getInstance(Context ctx){
        if(instance == null){
            instance = new MoodInterpreter(ctx);
        }
        return instance;
    }

    public MoodInterpreter(Context ctx){
        this.context = ctx;
    }

    public void setMode(int newMode){
        mode = newMode;
    }

}
