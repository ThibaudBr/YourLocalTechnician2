package org.architectureLogiciel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class UserValidationTests {

    @Test
    @DisplayName("should return an error because email and password are empty")
    void userHasNullPasswordAndEmail() {
        //TODO
    }

    @Test
    @DisplayName("should return an error because email is empty")
    void userHasNullEmail() {
        //TODO
    }

    @Test
    @DisplayName("should return an error because email has no domain")
    void userHasANEmailWithNoDomain() {
        //TODO
    }

    @Test
    @DisplayName("should return an error because password haven't got an 7 length")
    void userHasAPasswordWithALengthLessThan7Characters() {
        //TODO
    }

    @Test
    @DisplayName("should return an error because password has a length superior than 21 characters")
    void userHasAPasswordWithALengthSuperiorThan21Characters() {
        //TODO
    }

    @Test
    @DisplayName("should return an error because password has No Uppercase")
    void userHasAPasswordWithNoUppercase() {
        //TODO
    }

    @Test
    @DisplayName("should return an error because password has No Lowercase")
    void userHasAPasswordWithNoLowercase() {
        //TODO
    }

    @Test
    @DisplayName("should return an error because password has No Number")
    void userHasAPasswordWithNoNumber() {
        //TODO
    }

    @Test
    @DisplayName("should return an error because password has No special charracters")
    void userHasAPasswordWithNoSpecialCharacters() {
        //TODO
    }

    @Test
    @DisplayName("should match the password because user have at least one Number, one LowerCase, one Uppercase, one specialCharacters")
    void userHasAValidEmailAndPassword() {
        //TODO
    }

    @Test
    @DisplayName("should match every special characters defined")
    void userHasAValidEmailAndPasswordWithSpecialCharacters() {
        //TODO
    }
}
