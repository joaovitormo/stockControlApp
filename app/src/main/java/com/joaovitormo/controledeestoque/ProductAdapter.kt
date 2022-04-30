package com.joaovitormo.controledeestoque

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.joaovitormo.controledeestoque.models.Product
import kotlinx.android.synthetic.main.res_item_product.view.*
import java.text.NumberFormat


class ProductAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<Product> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is ProductViewHolder -> {
                holder.bind(items[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(products : List<Product>) {
        this.items = products
    }

    class ProductViewHolder constructor(
        itemView: View
    ):RecyclerView.ViewHolder(itemView){

        private val nomeProduct = itemView.nome
        private val valorProduct = itemView.valor
        private val imagemProduct = itemView.imagem



        /*Recebe o objeto, e transforma para mostrar na view*/
        fun bind(product: Product){
            nomeProduct.text = product.nome
            valorProduct.text = product.valor.toString()

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(product.foto)
                .into(imagemProduct)
        }

    }
}