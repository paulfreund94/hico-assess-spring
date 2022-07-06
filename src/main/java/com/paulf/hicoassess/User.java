package com.paulf.hicoassess;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

enum Salutation {
  DR, MR, MS, MRS, MX;
}

enum Gender {
  M, F, U
}

enum Color {
  GREEN, BLUE, RED, DEFAULT;
}

@Document(collection = "users")
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
    if (!isAlphabetical(firstName))
      throw new Exception("Only alphabetical names.");
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) throws Exception {
    if (!isAlphabetical(lastName))
      throw new Exception("Only alphabetical names.");
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

  public void setSalution(Salutation salutation) throws Exception {
    if (invalidGenderAndSalutation(gender, salutation))
      throw new Exception("Salution for gender!");
    this.salutation = salutation;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) throws Exception {
    if (invalidGenderAndSalutation(gender, salutation))
      throw new Exception("Salution for gender!");
    this.gender = gender;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  private boolean invalidGenderAndSalutation(Gender gender, Salutation salutation) {
    return gender == Gender.M && salutation != Salutation.MR
        || gender == Gender.F && salutation != Salutation.MS && salutation != Salutation.MRS
        || gender == Gender.U && salutation != Salutation.MX;
  }

  private boolean isAlphabetical(String s) {
    if (s == null) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && c != ' ') {
        return false;
      }
    }
    return true;
  }
}
