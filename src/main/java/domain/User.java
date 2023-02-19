package domain;

import com.github.javafaker.Faker;

public class User {

    private final String userName;
    private final String userEmail;
    private final String userPassword;

    private User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public static User getRandomUser() {
        Faker faker = new Faker();
        return new User(faker.name().username(), faker.internet().emailAddress(), faker.internet().password(6, 7));
    }

    public static User getRandomUserWithIncorrectPassword() {
        Faker faker = new Faker();
        return new User(faker.name().username(), faker.internet().emailAddress(), faker.internet().password(4, 5));
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}