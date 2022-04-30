package com.joaovitormo.controledeestoque

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*var como inicialização "atrasada"*/
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSource()
    }

    private fun addDataSource() {

        val dataSource = DataSource.createDataSet()
        this.productAdapter.setDataSet(dataSource)
    }

    private fun initRecyclerView() {
        this.productAdapter = ProductAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = this.productAdapter
    }
}