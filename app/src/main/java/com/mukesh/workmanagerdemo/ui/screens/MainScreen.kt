package com.mukesh.workmanagerdemo.ui.screens

import android.Manifest
import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mukesh.workmanagerdemo.ui.permission.RuntimePermissionsDialog

@Composable
fun MainScreen(viewModel: MainViewModel) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        RuntimePermissionsDialog(
            Manifest.permission.POST_NOTIFICATIONS,
            onPermissionDenied = {},
            onPermissionGranted = {},
        )
    }

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Button(onClick = {
            viewModel.runOneTimeWorkRequest()
        }) {
            Text("One Time Work Request")
        }

        Button(onClick = {
            viewModel.runOneTimeExpeditedWorkRequest()
        }) {
            Text("One Time Expedite Work Request")
        }

        Button(onClick = {
            viewModel.runPeriodicWorkRequest()
        }) {
            Text("Periodic Work Request")
        }

        Button(onClick = {
            viewModel.runPeriodicWorkRequestInitialDelay()
        }) {
            Text("Periodic Work Request - Initial Delay")
        }


        Button(onClick = {
            viewModel.cancelWorker()
        }) {
            Text("Cancel Worker!")
        }
    }
}