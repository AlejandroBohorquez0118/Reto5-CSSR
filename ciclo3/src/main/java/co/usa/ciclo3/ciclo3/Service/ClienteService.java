/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Modelo.Cliente;
import co.usa.ciclo3.ciclo3.Repository.crud.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roll-
 */

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<Cliente> getAll(){
    
        return clienteRepository.getAll();
        
    }
    
    
    public Optional<Cliente> getCliente(int id){
        
        return clienteRepository.getCliente(id);
        
    }
    
    public Cliente save(Cliente s){
    
        if(s.getIdClient()==null){
        
            return clienteRepository.save(s);
            
        } 
    
        else {
            Optional<Cliente> paux=clienteRepository.getCliente(s.getIdClient());
            if(paux.isEmpty()){
                
                return clienteRepository.save(s);
                
            }
            
            else{
                
                return s;
                
            }
    }
        

}
    
    public Cliente update(Cliente s){
        if(s.getIdClient()!=null){
            Optional<Cliente> saux = clienteRepository.getCliente(s.getIdClient());
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
                if(s.getAge()!=null){
                    saux.get().setAge(s.getAge());
                }                
                return clienteRepository.save(saux.get());

            }
        }
        return s;
    }
 
    
    public boolean delete(int id){
        Optional<Cliente> s=getCliente(id);
        if(!s.isEmpty()){
            clienteRepository.delete(s.get());
            return true;
        }
        return false;

    }
    
    
}
