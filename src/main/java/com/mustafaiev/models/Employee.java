package com.mustafaiev.models;

public class Employee {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    public Employee(final int id, final String firstName, final String lastName, final String email, final String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
