package com.example.androidfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class ParentFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.parent_textview)
        val button = view.findViewById<Button>(R.id.parent_button)

        // Parent "ส่งข้อมูล" ไปให้ Child
        button.setOnClickListener {
            val result = Bundle().apply { putString(BUNDLE_KEY, "Message from Parent") }
            // ใช้ childFragmentManager เพื่อส่งข้อมูลไปยัง Fragment ลูกที่ตัวเองจัดการอยู่
            childFragmentManager.setFragmentResult(KEY_PARENT_TO_CHILD, result)
        }

        // Parent "รอรับข้อมูล" จาก Child
        // ใช้ childFragmentManager เพื่อรอรับฟังผลลัพธ์จาก Fragment ลูกของตัวเองเท่านั้น
        childFragmentManager.setFragmentResultListener(KEY_CHILD_TO_PARENT, viewLifecycleOwner) { _, bundle ->
            textView.text = bundle.getString(BUNDLE_KEY)
        }
    }
}