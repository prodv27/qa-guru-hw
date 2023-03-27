package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerData {

    public static Faker faker = new Faker(new Locale("en"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            userSubject = faker.options().option("Computer Science", "English", "Physics"),
            userHobbies = faker.options().option("Sports", "Reading", "Music"),
            userFile = "image.jpg",
            userAddress = faker.address().fullAddress(),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = faker.options().option("January", "February", "March",
                    "April", "May", "June", "July", "August",
                    "September", "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1990, 2023)),
            userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            userCity = city();


    public static String city() {
        if (userState.equals("NCR")) {
            String city = faker.options().option("Delhi", "Gurgaon", "Noida");
            return city;
        }
        else if (userState.equals("Uttar Pradesh")) {
            String city = faker.options().option("Agra", "Lucknow", "Merrut");
            return city;
        }
        else if (userState.equals("Haryana")) {
            String city = faker.options().option("Karnal", "Panipat");
            return city;
        }
        else if (userState.equals("Rajasthan")) {
            String city = faker.options().option("Jaipur", "Jaiselmer");
            return city;
        }

        return null;
    }

}
