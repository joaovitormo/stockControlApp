package com.joaovitormo.controledeestoque

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        this.productAdapter = ProductAdapter { product ->
            Toast.makeText(applicationContext, product.posicao, Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = this.productAdapter
    }

    /* função para abrir uma url
    private fun openLink(link: String) {

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)

    }*/
}