package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;

public class CommonPasswordChecker {

    private final Set<String> commonPasswords = new HashSet<>();

    public CommonPasswordChecker() {
        commonPasswords.add("1234567");
        commonPasswords.add("qwerty");
        commonPasswords.add("abcdef");
    }

    public boolean checkCommonPassword(String password) {
        return commonPasswords.contains(password);
    }
}

