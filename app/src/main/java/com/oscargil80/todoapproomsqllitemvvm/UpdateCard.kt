package com.oscargil80.todoapproomsqllitemvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.oscargil80.todoapproomsqllitemvvm.databinding.ActivityMainBinding
import com.oscargil80.todoapproomsqllitemvvm.databinding.ActivityUpdateCardBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCard : AppCompatActivity() {
    private lateinit var database: myDatabase
    lateinit var binding: ActivityUpdateCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val title = DataObject.getData(pos).title
            val prioriy = DataObject.getData(pos).priority

            binding.createTitle.setText(title)
            binding.createPriority.setText(prioriy)

            binding.deleteButton.setOnClickListener {
                DataObject.deleteData(pos)
                val title = binding.createTitle.text.toString()
                val priority = binding.createPriority.text.toString()
                GlobalScope.launch {
                    database.dao().deleteTask(
                        Entity(pos+1, title, priority)
                    )
                }

                myIntent()
            }

            binding.updateButton.setOnClickListener {
                val title = binding.createTitle.text.toString()
                val priority = binding.createPriority.text.toString()
                DataObject.updateData(pos,
                    title,
                    priority)

                GlobalScope.launch {
                    database.dao().updatetask(
                        Entity(pos+1, title, prioriy)
                    )
                }

                myIntent()
            }

        }

    }

    private fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}