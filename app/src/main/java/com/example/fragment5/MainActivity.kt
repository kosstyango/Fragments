package com.example.fragment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.fragment5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(BlankFragment1.newInstance(), R.id.place_holder1)
        openFrag(BlankFragment2.newInstance(), R.id.place_holder2)
        dataModel.message2Activity.observe(this, {
            binding.textView.text = it })
    }
    private fun openFrag(f: Fragment, idHolder: Int){
        supportFragmentManager //запускаем Фрагмент на Активити в Place_Holder
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}