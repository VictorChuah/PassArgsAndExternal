package com.example.test

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn :Button = findViewById(R.id.btnAbout)

        btn.setOnClickListener(){
            val intentAbout = Intent(this, AboutActivity::class.java)

            val telNo = Uri.parse("tel: 012341234")
            val intentTel = Intent(Intent.ACTION_DIAL,telNo)

            val geo = Uri.parse("geo:3.1390, 101.6869")
            val intentGeo = Intent(Intent.ACTION_VIEW, geo)

            val intentMessage = Intent(Intent.ACTION_SEND)
            intentMessage.setType("text/plain")
            intentMessage.putExtra(Intent.EXTRA_TEXT,"Hello how are you?")

            try {
                startActivity(intentMessage)
            }catch(e : ActivityNotFoundException){
                Toast.makeText(this,"No App Found", Toast.LENGTH_LONG).show()
            }

        }
    }
}