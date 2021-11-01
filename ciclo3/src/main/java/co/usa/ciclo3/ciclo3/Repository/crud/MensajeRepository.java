/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository.crud;

import co.usa.ciclo3.ciclo3.Modelo.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roll-
 */
@Repository
public class MensajeRepository {
    
    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;
    
    public List<Mensaje> getAll(){
    
        return (List<Mensaje>) mensajeCrudRepository.findAll();
        
    }
    
    public Optional<Mensaje> getMensaje(int id){
    
    return mensajeCrudRepository.findById(id);
    
    }
    
    public Mensaje save(Mensaje s){
    
    return mensajeCrudRepository.save(s);
    
    }
    
    public void delete(Mensaje s) {
       mensajeCrudRepository.delete(s);
    }
    
}
