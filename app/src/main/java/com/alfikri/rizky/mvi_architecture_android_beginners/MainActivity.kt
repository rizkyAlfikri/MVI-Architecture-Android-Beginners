package com.alfikri.rizky.mvi_architecture_android_beginners

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfikri.rizky.mvi_architecture_android_beginners.data.model.User
import com.alfikri.rizky.mvi_architecture_android_beginners.data.network.ApiHelperImpl
import com.alfikri.rizky.mvi_architecture_android_beginners.data.network.RetrofitBuilder
import com.alfikri.rizky.mvi_architecture_android_beginners.intent.MainIntent
import com.alfikri.rizky.mvi_architecture_android_beginners.utils.ViewModelFactory
import com.alfikri.rizky.mvi_architecture_android_beginners.view.MainAdapter
import com.alfikri.rizky.mvi_architecture_android_beginners.view.MainViewModel
import com.alfikri.rizky.mvi_architecture_android_beginners.viewstate.MainState
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private var mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupViewModel()
        observerViewModel()
        setupClick()
    }

    private fun setupClick() {
        buttonFetchUser?.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.FetchUser)
            }
        }
    }

    private fun setupView() {
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
            adapter = mainAdapter
        }
    }

    private fun setupViewModel() {
        mainViewModel =
            ViewModelProviders
                .of(
                    this,
                    ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService))
                )[MainViewModel::class.java]
    }

    private fun observerViewModel() {
        lifecycleScope.launch {
            mainViewModel.state.collect {
                when (it) {
                    is MainState.Idle -> {
                    }

                    is MainState.Loading -> {
                        buttonFetchUser.isVisible = false
                        progressBar?.isVisible = true
                    }

                    is MainState.Users -> {
                        buttonFetchUser.isVisible = false
                        progressBar?.isVisible = false
                        renderList(it.user)
                    }

                    is MainState.Error -> {
                        Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun renderList(users: List<User>) {
        recyclerView?.isVisible = true
        mainAdapter.submitList(users)
    }
}