package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class DaoMapperImpl implements iDaoMapper {
    /**
     * Преобразование объекта dao в сущность пользователя.
     *
     * @param userDao объект dao.
     * @return объект сущности пользователя.
     */
    @Override
    public User toEntity(UserDao userDao) {
        User user = new User();
        user.setId(userDao.getId());
        user.setFirstName(userDao.getFirstName());
        user.setLastName(userDao.getLastName());
        return user;
    }

    /**
     * Преобразование сущности пользователя в объект dao.
     *
     * @param user объект пользователя.
     * @return объект dao.
     */
    @Override
    public UserDao toDao(User user) {
        UserDao userDao = new UserDao();
        userDao.setId(user.getId());
        userDao.setFirstName(user.getFirstName());
        userDao.setLastName(user.getLastName());
        return userDao;
    }
}
