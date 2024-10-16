package com.workshop.back.controller

import com.workshop.back.model.PersonDto
import com.workshop.back.model.PersonMinusResponseDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Validated
@RequestMapping("\${api.base-path:/api/v1}")
class PeopleApiController(@Autowired(required = true) val service: PeopleApiService) {


    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/people"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )

    fun create( @Valid @RequestBody personDto: PersonDto
): ResponseEntity<PersonMinusResponseDto> {
        return ResponseEntity(service.create(personDto), HttpStatus.valueOf(200))
    }


    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/people"],
        produces = ["application/json"]
    )
    fun list(): ResponseEntity<List<PersonMinusResponseDto>> {
        return ResponseEntity(service.list(), HttpStatus.valueOf(200))
    }
}
