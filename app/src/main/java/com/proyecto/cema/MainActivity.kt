package com.proyecto.cema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.proyecto.cema.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://qa.proyecto-cema.com"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // WebView

        binding.webView.webChromeClient = object : WebChromeClient() {

        }

        binding.webView.webViewClient = object : WebViewClient() {

        }

        val settings = binding.webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true;

        binding.webView.loadUrl(BASE_URL)

    }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}