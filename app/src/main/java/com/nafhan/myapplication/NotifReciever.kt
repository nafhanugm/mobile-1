package com.nafhan.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class NotifReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("RECEIVER", "onReceive: ")
        val msg = "Hai gesss!"
        if (msg != null) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }
}