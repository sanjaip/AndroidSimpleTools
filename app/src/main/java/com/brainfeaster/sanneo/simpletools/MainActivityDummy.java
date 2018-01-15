package com.brainfeaster.sanneo.simpletools;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

/**
 * Created by sanja on 9/13/2017.
 */

public class MainActivityDummy {

   /* public void myFancyMethod(View v) {
        // does something very interesting
        Button currCV = (Button)v;
        Double test =  Double.valueOf(v.getTag().toString());
        test= test *60;
        int testint = test.intValue();
        Calendar cc = Calendar.getInstance();
        cc.add(Calendar.MINUTE, testint);
        int currYear=cc.get(Calendar.YEAR);
        int currMonth=cc.get(Calendar.MONTH);
        int currDay = cc.get(Calendar.DAY_OF_MONTH);
        int currHour = cc.get(Calendar.HOUR_OF_DAY);
        int currMinute = cc.get(Calendar.MINUTE);
        showMessage(String.valueOf(cc.getTime()));
        setAlarm();
    }

    private void showMessage(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    private void storgeAlarm(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        // editor.putString("silentMode", 1);
        editor.commit();
    }

    private void setAlarm(){
      Calendar cc = Calendar.getInstance();
        cc.setTimeInMillis(System.currentTimeMillis());
        cc.set(Calendar.HOUR_OF_DAY, 8);
        cc.set(Calendar.MINUTE, 30);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
       Intent alarmIntent = new Intent(MainActivity.this, AlarmReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cc.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);
    }*/
}
