package com.example.implicit_intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

import com.example.implicit_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val webBtn=findViewById<CardView>(R.id.webPageCard)
        val camBtn=findViewById<CardView>(R.id.cameraCard)
        val msgBtn=findViewById<CardView>(R.id.messageCard)

        webBtn.setOnClickListener{
            val intent=Intent(Intent.ACTION_VIEW)//action view is used to view the data in this case it is a web page
            intent.data=Uri.parse("https://www.google.com/")
            startActivity(intent)
        }
        camBtn.setOnClickListener{
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)//action image capture is used to capture the image
            startActivity(intent)//start the implicit intent
        }
        msgBtn.setOnClickListener{
            val sendmsg=Intent().apply{//apply is used to apply the changes in the intent
                action=Intent.ACTION_SEND//action send is used to send the message
                putExtra(Intent.EXTRA_TEXT,"hello")//extra text is used to send the text
                type="text/plain"//type is used to send the type of data

            }
            startActivity(sendmsg)//start the implicit intent

        }

    }
}