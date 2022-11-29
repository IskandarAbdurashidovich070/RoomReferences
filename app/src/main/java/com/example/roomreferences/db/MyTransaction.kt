package com.example.roomreferences.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
class MyTransaction(var fromCardId: Int?, var toCardID: Int?, var summa: String?) {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

    var date = SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(Date())


}