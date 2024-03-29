package com.example.fragment5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragment5.databinding.Fragment2Binding

class BlankFragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //наблюдаем за действиями Активити
        dataModel.message2Fragment2.observe(activity as LifecycleOwner, { binding.tvMessage.text = it})

        //Слушаем кнопку Отправка сообщений на Фрагмент 1
        binding.bSendMessageFrag1.setOnClickListener {
            dataModel.message2Fragment1.value = "Hello Fragment 1 from Fragment 2"
        }
        //Слушаем кнопку Отправка сообщений на Активити
        binding.bSendToActivity.setOnClickListener {
            dataModel.message2Activity.value = "Hello Activity from Fragment 2"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}