/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository.crud;

import co.usa.ciclo3.ciclo3.Modelo.Doctor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roll-
 */
@Repository
public class DoctorRepository {

@Autowired
    private DoctorCrudRepository doctorCrudRepository;
    
    public List<Doctor> getAll(){
    
        return (List<Doctor>) doctorCrudRepository.findAll();
        
    }
    
    public Optional<Doctor> getDoctor(int id){
    
    return doctorCrudRepository.findById(id);
    
    }
    
    public Doctor save(Doctor s){
    
    return doctorCrudRepository.save(s);
    
    }
    
    public void delete(Doctor s) {
        doctorCrudRepository.delete(s);
    }
    

    
}
