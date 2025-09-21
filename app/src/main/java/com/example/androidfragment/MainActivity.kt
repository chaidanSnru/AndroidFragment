package com.example.androidfragment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val textViewResult = findViewById<TextView>(R.id.activity_textview_result)
        val openButton = findViewById<Button>(R.id.activity_button_open)

        // 3. Activity ลงทะเบียน "รอรับพัสดุ"
        supportFragmentManager.setFragmentResultListener(REQUEST_KEY_DIALOG, this) { requestKey, bundle ->
            // 4. เมื่อได้รับผลลัพธ์แล้ว
            val result = bundle.getString(BUNDLE_KEY_TEXT)
            textViewResult.text = "Hello, $result"
        }

        // เมื่อกดปุ่ม ให้เปิด Dialog (Dynamic Fragment)
        openButton.setOnClickListener {
            DynamicDialogFragment().show(supportFragmentManager, "DynamicDialogFragment")
        }
    }
}