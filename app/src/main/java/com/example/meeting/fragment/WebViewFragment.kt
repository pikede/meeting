package com.example.meeting.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meeting.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {
    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!
    private lateinit var websiteURL: String

    companion object {
        const val URL = "url"

        fun newInstance(url: String?) =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                    putString(URL, url)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            websiteURL = it.getString(URL) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.webView) {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                allowFileAccess = true
                allowContentAccess = true
                loadUrl(websiteURL)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}