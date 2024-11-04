package com.arpit.EventTicketingSystem.controller;

import com.arpit.EventTicketingSystem.dto.UsersDto;
import com.arpit.EventTicketingSystem.entities.Users;
import com.arpit.EventTicketingSystem.repository.UsersRepository;
import com.arpit.EventTicketingSystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    public List<Users> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    @PostMapping("/")
    public Users addUser(@RequestBody UsersDto usersDto) {
        return usersService.addUser(usersDto);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody UsersDto usersDto) {
        return usersService.updateUser(id, usersDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return usersService.deleteUser(id);
    }

}
