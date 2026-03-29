package com.socialsparks

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Time

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declarations

        val tvTOD = findViewById<TextView>(R.id.tvTOD)
        val tvSuggestions = findViewById<TextView>(R.id.tvSuggestions)
        val TimeOfDay =findViewById<EditText>(R.id.TimeOfDay)
        val tvResults = findViewById<TextView>(R.id.tvResults)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)

        //Reset Button

        btnReset.setOnClickListener {
            TimeOfDay.text.clear()
            tvResults.text = ""
        }

        // Suggest Button

        btnSuggest.setOnClickListener {
            val TimeOfDay = TimeOfDay.text.toString()

          if (TimeOfDay.isEmpty()) {
              tvResults.text = "Please enter time of day."
          } else {
              if (TimeOfDay == "Morning" || TimeOfDay == "morning") {
                  tvResults.text = "Send a 'Good morning' text to a family member."
              } else {
                  if(TimeOfDay == "Mid-morning" || TimeOfDay == "Mid Morning") {
                      tvResults.text = "Reach to a colleague with a quick 'Thank You'."
                  } else if (TimeOfDay == "Afternoon" || TimeOfDay == "afternoon") {
                      tvResults.text = "Share a funny meme or interesting link with a friend."
                  } else if (TimeOfDay == "Afternoon snack time" || TimeOfDay == "afternoonsnack time" || TimeOfDay == "Snack time" || TimeOfDay == "snack time") {
                      tvResults.text = "Send a quick 'Tinking of you' message."
                  } else if(TimeOfDay == "Dinner" || TimeOfDay == "dinner") {
                      tvResults.text = "Call a friend or relative for a 5-minute catch-up."
                  } else if(TimeOfDay == "After Dinner" || TimeOfDay == "After dinner"|| TimeOfDay == "Night" || TimeOfDay == "night") {
                      tvResults.text = "Leave a thoughtful comment on a friend's post."
                  } else {
                      tvResults.text = "Invalid! Please enter Morning, Mid-morning, Afternoon, Afternoon snack time, Dinner, Night."
                  }
              }
          }
        }



    }
}