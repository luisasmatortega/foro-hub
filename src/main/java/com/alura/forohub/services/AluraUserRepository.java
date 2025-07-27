package com.alura.forohub.services;


import com.alura.forohub.entities.AluraUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluraUserRepository extends JpaRepository<AluraUser, Long>
{
    AluraUser findByEmail(String email);

    boolean existsByEmail(String email);
}
