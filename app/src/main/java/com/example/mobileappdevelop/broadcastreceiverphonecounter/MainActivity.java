package com.example.mobileappdevelop.broadcastreceiverphonecounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    String phoneNumber;
    private static final String ACCESS_FILE="Accessability";
    private static String PHONE_NUMBER;
    private static final String PASS_WORD="pass";
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int anInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences(ACCESS_FILE,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
}
