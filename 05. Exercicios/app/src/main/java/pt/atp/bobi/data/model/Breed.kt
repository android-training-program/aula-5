package pt.atp.bobi.data.model

import com.squareup.moshi.Json

data class Breed(
    @field:Json(name = "bred_for")
    val bredFor: String,
    @field:Json(name = "bred_group")
    val bredGroup: String,
    @field:Json(name = "height")
    val height: Height,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "life_span")
    val lifeSpan: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "origin")
    val origin: String?,
    @field:Json(name = "temperament")
    val temperament: String,
    @field:Json(name = "weight")
    val weight: Weight
    )