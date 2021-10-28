package com.example.api_libs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.example.api_libs.brokers.RetrofitBroker
import com.google.android.material.textfield.TextInputEditText

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("testing", "hola")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        Log.d("testing",RetrofitBroker.test)
        val getButton: Button = findViewById(R.id.fetch_button_2)
        val getResultTextView : TextView = findViewById(R.id.get_result_text_2)
        getButton.setOnClickListener {
            RetrofitBroker.getRequest(onResponse = {
                getResultTextView.text = it
            }, onFailure = {
                getResultTextView.text = it
            })
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        supportActionBar!!.title = "Retrofit"
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                // Create an intent with a destination of the other Activity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}