package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSave.setOnClickListener { handleSave() }


    }



    private fun handleSave() {
        val name = binding.editName.text.toString()

        if (name != "") {

            SecurityPreferences(this).storeString("User_Name", name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        } else {

            Toast.makeText(this, R.string.validation_name, Toast.LENGTH_SHORT).show()

        }
    }

}