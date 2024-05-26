package com.example.fragments_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Fragment2 : Fragment() {

    private var job: Job? = null // Coroutine Job

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_2, container, false)

        val buttonBackgroundThread: Button = view.findViewById(R.id.backgroudThread)


        buttonBackgroundThread.setOnClickListener {
            showToast("Backgroud thread started")
            startBackgroundTask()
        }

        return view



    }

    private fun startBackgroundTask() {
        job = CoroutineScope(Dispatchers.Default).launch {

            delay(6000) // 10 seconds


            withContext(Dispatchers.Main) {
                showToast("Ended")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel() // Cancel the coroutine job to prevent memory leaks
    }


}