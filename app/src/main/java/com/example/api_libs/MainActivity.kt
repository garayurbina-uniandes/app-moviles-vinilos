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

class MainActivity : AppCompatActivity() {
    lateinit var volleyBroker: VolleyBroker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        volleyBroker = VolleyBroker(this.applicationContext)

        val getButton: Button = findViewById(R.id.fetch_button)
        val getResultTextView : TextView = findViewById(R.id.get_result_text)
        getButton.setOnClickListener {
            volleyBroker.instance.add(VolleyBroker.getRequest("albums",
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    getResultTextView.text = "Response is: ${response.substring(0, 500)}"
                },
                Response.ErrorListener {
                    Log.d("TAG", it.toString())
                    getResultTextView.text = "That didn't work!"
                }
            ))
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        supportActionBar!!.title = "Vinyls"
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                // Create an intent with a destination of the other Activity
                val intent = Intent(this, RetrofitActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}