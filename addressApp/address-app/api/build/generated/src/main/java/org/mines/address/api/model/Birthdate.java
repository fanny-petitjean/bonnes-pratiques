package org.mines.address.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Birthdate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-16T16:41:38.192651400+02:00[Europe/Paris]")
public class Birthdate {

  private String id;

  private Integer day;

  private Integer month;

  private Integer year;

  public Birthdate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Birthdate(String id, Integer day, Integer month, Integer year) {
    this.id = id;
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public Birthdate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Birthdate day(Integer day) {
    this.day = day;
    return this;
  }

  /**
   * Get day
   * @return day
  */
  @NotNull 
  @Schema(name = "day", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("day")
  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public Birthdate month(Integer month) {
    this.month = month;
    return this;
  }

  /**
   * Get month
   * @return month
  */
  @NotNull 
  @Schema(name = "month", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("month")
  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public Birthdate year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
  */
  @NotNull 
  @Schema(name = "year", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("year")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Birthdate birthdate = (Birthdate) o;
    return Objects.equals(this.id, birthdate.id) &&
        Objects.equals(this.day, birthdate.day) &&
        Objects.equals(this.month, birthdate.month) &&
        Objects.equals(this.year, birthdate.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, day, month, year);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Birthdate {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

