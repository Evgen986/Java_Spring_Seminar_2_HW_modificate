package com.example.demo.repositories;

import com.example.demo.model.User;

import java.util.List;

public interface iUserRepository {

    User findUserById(Integer id);

    /**
     * Получение всех пользователей из БД.
     *
     * @return список пользователей.
     */
    List<User> findAll();

    /**
     * Сохранение пользователя в БД.
     *
     * @param user объект пользователя.
     * @return объект пользователя с id.
     */
    User save(User user);

    /**
     * Удаление пользователя из БД
     * по уникальному идентификатору.
     *
     * @param id идентификатор пользователя.
     */
    void deleteById(int id);


    /**
     * Обновление пользователя в БД.
     *
     * @param user объект пользователя с измененными данными.
     */
    void update(User user);
}
