package com.example.fragment5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragment5.databinding.Fragment1Binding

class BlankFragment1 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //наблюдаем за действиями Активити
        dataModel.message2Fragment1.observe(activity as LifecycleOwner, { binding.tvMessage.text = it})

        //Слушаем кнопку Отправка сообщений на Фрагмент 2
            binding.bSendMessageFrag2.setOnClickListener {
            dataModel.message2Fragment2.value = "Hello Fragment 2 from Fragment 1"
        }
        //Слушаем кнопку Отправка сообщений на Активити
            binding.bSendToActivity.setOnClickListener {
            dataModel.message2Activity.value = "Hello Activity from Fragment 1"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment1()
    }
}