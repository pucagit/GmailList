package com.example.gmaillist

import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val items = mutableListOf<ItemModel>()
        for (i in 1..20) {
            if (i > 10) {
                val j = i - 10
                items.add(
                    ItemModel("Title $j", resources.getIdentifier("thumb$j", "drawable", packageName),
                        "Text from sender $j", "5:5$i PM")
                )
            } else {
                val j = i - 1
                items.add(
                    ItemModel("Title $i", resources.getIdentifier("thumb$i", "drawable", packageName),
                        "Text from sender $i", "5:4$j PM")
                )
            }
        }

        val adapter: BaseAdapter = ItemAdapter(items)
        val itemList: ListView = findViewById(R.id.myListView)
        itemList.adapter = adapter
    }
}