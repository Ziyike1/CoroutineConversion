package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var cakeImageView: ImageView

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeImageView = findViewById(R.id.imageView)

        findViewById<Button>(R.id.revealButton).setOnClickListener {
            GlobalScope.launch(Dispatchers.Default) {
                repeat(100) { i ->
                    delay(40)
                    withContext(Dispatchers.Main) {
                        cakeImageView.alpha = i / 100f
                    }
                }
            }
        }
    }
}
