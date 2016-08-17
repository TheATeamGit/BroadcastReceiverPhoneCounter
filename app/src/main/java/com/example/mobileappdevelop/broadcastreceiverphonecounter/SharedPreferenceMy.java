package com.example.mobileappdevelop.broadcastreceiverphonecounter;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Hasibuzzaman on 8/17/2016.
 */
public class SharedPreferenceMy {
    private static final String ACCESS_FILE="Accessability";
   // private static String PHONE_NUMBER;
   // private static final String PASS_WORD="pass";
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public SharedPreferenceMy(Context context) {
        sharedPreferences=context.getSharedPreferences(ACCESS_FILE, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }
    public void push(String PHONE_NUMBER, int value)
    {
        editor.putInt(PHONE_NUMBER,value);
        editor.commit();
    }
    public int pop(String PHONE_NUMBER)
    {
        return sharedPreferences.getInt(PHONE_NUMBER,-1);
    }
}
