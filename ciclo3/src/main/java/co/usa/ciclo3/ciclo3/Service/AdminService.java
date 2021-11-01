
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Modelo.Admin;
import co.usa.ciclo3.ciclo3.Repository.crud.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;
    
    public List<Admin> getAll() {
        return repository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id) {
        return repository.getAdmin(id);
    }
    
    public Admin save(Admin admin) {
        if(admin.getIdAdmin() == null) {
            return repository.save(admin);
        } else {
            return admin;
        }
    }
    
    public Admin update(Admin s){
        if(s.getIdAdmin()!=null){
            Optional<Admin> saux = repository.getAdmin(s.getIdAdmin());
            if(!saux.isEmpty()){
                if(s.getName()!=null){
                    saux.get().setName(s.getName());
                }
                if(s.getEmail()!=null){
                    saux.get().setEmail(s.getEmail());
                }
                if(s.getPassword()!=null){
                    saux.get().setPassword(s.getPassword());
                }
                return repository.save(saux.get());

            }
        }
        return s;
    }
 
    
    public boolean delete(int id){
        Optional<Admin> s=getAdmin(id);
        if(!s.isEmpty()){
            repository.delete(s.get());
            return true;
        }
        return false;
    }
}
