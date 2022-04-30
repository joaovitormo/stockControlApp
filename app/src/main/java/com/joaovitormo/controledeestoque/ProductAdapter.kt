package com.joaovitormo.controledeestoque

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joaovitormo.controledeestoque.models.Product
import kotlinx.android.synthetic.main.res_item_product.view.*


class ProductAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items : List<Product> = ArrayList()


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
        }

    }
}