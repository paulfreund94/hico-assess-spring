package com.paulf.hicoassess.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.paulf.hicoassess.enums.Gender;
import com.paulf.hicoassess.enums.Salutation;
import com.paulf.hicoassess.User;

public class UserFieldValidValidator implements ConstraintValidator<UserFieldsValid, User> {

  @Override
  public boolean isValid(User value, ConstraintValidatorContext context) {
    Gender gender = value.getGender();
    Salutation salutation = value.getSalutation();

    boolean genderAndSalutionValid = (salutation == Salutation.DR)
        || (gender == Gender.M && salutation == Salutation.MR)
        || (gender == Gender.F && (salutation == Salutation.MRS || salutation == Salutation.MS))
        || gender == Gender.U && salutation == Salutation.MX;

    return genderAndSalutionValid && isAlphabetical(value.getFirstName()) && isAlphabetical(value.getLastName());
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
