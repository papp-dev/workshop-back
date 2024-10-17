package com.workshop.back;

import com.workshop.back.model.Person;
import com.workshop.back.repository.PersonRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
  @Autowired private PersonRepository personRepository;

  public PersonResponseDto createPerson(PersonDto personDto) {
    Person createdPerson =
        this.personRepository.save(
            new Person("", personDto.getName(), personDto.getWeight(), personDto.getHeight()));
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
    return BigDecimal.ZERO;
  }

  private String getImcClassification(BigDecimal imcIndex) {
    return "CLASSIFICAÇÃO A CALCULAR";
  }
}
