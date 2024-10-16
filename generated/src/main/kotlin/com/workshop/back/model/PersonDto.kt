package com.workshop.back.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Object for person
 * @param name 
 * @param weight weight in kilos
 * @param height height in meters
 */
data class PersonDto(

    @field:JsonProperty("name", required = true) val name: kotlin.String,

    @field:JsonProperty("weight", required = true) val weight: java.math.BigDecimal,

    @field:JsonProperty("height", required = true) val height: java.math.BigDecimal
) {

}

