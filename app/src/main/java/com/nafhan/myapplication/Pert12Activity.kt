package com.nafhan.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.nafhan.myapplication.databinding.ActivityPert12Binding

class Pert12Activity: AppCompatActivity() {
    companion object {
        public var like = 0;
        public var dislike = 0;
        public lateinit var binding: ActivityPert12Binding
    }


    //Untuk value dari channelId & notifId bisa diisi sesuka hati
//Asalkan value channelId menggunakan string dan notifId menggunakan integer
    private val channelId = "TEST_NOTIF"
    private val notifId = 9
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPert12Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
        binding.btnNotif.setOnClickListener {
            val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PendingIntent.FLAG_IMMUTABLE
            }
            else {
                0
            }

            val intent = Intent(this,
                NotifReceiver::class.java).putExtra("MESSAGE", "Baca selengkapnya ...")
            val pendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                intent,
                flag
            )

            val likeIntent = Intent(this,
                LikeReciever::class.java)
            val likePendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                likeIntent,
                flag
            )

            val dislikeIntent = Intent(this,
                DislikeReciever::class.java)
            val dislikePendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                dislikeIntent,
                flag
            )

            binding.tvLike.text = like.toString()
            binding.tvDislike.text = dislike.toString()


            val notifImage = BitmapFactory.decodeResource(resources,
                R.drawable.hanip)
            sendBroadcast(intent)
            val notifIcon = BitmapFactory.decodeResource(resources,
                R.drawable.hamil)
            val builder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.hamil)
                .setColor(Color.GREEN)
                .setLargeIcon(notifIcon)
                .setContentTitle("counter")
                .setContentText("Hai gessss!")
//                .setAutoCancel(true)
                .setStyle(NotificationCompat.BigPictureStyle()
                    .bigPicture(notifImage)
                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .addAction(0, "Like", likePendingIntent)
                .addAction(0, "Dislike", dislikePendingIntent)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notifChannel = NotificationChannel(
                    channelId, // Id channel
                    "Notifku", // Nama channel notifikasi
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                with(notifManager) {
                    createNotificationChannel(notifChannel)
                    notify(notifId, builder.build())
                }
            }
            else {
                notifManager.notify(notifId, builder.build())
            }
        }
    }

}