package com.example.androidfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ChildFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.child_textview)
        val button = view.findViewById<Button>(R.id.child_button)

        // Child "ส่งข้อมูล" กลับไปหา Parent
        button.setOnClickListener {
            val result = Bundle().apply { putString(BUNDLE_KEY, "Message from Child") }
            // ใช้ parentFragmentManager เพื่อส่งข้อมูลกลับไปหา "ผู้จัดการ" ที่เป็นแม่โดยตรง
            parentFragmentManager.setFragmentResult(KEY_CHILD_TO_PARENT, result)
        }

        // Child "รอรับข้อมูล" จาก Parent
        parentFragmentManager.setFragmentResultListener(KEY_PARENT_TO_CHILD, viewLifecycleOwner) { _, bundle ->
            textView.text = bundle.getString(BUNDLE_KEY)
        }
    }
}