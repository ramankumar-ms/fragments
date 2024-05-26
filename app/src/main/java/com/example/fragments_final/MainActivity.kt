package com.example.fragments_final

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragments_final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var fragmentManager:FragmentManager
    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFragment1.setOnClickListener{
            gotoFragment(Fragment1())
        }
        binding.buttonFragment2.setOnClickListener{
            gotoFragment(Fragment2())
        }


    }


    private fun gotoFragment(fragment:Fragment){
        fragmentManager=supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.framentContainer,fragment).commit()
    }
}