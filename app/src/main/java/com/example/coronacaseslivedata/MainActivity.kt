package com.example.coronacaseslivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coronacaseslivedata.adapter.ListAdapter
import com.example.coronacaseslivedata.jdo.Cases
import com.example.coronacaseslivedata.viewmodel.ViewModelCase

class MainActivity : AppCompatActivity() {

    private lateinit var viewModelCase: ViewModelCase
    private lateinit var mRecyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView=findViewById(R.id.recycler_view)
        viewModelCase = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ViewModelCase::class.java)
        mRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        viewModelCase.getCases().observe(this, object:Observer<List<Cases>> {
            override fun onChanged(mListOfCase: List<Cases>) {
                mRecyclerView.adapter=ListAdapter(this@MainActivity,mListOfCase)
            }
        })
    }
}
