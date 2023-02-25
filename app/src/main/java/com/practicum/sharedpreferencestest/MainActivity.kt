package com.practicum.sharedpreferencestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val PRACTICUM_EXAMPLE_PREFERENCES = "practicum_example_preferences"
const val EDIT_TEXT_KEY = "key_for_edit_text"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = getSharedPreferences(PRACTICUM_EXAMPLE_PREFERENCES, MODE_PRIVATE)

        val editText = findViewById<EditText>(R.id.editText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val restoreButton = findViewById<Button>(R.id.restoreButton)

        saveButton.setOnClickListener(){
            sharedPrefs.edit()
                .putString(EDIT_TEXT_KEY,editText.text.toString())
                .apply()
            Toast.makeText(this, "Сохранили значение ${editText.text}", Toast.LENGTH_SHORT).show()
        }

        restoreButton.setOnClickListener(){
            editText.setText(sharedPrefs.getString(EDIT_TEXT_KEY, ""))
        }

        // add comment yuhooo
        // new comment
    }
}