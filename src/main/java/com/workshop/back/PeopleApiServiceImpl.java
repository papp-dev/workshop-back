package com.workshop.back;

import com.workshop.back.controller.PeopleApiService;
import com.workshop.back.model.PersonDto;
import com.workshop.back.model.PersonMinusResponseDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleApiServiceImpl implements PeopleApiService {
  @Autowired private PeopleService peopleService;

  @Override
  public PersonMinusResponseDto create(PersonDto personDto) {
    return this.peopleService.createPerson(personDto);
  }

  @Override
  public List<PersonMinusResponseDto> list() {
    return this.peopleService.listPeople();
  }
}
