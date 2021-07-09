package com.example.datatransfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 프래그먼트에서는 액티비티뷰모델즈를 사용해야됨 아니면 화면이 바뀌었을때 파괴됨
//        val mainViewModel by activityViewModels<MainViewModel>()

        button.setOnClickListener {
//            mainViewModel.data = "Hello"
            setFragmentResult(
                "requestKey",
                bundleOf("data" to "hello")
            )
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}