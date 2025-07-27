package com.alura.forohub.services;

import com.alura.forohub.entities.AluraUser;
import com.alura.forohub.entities.AluraUserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AluraUserDetailsService implements UserDetailsService
{
    private final AluraUserRepository aluraUserRepository;

    public AluraUserDetailsService(AluraUserRepository aluraUserRepository) {
        this.aluraUserRepository = aluraUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        AluraUser aluraUser = aluraUserRepository.findByEmail(email);

        if (aluraUser == null)
        {
            throw new UsernameNotFoundException("User was not found.");
        }

        return new AluraUserPrincipal(aluraUser);
    }
}
