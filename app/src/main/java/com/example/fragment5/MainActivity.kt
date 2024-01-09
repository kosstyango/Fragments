package com.example.fragment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragment5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragment2.setOnClickListener {//создаём слушатель кнопки
            //Toast.makeText(this, "Кнопка нажата", Toast.LENGTH_LONG).show() //показываем, что кнопка нажата
            supportFragmentManager //запускаем Фрагмент2 на Активити
                .beginTransaction()
                .replace(R.id.place_holder, BlankFragment2.newInstance())
                .commit()
        }

        supportFragmentManager //запускаем Фрагмент1 на Активити
            .beginTransaction()
            .replace(R.id.place_holder, BlankFragment.newInstance())
            .commit()
    }
}