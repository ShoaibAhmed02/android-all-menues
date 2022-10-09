package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txt = findViewById<TextView>(R.id.textView)
        //registerForContextMenu(txt); // this is for registering the item in context menu!!!

        txt.setOnClickListener {
            var popupmenu:PopupMenu=PopupMenu(this,txt)
            popupmenu.menuInflater.inflate(R.menu.context_menu,popupmenu.menu)
            popupmenu.show()

            popupmenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.option1 ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.option2 ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.option3 ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })


        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_youtube, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

          if(item.itemId.toString()=="option1"){
              Toast.makeText(this,"Option1 is clicked",Toast.LENGTH_SHORT).show()
          }
          else if(item.itemId.toString()=="option2")
              Toast.makeText(this,"Option2  is clicked",Toast.LENGTH_SHORT).show()

        return super.onContextItemSelected(item)
    }


}