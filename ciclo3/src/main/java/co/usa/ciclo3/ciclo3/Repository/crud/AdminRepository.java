
package co.usa.ciclo3.ciclo3.Repository.crud;

import co.usa.ciclo3.ciclo3.Modelo.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository crud;
    
    public List<Admin> getAll() {
        return (List<Admin>) crud.findAll();
    }
    
    public Optional<Admin> getAdmin(int id) {
        return crud.findById(id);
    }
    
    public Admin save(Admin admin) {
        return crud.save(admin);
    }
    
    public void delete(Admin admin) {
        crud.delete(admin);
    }
}
