package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@DisplayName("Test method of CommonPasswordChecker class")
class CommonPasswordCheckerTest {

    @DisplayName("Set contain password")
    @ParameterizedTest
    @MethodSource("common_passwords")
    void set_contain_password(String password) {
        CommonPasswordChecker commonPasswordChecker = new CommonPasswordChecker();
        assertTrue(commonPasswordChecker.checkCommonPassword(password));
    }

    public static List<Arguments> common_passwords() {
        return List.of(
          Arguments.of("1234567"),
          Arguments.of("qwerty"),
          Arguments.of("abcdef")
        );
    }
}