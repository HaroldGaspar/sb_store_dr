package pe.isil.service;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.isil.modelEn.Client;
import pe.isil.repository.ClientRepository;
import pe.isil.repository.RoleRepository;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public void createOrUpdate(Client client){
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setRoles(Sets.newHashSet(roleRepository.findById(2L).orElse(null)));
        clientRepository.save(client);
    }

    public void delete(Integer id){
        clientRepository.deleteById(id);
    }

    public Client findById(Integer id){
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
