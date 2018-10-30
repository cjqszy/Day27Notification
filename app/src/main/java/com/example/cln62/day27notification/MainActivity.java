package com.example.cln62.day27notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button, button3;
    NotificationCompat.Builder builder;
    NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 123, intent, 0);

        builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Notification Title");
        builder.setContentText("This is notification content");
        builder.setContentIntent(pendingIntent);

        builder.addAction(R.drawable.ic_launcher_foreground, "accept", pendingIntent);
        builder.addAction(R.drawable.ic_launcher_background, "reject", pendingIntent);

        builder.setAutoCancel(true);


        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.notify(1, builder.build());
                }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setContentTitle("This is the second titile");
                manager.notify(1, builder.build());
            }
        });
    }
}
