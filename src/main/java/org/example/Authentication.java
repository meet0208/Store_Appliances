package org.example;
/**
 * The {@code Authentication} class provides a method to check if a given password
 * matches the predefined password.
 *
 * <p>This class contains a final static private password and a static method to
 * verify if the entered password is incorrect.</p>
 *
 * @author Meet Boghani
 * @author Nishithkumar Soni
 * @version 1.0
 */
public class Authentication {
    /**
     * The predefined password for authentication.
     */
    final static private String password = "c6481";
    /**
     * Checks whether the given password is incorrect.
     *
     * @param pass the password to be checked
     * @return {@code true} if the password does not match the predefined password,
     *         {@code false} otherwise
     */
    public static boolean passwordChecker(String pass){
        return !pass.equals(password);
    }
}