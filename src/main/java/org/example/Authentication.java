package org.example;

public class Authentication {
    final static private String password = "c6481";
    public static boolean passwordChecker(String pass){
        return !pass.equals(password);
    }
}
