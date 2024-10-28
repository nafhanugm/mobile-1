package com.nafhan.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nafhan.myapplication.databinding.ActivityPert10Binding

class Pert10Activity: AppCompatActivity() {
    private lateinit var binding: ActivityPert10Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPert10Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, Tugas10DetailActivity::class.java)
        val adapterEmail = EmailAdapter(generateDummy()) {
                email ->
            intent.putExtra(Tugas10DetailActivity.EXTRA_NAME, email.nameEmail)
            intent.putExtra(Tugas10DetailActivity.EXTRA_SUBJECT, email.subject)
            intent.putExtra(Tugas10DetailActivity.EXTRA_TEXT, email.text)
            intent.putExtra(Tugas10DetailActivity.EXTRA_DATE, email.date)
            startActivity(intent)
        }
        with(binding) {
            rvDisaster.apply {
                adapter = adapterEmail
                layoutManager = LinearLayoutManager(this@Pert10Activity)
            }

        }
    }

    fun generateDummy(): List<Email> {
        return listOf(
            Email(nameEmail = "John Doe", text = "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", date = "20 Okt", subject = "Pemberitahuan: Sarapan gratis akan segera dimulai!"),
            Email(nameEmail = "Jane Doe", text = "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", date = "21 Okt", subject = "Pemberitahuan: Sarapan gratis akan segera dimulai!"),
            Email(nameEmail = "Charlie Chaplin", text = "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", date = "22 Okt", subject = "Pemberitahuan: Sarapan gratis akan segera dimulai!"),
            Email(nameEmail = "Mary Doe", text = "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", date = "23 Okt", subject = "Pemberitahuan: Sarapan gratis akan segera dimulai!"),
            Email(nameEmail = "Dony Doe", text = "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", date = "20 Okt", subject = "Hello, how are you?"),
            Email(nameEmail = "Joe Doe", text = "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", date = "21 Okt", subject = "Hello, how are you?"),
            Email(nameEmail = "Barely Chaplin", text = "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan, dan nikmati pilihan menu yang tersedia. Pastikan untuk datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!", date = "22 Okt", subject = "Hello, how are you?"),
        )
    }
}