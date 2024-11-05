package com.nafhan.myapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ArrayAdapter
import com.nafhan.myapplication.databinding.ListUserBinding
import com.nafhan.myapplication.model.Data
import com.squareup.picasso.Picasso
import okio.IOException
import java.net.HttpURLConnection
import java.net.URL

class CustomListView(context: Context, resource: Int) : ArrayAdapter<String>(context, resource) {
    private val mContext: Context = context
    private val mResource: Int = resource
    private var mItems: ArrayList<Data> = ArrayList()

    fun setItems(items: ArrayList<Data>) {
        mItems = items
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return mItems.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup): android.view.View {
        val binding: ListUserBinding
        val view: android.view.View
        if (convertView == null) {
            val inflater = android.view.LayoutInflater.from(mContext)
            binding = ListUserBinding.inflate(inflater, parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ListUserBinding
        }
        binding.title.text = "Name: " + mItems[position].firstName + " " + mItems[position].lastName
        binding.subtitle.text = "Email: " + mItems[position].email
        Picasso.get().load(mItems[position].avatar).into(binding.avatar)

        view.setOnClickListener {
            val intent = android.content.Intent(mContext, Pert11DetailActivity::class.java)
            intent.putExtra(Pert11DetailActivity.EXTRA_NAME, mItems[position].firstName + " " + mItems[position].lastName)
            intent.putExtra(Pert11DetailActivity.EXTRA_EMAIL, mItems[position].email)
            intent.putExtra(Pert11DetailActivity.EXTRA_AVATAR, mItems[position].avatar)
            mContext.startActivity(intent)
        }
        return view
    }

    fun urlStringToBitmap(urlString: String): Bitmap? {
        return try {
            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream
            BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            e.printStackTrace()
            Log.d("ErrorImage", "Error: ${e.message}")
            null
        }
    }
}