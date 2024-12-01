package com.hfad.kurs

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "sofa", "Диван", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "Sed do eiusmod tempor incididunt ut laboris nist ut aliguip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor prodient, sunt in culpa aui officia deserunt mollit anim id est laborum.", 999))
        items.add(Item(2, "light", "Свет", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "Sed do eiusmod tempor incididunt ut laboris nist ut aliguip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor prodient, sunt in culpa aui officia deserunt mollit anim id est laborum.", 399))
        items.add(Item(3, "kitchen", "Кухня", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "Sed do eiusmod tempor incididunt ut laboris nist ut aliguip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor prodient, sunt in culpa aui officia deserunt mollit anim id est laborum.", 2999))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}