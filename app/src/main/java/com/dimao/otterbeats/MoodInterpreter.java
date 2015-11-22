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
    private int initMood;                   //initial mood
    private int currentMood;                //recent mood
    private int lastMood;                   //last mood

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

    public int getMode(){
        return mode;
    }

    public void setInitMood(int newMood){
        initMood = newMood;
        lastMood = newMood;
    }

    public void setCurrentMood(int newMood){
        if(newMood > 0 && newMood < 5){
            lastMood = currentMood;
            currentMood = newMood;
        }
    }

    public int getInitMood(){
        return initMood;
    }

    public int getCurrentMood(){
        return currentMood;
    }

    public String update(){
        String result = "";
        if(mode == 1){
            result = maintainMood();
        }
        else{
            result = elevateMood();
        }
        return result;
    }

    public String initialStation(){
        String choice = "";
        
        return choice;
    }

    public String maintainMood(){
        String choice = "";
        if(currentMood == lastMood){
            //play same station
        }
        else{
            if(lastMood == 2 || lastMood == 1){
                //play more engaging station
            }
            else if(lastMood == 5){
                //play more calm station
            }
            else if(lastMood == 3){
                //play more boring station
            }
            else if(lastMood == 4){
                //play more frustrating song
            }

        }
        return choice;
    }



    public String elevateMood(){
        String choice = "";
        if(lastMood == 1 || lastMood == 2 || lastMood == 5){
            //keep playing same station
        }
        else if(lastMood == 3 && currentMood == 3){
            //play more engaging station
        }
        else if(lastMood == 4 && currentMood == 4){
            //play more calming station
        }
        return choice;
    }
}
