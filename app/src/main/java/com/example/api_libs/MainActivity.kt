package com.example.api_libs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.example.api_libs.brokers.VolleyBroker
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONObject

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getButton: Button = findViewById(R.id.fetch_button)
        val getResultTextView : TextView = findViewById(R.id.get_result_text)
        getButton.setOnClickListener {
            val intent = Intent(this, AlbumsListActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, "Pase de pantalla")
            }
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        supportActionBar!!.title = "Vinyls"
        return true
    }
}