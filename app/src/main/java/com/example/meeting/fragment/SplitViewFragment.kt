package com.example.meeting.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.meeting.databinding.FragmentSplitViewBinding
import com.squareup.picasso.Picasso


class SplitViewFragment : Fragment() {

    private var _binding: FragmentSplitViewBinding? = null
    private val binding get() = _binding!!
    lateinit var sportName: String
    lateinit var sportThumb: String
    lateinit var sportDescription: String

    companion object {
        const val SPORT_NAME = "sport_name"
        const val SPORT_THUMB = "sport_thumb"
        const val SPORT_DESCRIPTION = "sport_description"

        fun newInstance(name: String?, thumb: String?, description: String?) =
            SplitViewFragment().apply {
                arguments = Bundle().apply {
                    putString(SPORT_NAME, name)
                    putString(SPORT_THUMB, thumb)
                    putString(SPORT_DESCRIPTION, description)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sportName = arguments?.getString(SPORT_NAME) ?: "no name"
        sportThumb = arguments?.getString(SPORT_THUMB) ?: ""
        sportDescription = arguments?.getString(SPORT_DESCRIPTION) ?: "no description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplitViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        if (sportThumb.isNotEmpty()) {
            Picasso.get().load(sportThumb).fit().into(binding.thumb)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}