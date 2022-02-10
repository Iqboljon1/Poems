package com.ir.poems

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import com.ir.poems.Adapters.AdapterSpinner
import com.ir.poems.DataClassPoems.DataClassPoems
import com.ir.poems.DataClassPoems.DataSpinner
import com.ir.poems.MyShare.MyShare
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.android.synthetic.main.fragment_third.view.*


class ThirdFragment : Fragment() {
    lateinit var root: View
    lateinit var arrayListPoems: ArrayList<DataClassPoems>
    lateinit var arrayListSpinner: ArrayList<DataSpinner>
    lateinit var adapterSpinner: AdapterSpinner
    var stringType = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        root = inflater.inflate(R.layout.fragment_third, container, false)

        buildSpinner()

        arrayListPoems = ArrayList()
        MyShare.init(requireActivity())
        arrayListPoems.addAll(MyShare.dataList!!)

        root.card_add.setOnClickListener {
            val name = editText_name.text.toString().trim()
            val poems = editText_poems.text.toString().trim()
            if (name.isNotEmpty() && poems.isNotEmpty() && stringType.isNotEmpty()){
                arrayListPoems.add(DataClassPoems(name , poems , false , stringType , arrayListPoems.size))
                MyShare.dataList = arrayListPoems
                Toast.makeText(requireActivity(), "Saqlandi", Toast.LENGTH_SHORT).show()
                root.editText_name.text!!.clear()
                root.editText_poems.text!!.clear()
                buildSpinner()
            }else{
                Toast.makeText(requireActivity(), "Ma'lumot to'liq emas", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    private fun buildSpinner() {
        arrayListSpinner = ArrayList()
        arrayListSpinner.add(DataSpinner(R.drawable._03_lives, "Sevgi"))
        arrayListSpinner.add(DataSpinner(R.drawable._02_ace, "Sog'inch"))
        arrayListSpinner.add(DataSpinner(R.drawable._06_message, "Tabrik"))
        arrayListSpinner.add(DataSpinner(R.drawable._05_home, "Ota-Ona"))
        arrayListSpinner.add(DataSpinner(R.drawable._04_e_sports, "Do'stlik"))
        arrayListSpinner.add(DataSpinner(R.drawable._01_flower, "Hazil"))
        adapterSpinner = AdapterSpinner(requireActivity(), arrayListSpinner)
        root.mySpinner.adapter = adapterSpinner

        root.mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                when (position) {
                    0 -> {
                        stringType = "Sevgi va Sog'inch"
                    }
                    1 -> {
                        stringType = "Sevgi va Sog'inch"
                    }
                    2 -> {
                        stringType = "Tabrik"
                    }
                    3 -> {
                        stringType = "Ota-Ona haqida"
                    }
                    4 -> {
                        stringType = "Do'stlik"
                    }
                    5 -> {
                        stringType = "Hazil"
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

    }
}