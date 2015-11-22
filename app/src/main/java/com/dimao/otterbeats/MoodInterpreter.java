package com.dimao.otterbeats;

import android.content.Context;
import android.util.Log;

/**
 * Created by harrisonoglesby on 11/21/15.
 */
public class MoodInterpreter {

    public static MoodInterpreter instance = null;

    private Context context = null;

    private int mode = 1;
    //1 = keep mood      2 = elevate mood
    private int initMood = 1;                   //initial mood
    private int currentMood = 1;                //recent mood
    private int lastMood = 1;                   //last mood

    private String[] excitedStations = {"1R2iL5hYKBrKy32T58CUUI", "6Qf2sXTjlH3HH30Ijo6AUp"
                        , "1h90L3LP8kAJ7KGjCV2Xfd","1B9o7mER9kfxbmsRH9ko4z" ,"0kVaFpvoi0O4IbyJyEZckU"
                        , "1vfys0yYhZEyJ9yvnULyM2"};
    private int exCtr = 0;

    private String[] engagedStations = {"1R2iL5hYKBrKy32T58CUUI", "6Qf2sXTjlH3HH30Ijo6AUp"
            , "1h90L3LP8kAJ7KGjCV2Xfd" ,"0kVaFpvoi0O4IbyJyEZckU", "1vfys0yYhZEyJ9yvnULyM2"};
    private int engCtr = 0;

    private String[] boredStations = {"3fCn2nqmX6ZnYUe9uoty98", "1oXl0OHlE1mPDChMa8Y0Ax"
            , "63dDpdoVHvx5RkK87g4LKk"};
    private int borCtr = 0;

    private String[] frustratedStations = {"1R2iL5hYKBrKy32T58CUUI", "6Qf2sXTjlH3HH30Ijo6AUp"
            , "1h90L3LP8kAJ7KGjCV2Xfd" ,"6cdV0hVW2suJaMOxzwE46S", "1vfys0yYhZEyJ9yvnULyM2"
            , "5Z9xJvDtHpB6m5zHgJC5zR"};
    private int fruCtr = 0;

    private String[] calmStations = {"3fCn2nqmX6ZnYUe9uoty98", "1oXl0OHlE1mPDChMa8Y0Ax"
            , "63dDpdoVHvx5RkK87g4LKk" ,"3hpgM1U3bD6kvo7wJubQ8z", "1iHelgbMaB7G1bjMbABPRe"};
    private int medCtr = 0;

    public static MoodInterpreter getInstance(){
        return instance;
    }

    public static MoodInterpreter getInstance(Context ctx){
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
        if(newMood > 0 && newMood < 5) {
            if (initMood == 0) {initMood = newMood;}
            lastMood = newMood;
        }
    }

    public void setCurrentMood(int newMood){
        Log.d("MoodInterpreter", "got new mood " + newMood);
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

    public String getUpdate(){
        Log.d("MoodInterpreter", "got update");
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
        switch (initMood){
            case 1:
                choice = pickExcitedStation();
                break;
            case 2:
                choice = pickEngagedStation();
                break;
            case 3:
                choice = pickBoredStations();
                break;
            case 4:
                choice = pickFrustratedStations();
                break;
            case 5:
                choice = pickCalmStations();
                break;
            default:
                choice = pickExcitedStation();
                break;
        }
        return choice;
    }

    public String maintainMood(){
        String choice = "";
        if(currentMood == initMood){
            //play same station
        }
        else{
            if(lastMood == 2 || lastMood == 1){
                choice = pickExcitedStation();
            }
            else if(lastMood == 5){
                choice = pickCalmStations();
            }
            else if(lastMood == 3){
                choice = pickBoredStations();
            }
            else if(lastMood == 4){
                choice = pickFrustratedStations();
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
            choice = pickEngagedStation();
        }
        else if(lastMood == 4 && currentMood == 4){
            choice = pickCalmStations();
        }
        return choice;
    }

    private String pickExcitedStation(){
        Log.d("MoodInterpreter", "pick Excited");
        exCtr++;
        if(exCtr >= excitedStations.length){
            exCtr = 0;
        }
        return excitedStations[exCtr];
    }
    private String pickEngagedStation(){
        Log.d("MoodInterpreter", "pick Engaged");
        engCtr++;
        if(engCtr >= engagedStations.length){
            engCtr = 0;
        }
        return engagedStations[engCtr];
    }
    private String pickBoredStations(){
        Log.d("MoodInterpreter", "pick Bored");
        borCtr++;
        if(borCtr >= boredStations.length){
            borCtr = 0;
        }
        return boredStations[borCtr];
    }
    private String pickFrustratedStations(){
        Log.d("MoodInterpreter", "pick Frustrated");
        fruCtr++;
        if(fruCtr >= frustratedStations.length){
            fruCtr = 0;
        }
        return frustratedStations[fruCtr];
    }
    private String pickCalmStations(){
        Log.d("MoodInterpreter", "pick Calm");
        medCtr++;
        if(medCtr >= calmStations.length){
            medCtr = 0;
        }
        return calmStations[medCtr];
    }
}
