package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.isil.modelEn.Client;
import pe.isil.repository.ClientRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ClientDetailsService implements UserDetailsService {
//Especificar de donde se sacara los usuarios y roles
    @Autowired
    private ClientRepository clientRepository;

    //@Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUser(username);//ahora debemos devolver un UserDetails

        if(client == null){
            throw new UsernameNotFoundException(username);
        }
        //busca y asigna sus roles
//        Set<GrantedAuthority> roles = new HashSet<>();
//        client.getRoles().forEach(r -> {
//            roles.add(new SimpleGrantedAuthority(r.getName()));
//        });

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        //requiere los roles
        UserDetails userDetails = new User(client.getUser(),client.getPassword(),roles);
        System.out.println(userDetails);
        return userDetails;
    }
}
