package com.example.meeting.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meeting.databinding.ActivityMainBinding
import com.example.meeting.models.Sports
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by inject()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(mainViewModel) {
            sportsLiveData.observe(this@MainActivity, sportsObserver)
            errorMessage.observe(this@MainActivity, errorObserver)
            getSports()
        }

        initView()
    }

    private fun initView() {
        recyclerView = binding.rvSports
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            mainAdapter = MainAdapter(emptyList())
            adapter = mainAdapter
        }
    }

    private val sportsObserver = Observer<Sports> {

        it?.sports?.let { items -> mainAdapter.updateSportItems(items) }
        Toast.makeText(this@MainActivity, "${it.sports[0]}", Toast.LENGTH_LONG).show()
    }

    private val errorObserver = Observer<String> {
        Toast.makeText(this@MainActivity, it, Toast.LENGTH_LONG).show()
    }
}