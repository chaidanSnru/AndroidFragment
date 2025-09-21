package com.example.androidfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment


class DynamicDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.dialog_edittext)
        val okButton = view.findViewById<Button>(R.id.dialog_button_ok)

        // เมื่อกดปุ่ม OK
        okButton.setOnClickListener {
            val enteredText = editText.text.toString()

            // 1. สร้าง "กล่องพัสดุ" (Bundle) และใส่ข้อมูล
            val result = Bundle().apply {
                putString(BUNDLE_KEY_TEXT, enteredText)
            }
            // 2. ส่งผลลัพธ์กลับไปพร้อม "Tracking Number"
            parentFragmentManager.setFragmentResult(REQUEST_KEY_DIALOG, result)

            // 3. ปิด Dialog
            dismiss()
        }

    }
}