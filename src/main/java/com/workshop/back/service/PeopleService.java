package com.workshop.back.service;

import com.workshop.back.PersonDto;
import com.workshop.back.PersonResponseDto;
import com.workshop.back.model.Person;
import com.workshop.back.repository.PersonRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

  private enum Classificacao {
    ABAIXO("Abaixo do peso"),
    NORMAL("Peso normal"),
    SOBREPESO("Sobrepeso"),
    GRAUI("Obesidade Grau I"),
    GRAUII("Obesidade Grau II"),
    GRAUIII("Obesidade Grau III");

    public final String value;

    Classificacao(String value) {
      this.value = value;
    }
  }

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
    return weight.divide(height.pow(2), 2, RoundingMode.HALF_UP);
  }

  private String getImcClassification(BigDecimal imcIndex) {
    logger.info("Calculating Imc Classification");
    if (this.isNumberBetween(imcIndex, BigDecimal.valueOf(0), BigDecimal.valueOf(18.4))) {
      return Classificacao.ABAIXO.value;
    } else if (this.isNumberBetween(imcIndex, BigDecimal.valueOf(18.5), BigDecimal.valueOf(24.9))) {
      return Classificacao.NORMAL.value;
    } else if (this.isNumberBetween(imcIndex, BigDecimal.valueOf(25), BigDecimal.valueOf(29.9))) {
      return Classificacao.SOBREPESO.value;
    } else if (this.isNumberBetween(imcIndex, BigDecimal.valueOf(30), BigDecimal.valueOf(34.9))) {
      return Classificacao.GRAUI.value;
    } else if (this.isNumberBetween(imcIndex, BigDecimal.valueOf(35), BigDecimal.valueOf(39.9))) {
      return Classificacao.GRAUII.value;
    } else if (this.isNumberBetween(imcIndex, BigDecimal.valueOf(40), BigDecimal.valueOf(10000))) {
      return Classificacao.GRAUII.value;
    }
    return "CLASSIFICAÇÃO A CALCULAR";
  }

  private double bigDecimalToDouble(BigDecimal bigDecimal) {
    return bigDecimal.doubleValue();
  }

  private BigDecimal doubleToBigDecimal(double dbl) {
    return new BigDecimal(dbl);
  }

  private boolean isNumberBetween(
      BigDecimal number, BigDecimal bigDecimal1, BigDecimal bigDecimal2) {
    return number.compareTo(bigDecimal1) >= 0 && number.compareTo(bigDecimal2) <= 0;
  }
}
