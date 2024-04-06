package com.example.kotiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import com.example.kotiki.adapter.KotikListAdapter
import com.example.kotiki.databinding.ActivityMainBinding
import com.example.kotiki.model.entity.Kotik
import com.example.kotiki.model.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: KotikListAdapter by lazy {
        KotikListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.catList.adapter = adapter

        binding.searchView.clearFocus()
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                binding.searchView.clearFocus()
                fetchKotik(query)
                return false
            }
        })


    }

    private fun fetchKotik(name: String) {
        val client = ApiClient.instance
        val response = client.fetchKotikList(name)

        response.enqueue(object : Callback<List<Kotik>> {
            override fun onResponse(call: Call<List<Kotik>>, response: Response<List<Kotik>>) {
                println("HttpResponse: ${response.body()}")
                val cats = response.body() ?: emptyList()
                adapter.submitList(cats)
            }

            override fun onFailure(call: Call<List<Kotik>>, t: Throwable) {
                println("HttpResponse: ${t.message}")
                adapter.submitList(emptyList())
            }
        })
    }

}