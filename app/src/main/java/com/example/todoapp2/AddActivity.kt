package com.example.todoapp2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp2.databinding.ActivityAddBinding


class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private lateinit var db:TasksDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=TasksDatabaseHelper(this)
        binding.saveButton.setOnClickListener {
            val title=binding.titleEditText.text.toString()
            val content=binding.contentEditText.text.toString()
            val task=Task(0,title,content)
            db.insertNote(task)
            finish()
            Toast.makeText(this,"Note Saved sucessfully",Toast.LENGTH_SHORT).show()
        }


    }
}