package com.example.androidfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var textViewResult: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewResult = view.findViewById(R.id.textViewResult)

        // 3. ลงทะเบียน "รอรับพัสดุ" ที่มี Tracking Number ตรงกัน
        //    เราใช้ parentFragmentManager เพราะผู้ส่งและผู้รับเป็น Fragment ลูกของ Activity เดียวกัน
        parentFragmentManager.setFragmentResultListener(REQUEST_KEY, viewLifecycleOwner) { requestKey, bundle ->
            // 4. เมื่อได้รับผลลัพธ์แล้ว...
            val result = bundle.getString(BUNDLE_KEY)
            // นำข้อมูลไปแสดงผล
            textViewResult.text = result
        }
    }

}