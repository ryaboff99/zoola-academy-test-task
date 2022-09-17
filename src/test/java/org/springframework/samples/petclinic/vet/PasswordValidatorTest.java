package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@DisplayName("Test all methods of PasswordValidator class")
class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    void prepare() {
        passwordValidator = new PasswordValidator(mock(CommonPasswordChecker.class));
    }

    @DisplayName("All tests passed")
    @Test
    void allTestsPassed() {
        assertTrue(passwordValidator.checkPassword("1122@aBc"));
    }

    @DisplayName("Password not null is valid")
    @Test
    void passwordNotNullIsValid() {
        assertTrue(passwordValidator.checkPasswordNull("12345"));
    }

    @DisplayName("Password null is invalid")
    @Test
    void passwordNullIsInvalid() {
        assertFalse(passwordValidator.checkPasswordNull(null));
    }

    @DisplayName("Password length more then eight is valid")
    @Test
    void passwordLengthMoreThenEightIsValid() {
        assertTrue(passwordValidator.checkPasswordLength("12345678"));
    }

    @DisplayName("Password length less then eight is invalid")
    @Test
    void passwordLengthLessThenEightIsInvalid() {
        assertFalse(passwordValidator.checkPasswordLength("1234567"));
    }

    @DisplayName("Password length less then twenty five is valid")
    @Test
    void passwordLengthLessThenTwentyFiveIsValid() {
        assertTrue(passwordValidator.checkPasswordLength("1234567890123456789012345"));
    }

    @DisplayName("Password length more then twenty five is invalid")
    @Test
    void passwordLengthMoreThenTwentyFiveIsInvalid() {
        assertFalse(passwordValidator.checkPasswordLength("12345678901234567890123456"));
    }

    @DisplayName("Alternating case in password is valid")
    @Test
    void alternatingCaseInPasswordIsValid() {
        assertTrue(passwordValidator.checkPasswordUpperLowerCase("AbCdEf"));
    }

    @DisplayName("All lower case in password is invalid")
    @Test
    void allLowerCaseInPasswordIsInvalid() {
        assertFalse(passwordValidator.checkPasswordUpperLowerCase("abcdef"));
    }

    @DisplayName("All upper case in password is invalid")
    @Test
    void allUpperCaseInPasswordIsInvalid() {
        assertFalse(passwordValidator.checkPasswordUpperLowerCase("ABCDEF"));
    }

    @DisplayName("Password has number is valid")
    @Test
    void passwordHasNumberIsValid() {
        assertTrue(passwordValidator.checkPasswordHasNumber("1abcdef"));
    }

    @DisplayName("Password has not number is invalid")
    @Test
    void passwordHasNotNumberIsInvalid() {
        assertFalse(passwordValidator.checkPasswordHasNumber("abcdef"));
    }

    @DisplayName("Password has special character is valid")
    @Test
    void passwordHasSpecialCharacterIsValid() {
        assertTrue(passwordValidator.checkPasswordSpecialCharacter("@abcdef"));
    }

    @DisplayName("Password has not special character is invalid")
    @Test
    void passwordHasNotSpecialCharacterIsInvalid() {
        assertFalse(passwordValidator.checkPasswordSpecialCharacter("abcdef"));
    }

    @DisplayName("Password has not continuous numbers is valid")
    @Test
    void passwordHasNotContinuousNumbersIsValid() {
        assertTrue(passwordValidator.checkPasswordContinuousNumbers("13579"));
    }

    @DisplayName("Password has continuous numbers is invalid")
    @Test
    void passwordHasContinuousNumbersIsInvalid() {
        assertFalse(passwordValidator.checkPasswordContinuousNumbers("12345"));
    }

    @DisplayName("Password has not same numbers is valid")
    @Test
    void passwordHasNotSameNumbersIsValid() {
        assertTrue(passwordValidator.checkPasswordSameNumber("111222"));
    }

    @DisplayName("Password has same numbers is invalid")
    @Test
    void passwordHasSameNumbersIsInvalid() {
        assertFalse(passwordValidator.checkPasswordSameNumber("11112222"));
    }
}