package com.oscargil80.todoapproomsqllitemvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.oscargil80.todoapproomsqllitemvvm.databinding.ActivityMainBinding
import com.oscargil80.todoapproomsqllitemvvm.databinding.ActivityUpdateCardBinding

class UpdateCard : AppCompatActivity() {
    lateinit var binding: ActivityUpdateCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val title = DataObject.getData(pos).title
            val prioriy = DataObject.getData(pos).priority

            binding.createTitle.setText(title)
            binding.createPriority.setText(prioriy)

            binding.deleteButton.setOnClickListener {
                DataObject.deleteData(pos)
            }

            binding.updateButton.setOnClickListener {
                val title = binding.createTitle.text.toString()
                val priority = binding.createPriority.text.toString()
                DataObject.updateData(pos,
                    title,
                    priority)
                //Toast.makeText(this, "Entre $pos $title, $prioriy", Toast.LENGTH_SHORT).show();
                myIntent()
            }

        }

    }

    private fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}