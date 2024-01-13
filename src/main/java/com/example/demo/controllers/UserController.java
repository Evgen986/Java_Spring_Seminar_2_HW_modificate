package com.example.demo.controllers;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.iDaoMapper;
import com.example.demo.model.User;
import com.example.demo.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер пользователей.
 */
@Controller
public class UserController {
    /**
     * Объект сервиса для работы с пользователями.
     */
    private final iUserService userService;

    private final iDaoMapper daoMapper;

    /**
     * Конструктор класса.
     *
     * @param userService сервис пользователей.
     * @param daoMapper   сервис преобразования сущностей в dao и наоборот.
     */
    @Autowired
    public UserController(iUserService userService,
                          iDaoMapper daoMapper) {
        this.userService = userService;
        this.daoMapper = daoMapper;

    }

    /**
     * Получение всех пользователей.
     *
     * @param model модель для передачи данных в представление.
     * @return представление со списком пользователей.
     */
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        List<UserDao> usersDao = users.stream()
                .map(daoMapper::toDao).collect(Collectors.toList());

        model.addAttribute("users", usersDao);
        return "user-list";
    }

    /**
     * Создание нового пользователя.
     *
     * @param model модель для передачи данных в представление.
     * @return страницу представления для создания пользователя.
     */
    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        UserDao userDao = new UserDao();
        model.addAttribute("user", userDao);
        return "user-create";
    }

    /**
     * Получение данных о новом пользователе с формы представления.
     *
     * @param userDao       объект dao пользователя.
     * @param bindingResult объект хранящий результат валидации userDao.
     * @return при успешной валидации список пользователей,
     * иначе возврат на страницу создания пользователя.
     */
    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") @Validated UserDao userDao,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-create";
        } else {
            User user = daoMapper.toEntity(userDao);
            userService.saveUser(user);
            return "redirect:/users";
        }
    }

    /**
     * Удаление пользователя.
     *
     * @param id уникальный идентификатор пользователя.
     * @return перенаправление на страницу со списком пользователей.
     */
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    /**
     * Изменение данных пользователя.
     *
     * @param id    уникальный идентификатор пользователя.
     * @param model модель для передачи данных в представление.
     * @return представление для изменения данных.
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", daoMapper.toDao(user));
        return "user-update";
    }

    /**
     * Получение данных об измененном пользователя с формы представления.
     *
     * @param userDao       объект dao с измененными данными.
     * @param bindingResult объект хранящий результат валидации userDao.
     * @return при успешной валидации список пользователей,
     * иначе возврат на страницу изменения пользователя.
     */
    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") @Valid UserDao userDao,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-update";
        } else {
            userService.updateUser(daoMapper.toEntity(userDao));
            return "redirect:/users";
        }
    }
}
