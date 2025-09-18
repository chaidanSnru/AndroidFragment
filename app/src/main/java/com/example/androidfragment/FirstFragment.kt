package com.example.androidfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextMessage = view.findViewById<EditText>(R.id.editTextMessage)
        val buttonSend = view.findViewById<Button>(R.id.buttonSend)

        buttonSend.setOnClickListener {
            val message = editTextMessage.text.toString()

            // 1. สร้าง "กล่องพัสดุ" (Bundle) และใส่ข้อความลงไป
            val result = Bundle().apply {
                putString(BUNDLE_KEY, message)
            }
            // 2. ส่งผลลัพธ์ไปที่ "ไปรษณีย์กลาง" (FragmentManager)
            //    พร้อม "Tracking Number" (REQUEST_KEY)
            parentFragmentManager.setFragmentResult(REQUEST_KEY, result)

            Toast.makeText(requireContext(), "ส่งข้อมูลแล้ว!", Toast.LENGTH_SHORT).show()
        }
    }

}