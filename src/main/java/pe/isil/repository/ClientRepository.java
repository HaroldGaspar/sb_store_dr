package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.modelEn.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByUser(String username);
}
