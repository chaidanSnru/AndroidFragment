package com.example.androidfragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

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
        // หาปุ่มจาก Layout
        val buttonFirst = findViewById<Button>(R.id.button_first)
        val buttonSecond = findViewById<Button>(R.id.button_second)

        // ตั้งค่า OnClickListener ให้ปุ่มแรก
        buttonFirst.setOnClickListener {
            // เมื่อกดปุ่ม ให้เรียกฟังก์ชัน replaceFragment เพื่อแสดง FirstFragment
            replaceFragment(FirstFragment())
        }

        // ตั้งค่า OnClickListener ให้ปุ่มที่สอง
        buttonSecond.setOnClickListener {
            // เมื่อกดปุ่ม ให้เรียกฟังก์ชัน replaceFragment เพื่อแสดง SecondFragment
            replaceFragment(SecondFragment())
        }
    }
    // สร้างฟังก์ชันสำหรับสลับ Fragment เพื่อลดการเขียนโค้ดซ้ำ
    private fun replaceFragment(fragment: Fragment) {
        // 1. รับ FragmentManager
        val fragmentManager = supportFragmentManager
        // 2. เริ่มต้น Transaction
        val transaction = fragmentManager.beginTransaction()
        // 3. ทำการ "แทนที่" Fragment ใน container ด้วย Fragment ที่ส่งเข้ามา
        transaction.replace(R.id.fragment_container, fragment)
        // 4. (Optional) เพิ่ม transaction นี้เข้า back stack เพื่อให้กดปุ่ม back กลับมาได้
        transaction.addToBackStack(null)
        // 5. ยืนยันการเปลี่ยนแปลง
        transaction.commit()
    }
}