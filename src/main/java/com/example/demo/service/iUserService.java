package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface iUserService {

    User getUserById(Integer id);

    /**
     * Получение списка всех пользователей.
     *
     * @return список пользователей.
     */
    List<User> findAll();

    /**
     * Создание нового пользователя.
     *
     * @param user объект пользователя.
     * @return объект пользователя с присвоенным id.
     */
    User saveUser(User user);

    /**
     * Удаление пользователя.
     *
     * @param id уникальный идентификатор пользователя.
     */
    void deleteById(int id);

    /**
     * Изменение данных пользователя.
     *
     * @param user объект пользователя с новыми данными.
     */
    void updateUser(User user);
}
