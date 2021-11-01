/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Modelo.Especialidad;
import co.usa.ciclo3.ciclo3.Repository.crud.EspecialidadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roll-
 */
@Service
public class EspecialidadService {
    
    @Autowired
    private EspecialidadRepository especialidadRepository;
    
    public List<Especialidad> getAll(){
    
        return especialidadRepository.getAll();
        
    }
    
    
    public Optional<Especialidad> getEspecialidad(int id){
        
        return especialidadRepository.getEspecialidad(id);
        
    }
    
    public Especialidad save(Especialidad s){
    
        if(s.getId()==null){
        
            return especialidadRepository.save(s);
            
        } 
    
        else {
            Optional<Especialidad> paux=especialidadRepository.getEspecialidad(s.getId());
            if(paux.isEmpty()){
                
                return especialidadRepository.save(s);
                
            }
            
            else{
                
                return s;
                
            }
    }
        

}
    
    public Especialidad update(Especialidad s){
        if(s.getId()!=null){
            Optional<Especialidad> saux = especialidadRepository.getEspecialidad(s.getId());
            if(!saux.isEmpty()){
                if(s.getName()!=null){
                    saux.get().setName(s.getName());
                }
                if(s.getDescription()!=null){
                    saux.get().setDescription(s.getDescription());
                }
                return especialidadRepository.save(saux.get());

            }
        }
        return s;
    }
 
    
    public boolean delete(int id){
        Optional<Especialidad> s=getEspecialidad(id);
        if(!s.isEmpty()){
            especialidadRepository.delete(s.get());
            return true;
        }
        return false;

    }

}