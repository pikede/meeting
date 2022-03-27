package com.example.meeting.activities.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meeting.databinding.ActivityMainBinding
import com.example.meeting.fragment.SplitViewFragment
import com.example.meeting.fragment.WebViewFragment
import com.example.meeting.models.Sport
import com.example.meeting.models.Sports
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainAdapter.SelectedSportListener {

    private val mainViewModel: MainViewModel by inject()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

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
        with(binding.rvSports) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            mainAdapter = MainAdapter(this@MainActivity, this@MainActivity, emptyList())
            adapter = mainAdapter
        }
    }

    private val sportsObserver = Observer<Sports> {
        it?.sports?.let { items -> mainAdapter.updateSportItems(items) }
        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
    }

    private val errorObserver = Observer<String> {
        Toast.makeText(this@MainActivity, it, Toast.LENGTH_LONG).show()
    }

    override fun sportSelected(sport: Sport) {
//        val fragment = SplitViewFragment.newInstance(
//            sport.name,
//            sport.thumb,
//            description = sport.description
//        )
        //https://www.thesportsdb.com/api/v1/json/2/all_sports.php
        val fragment = WebViewFragment.newInstance("https://www.google.com")
        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, fragment)
            .commit()
    }
}