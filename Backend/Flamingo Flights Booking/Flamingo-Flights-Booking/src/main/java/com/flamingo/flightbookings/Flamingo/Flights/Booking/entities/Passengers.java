package com.flamingo.flightbookings.Flamingo.Flights.Booking.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Passengers")
public class Passengers
{
    @Id
    private int passengerId;
    private String name;
    private int age;
    private String phone;
    private String email;

    public Passengers() {
    }

    public Passengers(int passengerId, String name, int age, String phone, String email) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "passengerId=" + passengerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
