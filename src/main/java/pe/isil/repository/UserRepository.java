package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.modelEn.Client;

public interface UserRepository extends JpaRepository<Client, Long> {
}
