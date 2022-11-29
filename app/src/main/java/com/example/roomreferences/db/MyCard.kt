package com.example.roomreferences.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MyCard(var name: String?, var number: Long?) {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null


}