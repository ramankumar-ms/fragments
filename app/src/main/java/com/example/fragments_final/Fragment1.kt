package com.example.fragments_final

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class Fragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        val buttonMainThread: Button = view.findViewById(R.id.mainThread)


        buttonMainThread.setOnClickListener {
            showToast("Toast via Main Thread")
        }

        return view
    }

    private fun showToast(message: String) {

        val handler = Handler(Looper.getMainLooper())


        handler.post {

            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }


}