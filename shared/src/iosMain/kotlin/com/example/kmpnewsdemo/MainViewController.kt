package com.example.kmpnewsdemo

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmpnewsdemo.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }