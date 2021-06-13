package ex27;

/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nyles Symonette
 */


import java.util.ArrayList;
import java.util.Scanner;

public class App {


    // validaiton per CharLength,zip,filled,and ID.
    // make sure to return errors
    public static ArrayList<String> validateCharacterLength(String entry, String label, ArrayList<String> errors) {
        if (entry.length() < 2) {
            errors.add("The " + label + " must be at least 2 characters long.");
        }

        return errors;
    }

    public static ArrayList<String> validateFilled(String entry, String label, ArrayList<String> errors) {
        if (entry.isEmpty()) {
            errors.add("The " + label + " must be filled in.");
        }
        return errors;
    }

    public static ArrayList<String> validateZipCode(String entry, String label, ArrayList<String> errors) {
        if (!entry.matches("[0-9]+") || entry.length() != 5) {
            errors.add("The " + label + " must be a 5 digit number.");
        }
        return errors;
    }

    public static ArrayList<String> validateEmployeeID(String entry, String label, ArrayList<String> errors) {
        if (!entry.matches("[a-zA-Z]{2}-[0-9]{4}")) {
            errors.add("The " + label + " must be in the format of AA-1234.");
        }
        return errors;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // add string-print relationship per question

        System.out.print("Enter the first name: ");
        String firstName = inputScanner.nextLine();
        System.out.print("Enter the second name: ");
        String secondName = inputScanner.nextLine();
        System.out.print("Enter the ZIP code: ");
        String zipCode = inputScanner.nextLine();
        System.out.print("Etner the employee ID: ");
        String employeeID = inputScanner.nextLine();

        ArrayList<String> errors = new ArrayList<>();
        validateCharacterLength(firstName, "first name", errors);
        validateCharacterLength(secondName, "second name", errors);
        validateFilled(firstName, "first name", errors);
        validateFilled(secondName, "second name", errors);
        validateEmployeeID(employeeID, "employee ID", errors);
        validateZipCode(zipCode, "zipcode", errors);

        if (errors.isEmpty()) {
            System.out.println("There were no errors found.");
        }
        for (String error : errors) {
            System.out.println(error);
        }

        inputScanner.close();
    }
}
