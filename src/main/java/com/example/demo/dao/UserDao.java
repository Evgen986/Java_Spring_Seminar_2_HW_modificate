package com.example.demo.dao;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDao {

    /**
     * Уникальный идентификатор.
     */
    private int id;
    /**
     * Имя пользователя.
     */
    @NotEmpty(message = "Имя пользователя не может быть пустым!")
    @Size(min = 2, max = 255, message = "Имя должно быть длиннее 2 символов и короче 255 символов!")
    private String firstName;
    /**
     * Фамилия пользователя.
     */
    @NotEmpty(message = "Фамилия пользователя не может быть пустой!")
    @Size(min = 2, max = 255, message = "Фамилия должна быть длиннее 2 символов и короче 255 символов!")
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
