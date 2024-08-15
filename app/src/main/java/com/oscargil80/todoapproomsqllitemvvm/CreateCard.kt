package com.oscargil80.todoapproomsqllitemvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oscargil80.todoapproomsqllitemvvm.databinding.ActivityCreateCardBinding

class CreateCard : AppCompatActivity() {
    lateinit var binding: ActivityCreateCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            if (binding.createTitle.text.toString().trim { it <= ' ' }.isNotEmpty()
                && binding.createPriority.text.toString().trim { it <= ' ' }.isNotEmpty()
            ) {
                var title = binding.createTitle.text.toString()
                var priority = binding.createPriority.text.toString()
                DataObject.setData(title, priority)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
        }


    }
}