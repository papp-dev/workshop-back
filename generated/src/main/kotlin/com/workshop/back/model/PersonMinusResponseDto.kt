package com.workshop.back.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Object for person
 * @param id 
 * @param name 
 * @param weight weight in kilos
 * @param height height in meters
 * @param imcIndex imc index
 * @param imcClassification imc classification
 */
data class PersonMinusResponseDto(

    @field:JsonProperty("id") val id: kotlin.String? = null,

    @field:JsonProperty("name") val name: kotlin.String? = null,

    @field:JsonProperty("weight") val weight: java.math.BigDecimal? = null,

    @field:JsonProperty("height") val height: java.math.BigDecimal? = null,

    @field:JsonProperty("imcIndex") val imcIndex: java.math.BigDecimal? = null,

    @field:JsonProperty("imcClassification") val imcClassification: kotlin.String? = null
) {

}

