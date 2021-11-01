/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository.crud;

import co.usa.ciclo3.ciclo3.Modelo.Especialidad;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roll-
 */
@Repository
public class EspecialidadRepository {
    
    @Autowired
    private EspecialidadCrudRepository especialidadCrudRepository;
    
    public List<Especialidad> getAll(){
    
        return (List<Especialidad>) especialidadCrudRepository.findAll();
        
    }
    
    public Optional<Especialidad> getEspecialidad(int id){
    
    return especialidadCrudRepository.findById(id);
    
    }
    
    public Especialidad save(Especialidad s){
    
    return especialidadCrudRepository.save(s);
    
    }
    
    public void delete(Especialidad s) {
        especialidadCrudRepository.delete(s);
    }
    
}
