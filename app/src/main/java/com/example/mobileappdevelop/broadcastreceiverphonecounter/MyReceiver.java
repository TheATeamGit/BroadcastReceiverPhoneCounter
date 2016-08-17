package com.example.mobileappdevelop.broadcastreceiverphonecounter;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    String phoneNumber;
    /*private static final String ACCESS_FILE="Accessability";
    private static final String PASS_WORD="pass";
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;*/
    private static String PHONE_NUMBER;
    int anInt;
    public MyReceiver() {


    }


    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferenceMy myshp = new SharedPreferenceMy(context);
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.


        if(intent.getAction().equals (Intent. ACTION_NEW_OUTGOING_CALL))
        {
            PHONE_NUMBER = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

            if(myshp.pop(PHONE_NUMBER)==-1)
            {
                Log.e("This is null",PHONE_NUMBER);
                //Toast.makeText(context,"This is null",Toast.LENGTH_LONG);

                myshp.push(PHONE_NUMBER,0);
            }

            anInt = myshp.pop(PHONE_NUMBER);
            anInt=anInt+1;
            myshp.push(PHONE_NUMBER,anInt);

            PHONE_NUMBER= PHONE_NUMBER+"("+anInt+")";
            Notification notification = new Notification.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Outgoing Number")
                    .setContentText(PHONE_NUMBER)
                    .setAutoCancel(true)
                    .build();
            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify((int) System.currentTimeMillis(),notification);
            PHONE_NUMBER=null;
        }


        else if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE))
        {

            /*if(sharedPreferences.getInt(PHONE_NUMBER,-1)==-1)
            {
                this.context=context;
                Log.e("This is null","This is null");
                //Toast.makeText(context,"This is null",Toast.LENGTH_LONG);

                editor.putInt(PHONE_NUMBER,0);
                editor.commit();
            }

                anInt = sharedPreferences.getInt(PHONE_NUMBER,-1);
                anInt=anInt+1;
                editor.putInt(PHONE_NUMBER,anInt);

            PHONE_NUMBER= PHONE_NUMBER+"("+anInt+")";
            Notification notification = new Notification.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Outgoing Number")
                    .setContentText(PHONE_NUMBER)
                    .setAutoCancel(true)
                    .build();
            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify((int) System.currentTimeMillis(),notification);
            PHONE_NUMBER=null;*/
        }
    }
}
