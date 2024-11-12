package com.nafhan.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class LikeReciever: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
//        setelah menerima broadcast akan menambah like dengan 1
        Pert12Activity.like++
        Pert12Activity.binding.tvLike.text = Pert12Activity.like.toString()
    }
}