/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository.crud;

import co.usa.ciclo3.ciclo3.Modelo.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roll-
 */
@Repository
public class ClienteRepository {
 
    
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    
    public List<Cliente> getAll(){
    
        return (List<Cliente>) clienteCrudRepository.findAll();
        
    }
    
    public Optional<Cliente> getCliente(int id){
    
    return clienteCrudRepository.findById(id);
    
    }
    
    public Cliente save(Cliente s){
    
    return clienteCrudRepository.save(s);
    
    }
    
    public void delete(Cliente s) {
        clienteCrudRepository.delete(s);
    }
    
}
