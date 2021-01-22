package pe.isil.modelEs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.isil.modelEn.Client;
import pe.isil.repository.ClientRepository;


@SpringBootTest
public class SaveClienteTest {
    @Autowired
    private ClientRepository service;
    @Autowired
    private  BCryptPasswordEncoder encoder;

    @Test
    public void saveClienteTest(){
        Client client = new Client();
        client.setFirstName("user");
        client.setLastName("Rol");
        client.setUser("user");
        client.setPassword(encoder.encode("123"));
        Client retorno = service.save(client);

        assert(retorno.getPassword().equals(client.getPassword()));
    }
}
