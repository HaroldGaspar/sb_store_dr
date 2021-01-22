package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.modelEn.Bill;
import pe.isil.repository.BillRepository;

import java.util.List;

@Service
public class BillService {
    @Autowired
    private BillRepository companyRepository;

    public void createOrUpdate(Bill b){
        companyRepository.save(b);
    }

    public void delete(Integer id){
        companyRepository.deleteById(id);
    }

    public Bill findById(Integer id){
        return companyRepository.findById(id).orElse(null);
    }

    public List<Bill> findAll(){
        return companyRepository.findAll();
    }
}
