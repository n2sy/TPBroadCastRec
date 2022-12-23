package com.tp6.broad.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyReceiver receiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        receiver = new MyReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
    }

    @Override
    protected void onStart() {
        registerReceiver(receiver, intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
    unregisterReceiver(receiver);
        super.onStop();
    }

}
