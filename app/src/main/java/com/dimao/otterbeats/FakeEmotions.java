package com.dimao.otterbeats;

import android.content.Context;

import java.util.Random;

/**
 * Created by harrisonoglesby on 11/21/15.
 */
public class FakeEmotions {

    public static FakeEmotions instance = null;

    private Context context = null;


    public static FakeEmotions getInstance(){
        return instance;
    }

    public static FakeEmotions getInstance(Context ctx){
        if(instance == null){
            instance = new FakeEmotions(ctx);
        }
        return instance;
    }


    public FakeEmotions(Context ctx){
        context = ctx;
    }


    public String getStartingEmotion(){
        Random random = new Random();
        int temp = random.nextInt(5) + 1;
        String result = "";
        switch (temp) {
            case 1: result = "EXCITEMENT";
                    break;
            case 2: result = "ENGAGEMENT";
                    break;
            case 3: result = "BOREDOM";
                    break;
            case 4: result = "FRUSTRATION";
                    break;
            case 5: result = "MEDITATION";
                    break;

            default: result = "other";
                    break;
        }
        return result;
    }

    public String getCurrentEmotion(){
        Random random = new Random();
        int temp = random.nextInt(5) + 1;
        String result = "";
        switch (temp) {
            case 1: result = "EXCITEMENT";
                break;
            case 2: result = "ENGAGEMENT";
                break;
            case 3: result = "BOREDOM";
                break;
            case 4: result = "FRUSTRATION";
                break;
            case 5: result = "MEDITATION";
                break;

            default: result = "other";
                break;
        }
        return result;
    }
}
