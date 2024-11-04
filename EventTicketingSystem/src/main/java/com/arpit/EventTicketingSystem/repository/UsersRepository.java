package com.arpit.EventTicketingSystem.repository;

import com.arpit.EventTicketingSystem.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
