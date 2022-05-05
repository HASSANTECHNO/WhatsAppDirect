package com.app.whatsappdirect

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.net.URLEncoder
import java.net.URLEncoder.encode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend : Button = findViewById(R.id.btnsend)
        val txtNumber : EditText = findViewById(R.id.edtnum)
        val txtMsg : EditText = findViewById(R.id.edtsms)
        btnSend.setOnClickListener {
            if(txtNumber.text.isNotEmpty() && txtMsg.text.isNotEmpty()){
                val packageManager : PackageManager = packageManager
                val i = Intent(Intent.ACTION_VIEW)
                val url = "https://api.whatsapp.com/send?phone=" + txtNumber.text.toString() + "&text="+ encode(txtMsg.text.toString(),"UTF-8")
                i.setPackage("com.whatsapp")
                i.data = Uri.parse(url)
                if(i.resolveActivity(packageManager) != null){
                    startActivity(i)
                }
            }else{
                Toast.makeText(this, "Please Enter Msg Or Number !!", Toast.LENGTH_LONG).show()
            } }
    }
}