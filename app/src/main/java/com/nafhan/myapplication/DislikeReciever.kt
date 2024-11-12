package com.nafhan.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DislikeReciever: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Pert12Activity.dislike++
        Pert12Activity.binding.tvDislike.text = Pert12Activity.dislike.toString()
    }
}