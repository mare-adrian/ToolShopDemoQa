package com.oveit.utils;

import com.github.javafaker.Faker;

public class DataGeneration {

    private static DataGeneration instance = null;
    public String firstName;
    public String lastName;
    public String address;
    public String postCode;
    public String city;
    public String state;
    public int country;
    public String phone;
    public String email;
    public String password;
    private final Faker faker = new Faker();

    private DataGeneration() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        address = faker.address().fullAddress();
        postCode = faker.address().zipCode();
        city = faker.address().cityName();
        state = faker.address().state();
        country = faker.number().numberBetween(0, 30);
        phone = faker.number().digits(10);
        email = firstName + "." + lastName + "@mailinator.com";
        password = "Testington123!";
    }

    public static DataGeneration getInstance() {
        if (instance == null) {
            instance = new DataGeneration();
        }
        return instance;
    }
}
