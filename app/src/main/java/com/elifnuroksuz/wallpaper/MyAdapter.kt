package com.elifnuroksuz.wallpaper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MyAdapter(private val context: Context, private val dataList: ArrayList<DataClass>) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (view == null) {
            view = layoutInflater!!.inflate(R.layout.grid_item, null)
        }

        val gridImage = view?.findViewById<ImageView>(R.id.gridImage)
        val gridCaption = view?.findViewById<TextView>(R.id.gridCaption)

        Glide.with(context).load(dataList[position].imageURL).into(gridImage!!)
        gridCaption?.text = dataList[position].caption

        return view
    }
}
