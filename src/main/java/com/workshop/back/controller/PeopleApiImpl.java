package com.workshop.back.controller;

import com.workshop.back.PeopleApi;
import com.workshop.back.PersonDto;
import com.workshop.back.PersonResponseDto;
import com.workshop.back.service.PeopleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PeopleApiImpl implements PeopleApi {
  @Autowired private PeopleService peopleService;
  Logger logger = LoggerFactory.getLogger(PeopleApiImpl.class);

  /**
   * POST /people : Create a new person Create a new person
   *
   * @param personDto Create a new person (required)
   * @return successful operation (status code 200)
   */
  @Override
  @ApiOperation(
      value = "Create a new person",
      nickname = "create",
      notes = "Create a new person",
      response = PersonResponseDto.class,
      tags = {
        "People actions",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message = "successful operation",
            response = PersonResponseDto.class)
      })
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/people",
      produces = {"application/json"},
      consumes = {"application/json"})
  public ResponseEntity<PersonResponseDto> create(
      @ApiParam(value = "Create a new person", required = true) @Valid @RequestBody
          PersonDto personDto) {
    logger.info("Creating a new person", personDto);
    PersonResponseDto person = this.peopleService.createPerson(personDto);
    return ResponseEntity.ok(person);
  }

  /**
   * GET /people : Get list of person Get list of person
   *
   * @return successful operation (status code 200)
   */
  @Override
  @ApiOperation(
      value = "Get list of person",
      nickname = "list",
      notes = "Get list of person",
      response = PersonResponseDto.class,
      responseContainer = "List",
      tags = {
        "People actions",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message = "successful operation",
            response = PersonResponseDto.class,
            responseContainer = "List")
      })
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/people",
      produces = {"application/json"})
  public ResponseEntity<List<PersonResponseDto>> list() {
    logger.info("Getting list of people");
    List<PersonResponseDto> list = this.peopleService.listPeople();
    return ResponseEntity.ok(list);
  }
}
