package com.arpit.EventTicketingSystem.service;

import com.arpit.EventTicketingSystem.dto.UsersDto;
import com.arpit.EventTicketingSystem.entities.Users;
import com.arpit.EventTicketingSystem.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository ur;

    public List<Users> getUsers() {
        return ur.findAll();
    }

    public Users getUserById(Long id) {
        return ur.findById(id).orElse(null);
    }

    public Users addUser(UsersDto usersDto) {
        Users users = new Users();
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        users.setPhone(usersDto.getPhone());
        return ur.save(users);
    }

    public Users updateUser(Long id, UsersDto usersDto) {
        Optional<Users> optionalUsers = ur.findById(id);
        if(optionalUsers.isPresent()) {
            Users users = optionalUsers.get();
            users.setName(usersDto.getName());
            users.setEmail(usersDto.getEmail());
            users.setPassword(usersDto.getPassword());
            users.setPhone(usersDto.getPhone());
            return ur.save(users);
        }
        else{
            return null;
        }

    }


    public String deleteUser(Long id) {
        Optional<Users> op = ur.findById(id);
        if(op.isPresent()) {
            ur.delete(op.get());
            return "User Deleted Successfully";
        }
        else{
            return "User Not Found";
        }
    }
}
