package com.ir.poems

import android.R.attr
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ir.poems.Adapters.AdapterPoems
import com.ir.poems.DataClassPoems.DataClassPoems
import com.ir.poems.Interface.MyOnClick
import com.ir.poems.MyShare.MyShare
import com.ir.poems.Object.Object
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*
import java.text.FieldPosition
import kotlin.system.exitProcess
import android.content.ClipData
import android.content.ClipboardManager

import android.content.Context.CLIPBOARD_SERVICE
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.getSystemService
import android.R.attr.label
import android.content.Context


class SecondFragment : Fragment() {
    private lateinit var root: View
    lateinit var adapterPoems: AdapterPoems
    private lateinit var arrayListPoems: ArrayList<DataClassPoems>
    lateinit var dialog: BottomSheetDialog
    var forLike = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        var arrayList = ArrayList<DataClassPoems>()

        root = inflater.inflate(R.layout.fragment_second, container, false)

        MyShare.init(requireActivity())
        arrayListPoems = ArrayList()
        arrayListPoems.addAll(MyShare.dataList!!)

        if (Object.stringType != "Barcha" && Object.stringType != "Saqlangan") {
            for (i in arrayListPoems) {
                if (i.stringType == Object.stringType) {
                    arrayList.add(i)
                }
            }

        }

        if (Object.stringType == "Barcha") {
            arrayList = arrayListPoems
        }

        if (Object.stringType == "Saqlangan") {
            for (i in arrayListPoems) {
                if (i.like) {
                    arrayList.add(i)
                }
            }
        }

        buildRecyclerView(arrayList)

        root.tv_sher_nomi.text = Object.stringType.uppercase()

        root.image_ic_rectangle.setOnClickListener {
            findNavController().popBackStack()
        }

        return root
    }

    private fun buildRecyclerView(arrayList: ArrayList<DataClassPoems>) {
        adapterPoems = AdapterPoems(requireActivity(), arrayList, object : MyOnClick {
            override fun onClick(
                arrayListPoemsAdapter: ArrayList<DataClassPoems>,
                position: Int,
                id: Int,
            ) {

                buildDialog(arrayListPoemsAdapter[position].stringName,
                    arrayListPoemsAdapter[position].stringPoems,
                    arrayListPoemsAdapter[position].like, position, id)

                dialog.show()
            }
        })
        root.recyclerViewPoems.adapter = adapterPoems
    }

    private fun buildDialog(
        stringName: String,
        stringPoems: String,
        like: Boolean,
        position: Int,
        id: Int,
    ) {
        val bottomSheetDialog = BottomSheetDialog(requireActivity() , R.style.CustomBottomSheetDialogTheme)
        val view = layoutInflater.inflate(R.layout.item_bottom_sheet, null, false)

        val tvName = view.findViewById<TextView>(R.id.tv_sher_nomi)
        val tvPoems = view.findViewById<TextView>(R.id.tv_sher)
        val cardSms = view.findViewById<CardView>(R.id.card_sms)
        val cardLike = view.findViewById<CardView>(R.id.card_favorite)
        val cardShare = view.findViewById<CardView>(R.id.card_share)
        val cardCopy = view.findViewById<CardView>(R.id.card_copy)
        val imageLikeSelector = view.findViewById<ImageView>(R.id.image_dialog_like)

        tvName.text = stringName
        tvPoems.text = stringPoems

        if (like) {
            imageLikeSelector.setImageResource(R.drawable.favorite)
            forLike = 2
        } else {
            imageLikeSelector.setImageResource(R.drawable.ic_favorite_dialog)
            forLike = 1
        }

        cardLike.setOnClickListener {
            forLike += 1
            if (forLike % 2 == 0) {
                imageLikeSelector.setImageResource(R.drawable.favorite)
                arrayListPoems[id].like = true
                MyShare.dataList = arrayListPoems
                recyclerViewPoems.adapter!!.notifyItemChanged(position)
            } else {
                imageLikeSelector.setImageResource(R.drawable.ic_favorite_dialog)
                arrayListPoems[id].like = false
                MyShare.dataList = arrayListPoems
                recyclerViewPoems.adapter!!.notifyItemChanged(position)
            }
        }

        cardCopy.setOnClickListener {
            val clipboardManager =
                requireActivity().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("EditText", stringPoems)

            clipboardManager.setPrimaryClip(clipData)

            Toast.makeText(requireActivity(), "Copy", Toast.LENGTH_SHORT).show()
        }

        bottomSheetDialog.setContentView(view)

        dialog = bottomSheetDialog
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        dialog.window!!.attributes.gravity = Gravity.BOTTOM
    }
}