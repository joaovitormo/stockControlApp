package com.joaovitormo.controledeestoque.models

data class Product(
    var id: Long,
    var nome:String,
    var categoria:String,
    var posicao:String,
    var quantidade:Long,
    var valor:Double,
    var foto:String


)
