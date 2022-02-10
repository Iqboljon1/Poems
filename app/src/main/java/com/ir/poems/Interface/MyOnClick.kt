package com.ir.poems.Interface

import com.ir.poems.DataClassPoems.DataClassPoems
import java.text.FieldPosition

interface MyOnClick {
    fun onClick(arrayListPoemsAdapter: ArrayList<DataClassPoems>, position: Int, id: Int) {

    }
}