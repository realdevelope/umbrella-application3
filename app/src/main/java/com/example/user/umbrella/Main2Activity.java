package com.example.user.umbrella;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.view.View;

import androidx.core.app.NotificationCompat;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Bitmap mLargelconForNoti =
                        BitmapFactory.decodeResource(getResources(),R.drawable.image0);

                PendingIntent mPendingInternet = PendingIntent.getActivity(Main2Activity.this,0,
                        new Intent(getApplicationContext(), Main2Activity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

                //푸시알람 날리는 코드만 추가
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(Main2Activity.this)
                        .setSmallIcon(R.drawable.image0)
                        .setContentTitle("알림제목")
                        .setContentText("우산챙겨!!!!")
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setLargeIcon(mLargelconForNoti)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setContentIntent(mPendingInternet);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotificationManager.notify(0,mBuilder.build());

            }
        });
    }
}



