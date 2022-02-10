package com.ir.poems.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.ir.poems.DataClassPoems.DataSpinner
import com.ir.poems.R
import kotlinx.android.synthetic.main.item_spinner.view.*

class AdapterSpinner(val context: Context, private val arrayListSpinner: ArrayList<DataSpinner>) :
    BaseAdapter() {
    override fun getCount(): Int = arrayListSpinner.size

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if (convertView == null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_spinner , parent , false)
        }else{
            view = convertView
        }
        view.image_itemSpinner.setImageResource(arrayListSpinner[position].image)
        view.tv_itemSpinner.text = arrayListSpinner[position].name

        return view
    }

    object SpinnerText{
        var text = ""
    }

}