package com.workshop.back.service;

import com.workshop.back.PersonDto;
import com.workshop.back.PersonResponseDto;
import com.workshop.back.model.Person;
import com.workshop.back.repository.PersonRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
  @Autowired private PersonRepository personRepository;
  Logger logger = LoggerFactory.getLogger(PeopleService.class);

  public PersonResponseDto createPerson(PersonDto personDto) {
    Person createdPerson =
        this.personRepository.save(
            new Person(
                UUID.randomUUID().toString(),
                personDto.getName(),
                personDto.getWeight(),
                personDto.getHeight()));
    BigDecimal imcIndex = this.getImcIndex(createdPerson.getWeight(), createdPerson.getHeight());
    String imcClassification = this.getImcClassification(imcIndex);
    return PersonResponseDto.builder()
        .id(createdPerson.getResourceId())
        .name(createdPerson.getName())
        .weight(createdPerson.getWeight())
        .height(createdPerson.getHeight())
        .imcIndex(imcIndex)
        .imcClassification(imcClassification)
        .build();
  }

  public List<PersonResponseDto> listPeople() {
    List<Person> people = this.personRepository.findAll();
    return people.stream()
        .map(
            person -> {
              BigDecimal imcIndex = this.getImcIndex(person.getWeight(), person.getHeight());
              String imcClassification = this.getImcClassification(imcIndex);
              return PersonResponseDto.builder()
                  .id(person.getResourceId())
                  .name(person.getName())
                  .weight(person.getWeight())
                  .height(person.getHeight())
                  .imcIndex(imcIndex)
                  .imcClassification(imcClassification)
                  .build();
            })
        .toList();
  }

  private BigDecimal getImcIndex(BigDecimal weight, BigDecimal height) {
    logger.info("Calculating Imc Index");
    return BigDecimal.ZERO;
  }

  private String getImcClassification(BigDecimal imcIndex) {
    logger.info("Calculating Imc Classification");
    return "CLASSIFICAÇÃO A CALCULAR";
  }
}
