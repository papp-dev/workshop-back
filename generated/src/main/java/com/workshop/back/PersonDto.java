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
public class PersonDto {
  @JsonProperty("name")
  private String name;

  @JsonProperty("weight")
  private BigDecimal weight;

  @JsonProperty("height")
  private BigDecimal height;

  public PersonDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   *
   * @return name
   */
  @ApiModelProperty(example = "Paulo", required = true, value = "")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PersonDto weight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

  /**
   * weight in kilos
   *
   * @return weight
   */
  @ApiModelProperty(example = "60", required = true, value = "weight in kilos")
  @NotNull
  @Valid
  public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public PersonDto height(BigDecimal height) {
    this.height = height;
    return this;
  }

  /**
   * height in meters
   *
   * @return height
   */
  @ApiModelProperty(example = "1.75", required = true, value = "height in meters")
  @NotNull
  @Valid
  public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(BigDecimal height) {
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonDto person = (PersonDto) o;
    return Objects.equals(this.name, person.name)
        && Objects.equals(this.weight, person.weight)
        && Objects.equals(this.height, person.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, weight, height);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonDto {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
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
