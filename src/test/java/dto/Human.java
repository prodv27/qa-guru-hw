package dto;

import java.util.List;

public class Human {
    public String firstName;
    public String lastName;
    public String gender;
    public int age;
    public Address address;
    public List<String> hobbies;

    public static class Address {
        public String streetAddress;
        public String city;
        public String state;
        public String postalCode;
    }
}

