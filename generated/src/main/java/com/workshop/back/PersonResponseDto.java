package com.workshop.back;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** Object for person */
@ApiModel(description = "Object for person")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-17T10:46:13.356676-03:00[America/Sao_Paulo]")
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class PersonResponseDto {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("weight")
  private BigDecimal weight;

  @JsonProperty("height")
  private BigDecimal height;

  @JsonProperty("imcIndex")
  private BigDecimal imcIndex;

  @JsonProperty("imcClassification")
  private String imcClassification;

  public PersonResponseDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "e043186e-871c-4146-886f-474a7660876e", value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PersonResponseDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   *
   * @return name
   */
  @ApiModelProperty(example = "Paulo", value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PersonResponseDto weight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

  /**
   * weight in kilos
   *
   * @return weight
   */
  @ApiModelProperty(example = "60", value = "weight in kilos")
  @Valid
  public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public PersonResponseDto height(BigDecimal height) {
    this.height = height;
    return this;
  }

  /**
   * height in meters
   *
   * @return height
   */
  @ApiModelProperty(example = "1.75", value = "height in meters")
  @Valid
  public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(BigDecimal height) {
    this.height = height;
  }

  public PersonResponseDto imcIndex(BigDecimal imcIndex) {
    this.imcIndex = imcIndex;
    return this;
  }

  /**
   * imc index
   *
   * @return imcIndex
   */
  @ApiModelProperty(example = "18.0", value = "imc index")
  @Valid
  public BigDecimal getImcIndex() {
    return imcIndex;
  }

  public void setImcIndex(BigDecimal imcIndex) {
    this.imcIndex = imcIndex;
  }

  public PersonResponseDto imcClassification(String imcClassification) {
    this.imcClassification = imcClassification;
    return this;
  }

  /**
   * imc classification
   *
   * @return imcClassification
   */
  @ApiModelProperty(example = "Under ideal weight", value = "imc classification")
  public String getImcClassification() {
    return imcClassification;
  }

  public void setImcClassification(String imcClassification) {
    this.imcClassification = imcClassification;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonResponseDto personResponse = (PersonResponseDto) o;
    return Objects.equals(this.id, personResponse.id)
        && Objects.equals(this.name, personResponse.name)
        && Objects.equals(this.weight, personResponse.weight)
        && Objects.equals(this.height, personResponse.height)
        && Objects.equals(this.imcIndex, personResponse.imcIndex)
        && Objects.equals(this.imcClassification, personResponse.imcClassification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, weight, height, imcIndex, imcClassification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonResponseDto {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    imcIndex: ").append(toIndentedString(imcIndex)).append("\n");
    sb.append("    imcClassification: ").append(toIndentedString(imcClassification)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
