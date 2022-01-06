package com.mieya.jetpackstudy.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.mieya.jetpackstudy.R
import com.mieya.jetpackstudy.databinding.ActivityFlowBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity() {
    val flowViewModel:FlowViewModel  by  viewModels()
    private  val TAG = "FlowActivity"
    lateinit var binding: ActivityFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        flowViewModel.startFlow()
        binding.getFlow.setOnClickListener {
            lifecycleScope.launch {
                flowViewModel.baseFlow.collect {
                    Log.i(TAG, "baseFlow:$it ")
                }
                flowViewModel.coldFlow.map {  }.

                collect{
                    Log.i(TAG, "coldFlow:$it ")
                }
            }

        }
    }
}