package com.paulf.hicoassess;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.paulf.hicoassess.enums.Color;
import com.paulf.hicoassess.enums.Gender;
import com.paulf.hicoassess.enums.Salutation;
import com.paulf.hicoassess.validators.UserFieldsValid;

import javax.validation.constraints.NotNull;

@Document(collection = "users")
@UserFieldsValid
public class User {

  @Id
  private String id;

  @NotNull
  private String firstName;
  @NotNull
  private String lastName;

  @Indexed(unique = true)
  private int employeeId;

  private int grossSalary;

  @NotNull
  private Salutation salutation;
  @NotNull
  private Gender gender;

  @NotNull
  private Color color;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) throws Exception {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) throws Exception {
    this.lastName = lastName;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public int getGrossSalary() {
    return grossSalary;
  }

  public void setGrossSalary(int grossSalary) {
    this.grossSalary = grossSalary;
  }

  public Salutation getSalutation() {
    return salutation;
  }

  public void setSalution(Salutation salutation) {
    this.salutation = salutation;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

}
