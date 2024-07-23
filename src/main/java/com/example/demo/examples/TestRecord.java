package com.example.demo.examples;

public record TestRecord (int id, String firstName, String lastName) {

    static int empToken;

    // Compact Constructor
    public TestRecord {
        if (id < 100) {
            throw new IllegalArgumentException("Employee Id cannot be below 100.");
        }
        if (firstName.length() < 2) {
            throw new IllegalArgumentException("First name must be 2 characters or more.");
        }
    }


    // Alternative Constructor
    public TestRecord(int id, String firstName) {
        this(id, firstName, null);
    }

    // Instance methods
    public void getFullName() {
        if (lastName == null)
            System.out.println(firstName());
        else
            System.out.println(firstName() + " "
                    + lastName());
    }

    // Static methods
    public static int generateEmployeeToken() {
        return ++empToken;
    }
}