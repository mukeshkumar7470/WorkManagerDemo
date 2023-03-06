package com.mukesh.workmanagerdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.WorkManager
import com.mukesh.workmanagerdemo.ui.screens.MainScreen
import com.mukesh.workmanagerdemo.ui.screens.MainViewModel
import com.mukesh.workmanagerdemo.ui.theme.WorkManagerDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkManagerDemoTheme {
                val viewModel: MainViewModel = viewModel()
                viewModel.setWorkManager(WorkManager.getInstance(applicationContext))

                MainScreen(viewModel)
            }
        }
    }
}