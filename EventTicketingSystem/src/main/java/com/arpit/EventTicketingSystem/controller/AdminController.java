package com.arpit.EventTicketingSystem.controller;

import com.arpit.EventTicketingSystem.dto.AdminDto;
import com.arpit.EventTicketingSystem.entities.Admin;
import com.arpit.EventTicketingSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/")
    public Admin addAdmin(@RequestBody AdminDto adminDto) {
        return adminService.addAdmin(adminDto);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody AdminDto adminDto) {
        return adminService.updateAdmin(id, adminDto);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id);
    }

}
