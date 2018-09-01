package com.zokscore.mobile.broadcastdetector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            String str = intent.getStringExtra("activity");

            System.out.println(str);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {

        super.onResume();

        IntentFilter filter = new IntentFilter("zokscore.com.mobile.patternrecognition.BROADCAST_ACTIVITY");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(receiver);
    }
}
