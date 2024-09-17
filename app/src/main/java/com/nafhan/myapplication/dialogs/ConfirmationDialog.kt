package com.nafhan.myapplication.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.nafhan.myapplication.Pert5TugasActivity
import com.nafhan.myapplication.Pert5TugasResultActicity
import com.nafhan.myapplication.databinding.ConfirmationDialogBinding
import java.text.NumberFormat
import java.util.Locale

class ConfirmationDialog: DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val binding = ConfirmationDialogBinding.inflate(inflater)
        val format = NumberFormat.getNumberInstance(Locale("id", "ID"))
        val harga = format.format(Pert5TugasActivity.getTiketPemesanan().getHarga())
        with(binding){
            tarifTiket.text = "Rp. $harga"
            btnCancel.setOnClickListener {
                dismiss()
            }
            btnBeli.setOnClickListener {
                val intent = Intent(requireActivity(), Pert5TugasResultActicity::class.java)
                intent.putExtra("tiket", Pert5TugasActivity.getTiketPemesanan())

                startActivity(intent)
            }
        }
        builder.setView(binding.root)
        return builder.create()
    }

}