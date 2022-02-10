package com.ir.poems.Adapters

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ir.poems.DataClassPoems.DataClassPoems
import com.ir.poems.Interface.MyOnClick
import com.ir.poems.R
import kotlinx.android.synthetic.main.item_poems.view.*

class AdapterPoems(private val context: Context, private val arrayListPoems: ArrayList<DataClassPoems> , var myOnClick: MyOnClick) :
    RecyclerView.Adapter<AdapterPoems.VH>() {


    inner class VH(var itemRV: View) : RecyclerView.ViewHolder(itemRV) {
        fun onBind(stringName: String , stringPoems : String , like : Boolean , position: Int) {
            itemRV.tv_sher_nomi.text = stringName
            itemRV.tv_sher.text = stringPoems

            if (like){
                itemRV.image_like.setImageResource(R.drawable.favorite)
            }else{
                itemRV.image_like.setImageResource(R.drawable.ic_favorite_dialog)
            }

            itemRV.card_poems.setOnClickListener {
                myOnClick.onClick(arrayListPoems , position , arrayListPoems[position].id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_poems, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(arrayListPoems[position].stringName , arrayListPoems[position].stringPoems , arrayListPoems[position].like , position)
    }

    override fun getItemCount(): Int = arrayListPoems.size



}