package com.jriveiro.publicapirest.ui.listcontributors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jriveiro.publicapirest.R
import com.jriveiro.publicapirest.bd.ContributorsDB
import com.jriveiro.publicapirest.model.api.Contributors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListContributorsActivity : AppCompatActivity() {
    lateinit var mRecyclerView : RecyclerView
    val mAdapter : ListContributorsAdapter = ListContributorsAdapter()
    private lateinit var database: ContributorsDB
    var listaContributors = emptyList<Contributors>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_contributors)
        database = ContributorsDB.getDatabase(this)

        startUI()

    }

    private fun startUI() {
        CoroutineScope(Dispatchers.IO).launch {
            listaContributors = database.contributorDao().getAllContributors()
            setUpRecyclerView()
        }
    }

    fun setUpRecyclerView() {
        mRecyclerView = findViewById(R.id.contributorsRecyclerView) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.ListContributorsAdapter(listaContributors, this)
        mRecyclerView.adapter = mAdapter

    }
}