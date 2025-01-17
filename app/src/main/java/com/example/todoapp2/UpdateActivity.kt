package com.example.todoapp2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.todoapp2.databinding.ActivityUpdateBinding

class UpdateActivity:AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var db:TasksDatabaseHelper
    private var noteId: Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= TasksDatabaseHelper(this)

        noteId=intent.getIntExtra("note_id",-1)

        if (noteId==-1){
            finish()
            return
        }

        val note=db.getNoteByID(noteId)
        binding.updateTitleEditText.setText(note.title)
        binding.updateContentEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener {
            val newTitle=binding.updateTitleEditText.text.toString()
            val newContent=binding.updateContentEditText.text.toString()
            val updateTask=Task(noteId,newTitle,newContent)
            db.updateNote(updateTask)
            finish()
            Toast.makeText(this,"Updated Saved",Toast.LENGTH_SHORT).show()
        }
    }
}