package com.example.demo.dao;

import com.example.demo.model.User;

public interface iDaoMapper {
    /**
     * Преобразование dao в сущность.
     *
     * @param userDao объект dao.
     * @return сущность пользователя.
     */
    User toEntity(UserDao userDao);

    /**
     * Преобразование сущности в dao.
     *
     * @param user объект пользователя.
     * @return dao пользователя.
     */
    UserDao toDao(User user);
}
