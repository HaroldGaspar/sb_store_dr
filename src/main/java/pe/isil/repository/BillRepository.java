package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.modelEn.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
}
