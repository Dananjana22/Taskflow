package com.example.todoapp2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    private lateinit var db:TasksDatabaseHelper
    private lateinit var tasksAdapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=TasksDatabaseHelper(this)
        tasksAdapter=TasksAdapter(db.getAllNotes(),this)

        binding.notesRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.notesRecyclerView.adapter=tasksAdapter


        binding.addButton.setOnClickListener{
            val intent=Intent(this,AddActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        tasksAdapter.refreshData(db.getAllNotes())
    }
}