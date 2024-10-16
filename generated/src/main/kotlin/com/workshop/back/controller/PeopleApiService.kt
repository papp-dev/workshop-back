package com.workshop.back.controller

import com.workshop.back.model.PersonDto
import com.workshop.back.model.PersonMinusResponseDto

interface PeopleApiService {

    fun create(personDto: PersonDto): PersonMinusResponseDto

    fun list(): List<PersonMinusResponseDto>
}
