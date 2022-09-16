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
    void all_tests_passed() {
        assertTrue(passwordValidator.checkPassword("1122@aBc"));
    }

    @DisplayName("Password not null is valid")
    @Test
    void password_not_null_is_valid() {
        assertTrue(passwordValidator.checkPasswordNull("12345"));
    }

    @DisplayName("Password null is invalid")
    @Test
    void password_null_is_invalid() {
        assertFalse(passwordValidator.checkPasswordNull(null));
    }

    @DisplayName("Password length more then eight is valid")
    @Test
    void password_length_more_then_eight_is_valid() {
        assertTrue(passwordValidator.checkPasswordLength("12345678"));
    }

    @DisplayName("Password length less then eight is invalid")
    @Test
    void password_length_less_then_eight_is_invalid() {
        assertFalse(passwordValidator.checkPasswordLength("1234567"));
    }

    @DisplayName("Password length less then twenty five is valid")
    @Test
    void password_length_less_then_twenty_five_is_valid() {
        assertTrue(passwordValidator.checkPasswordLength("1234567890123456789012345"));
    }

    @DisplayName("Password length more then twenty five is invalid")
    @Test
    void password_length_more_then_twenty_five_is_invalid() {
        assertFalse(passwordValidator.checkPasswordLength("12345678901234567890123456"));
    }

    @DisplayName("Alternating case in password is valid")
    @Test
    void alternating_case_in_password_is_valid() {
        assertTrue(passwordValidator.checkPasswordUpperLowerCase("AbCdEf"));
    }

    @DisplayName("All lower case in password is invalid")
    @Test
    void all_lower_case_in_password_is_invalid() {
        assertFalse(passwordValidator.checkPasswordUpperLowerCase("abcdef"));
    }

    @DisplayName("All upper case in password is invalid")
    @Test
    void all_upper_case_in_password_is_invalid() {
        assertFalse(passwordValidator.checkPasswordUpperLowerCase("ABCDEF"));
    }

    @DisplayName("Password has number is valid")
    @Test
    void password_has_number_is_valid() {
        assertTrue(passwordValidator.checkPasswordHasNumber("1abcdef"));
    }

    @DisplayName("Password has not number is invalid")
    @Test
    void password_has_not_number_is_invalid() {
        assertFalse(passwordValidator.checkPasswordHasNumber("abcdef"));
    }

    @DisplayName("Password has special character is valid")
    @Test
    void password_has_special_character_is_valid() {
        assertTrue(passwordValidator.checkPasswordSpecialCharacter("@abcdef"));
    }

    @DisplayName("Password has not special character is invalid")
    @Test
    void password_has_not_special_character_is_invalid() {
        assertFalse(passwordValidator.checkPasswordSpecialCharacter("abcdef"));
    }

    @DisplayName("Password has not continuous numbers is valid")
    @Test
    void password_has_not_continuous_numbers_is_valid() {
        assertTrue(passwordValidator.checkPasswordContinuousNumbers("13579"));
    }

    @DisplayName("Password has continuous numbers is invalid")
    @Test
    void password_has_continuous_numbers_is_invalid() {
        assertFalse(passwordValidator.checkPasswordContinuousNumbers("12345"));
    }

    @DisplayName("Password has not same numbers is valid")
    @Test
    void password_has_not_same_numbers_is_valid() {
        assertTrue(passwordValidator.checkPasswordSameNumber("111222"));
    }

    @DisplayName("Password has same numbers is invalid")
    @Test
    void password_has_same_numbers_is_invalid() {
        assertFalse(passwordValidator.checkPasswordSameNumber("11112222"));
    }
}