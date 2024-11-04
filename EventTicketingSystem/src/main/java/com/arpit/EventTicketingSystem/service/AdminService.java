package com.arpit.EventTicketingSystem.service;

import com.arpit.EventTicketingSystem.dto.AdminDto;
import com.arpit.EventTicketingSystem.entities.Admin;
import com.arpit.EventTicketingSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository ar;

    public List<Admin> getAdmins() {
        return ar.findAll();
    }

    public Admin getAdminById(Long id) {
        return ar.findById(id).orElse(null);
    }

    public Admin addAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setName(adminDto.getName());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        admin.setPhone(adminDto.getPhone());
        return ar.save(admin);
    }

    public Admin updateAdmin(Long id, AdminDto adminDto) {
        Optional<Admin> optionalAdmin = ar.findById(id);
        if(optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            admin.setName(adminDto.getName());
            admin.setEmail(adminDto.getEmail());
            admin.setPassword(adminDto.getPassword());
            admin.setPhone(adminDto.getPhone());
            return ar.save(admin);
        }
        else{
            return null;
        }

    }


    public String deleteAdmin(Long id) {
        Optional<Admin> op = ar.findById(id);
        if(op.isPresent()) {
            ar.delete(op.get());
            return "Admin Deleted Successfully";
        }
        else{
            return "Admin Not Found";
        }
    }
}
