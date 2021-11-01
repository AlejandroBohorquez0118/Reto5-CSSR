/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Modelo.Doctor;
import co.usa.ciclo3.ciclo3.Repository.crud.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roll-
 */
@Service
public class DoctorService {
 
    @Autowired
    private DoctorRepository doctorRepository;
    
    public List<Doctor> getAll(){
    
        return doctorRepository.getAll();
        
    }
    
    
    public Optional<Doctor> getDoctor(int id){
        
        return doctorRepository.getDoctor(id);
        
    }
    
    public Doctor save(Doctor s){
    
        if(s.getId()==null){
        
            return doctorRepository.save(s);
            
        } 
    
        else {
            Optional<Doctor> paux=doctorRepository.getDoctor(s.getId());
            if(paux.isEmpty()){
                
                return doctorRepository.save(s);
                
            }
            
            else{
                
                return s;
                
            }
    }
        

}
    
    public Doctor update(Doctor s){
        if(s.getId()!=null){
            Optional<Doctor> saux = doctorRepository.getDoctor(s.getId());
            if(!saux.isEmpty()){
                if(s.getName()!=null){
                    saux.get().setName(s.getName());
                }
                if(s.getDepartment()!=null){
                    saux.get().setDepartment(s.getDepartment());
                }
                if(s.getYear()!=null){
                    saux.get().setYear(s.getYear());
                }
                if(s.getDescription()!=null){
                    saux.get().setDescription(s.getDescription());
                }
                if(s.getSpecialty()!=null){
                    saux.get().setSpecialty(s.getSpecialty());
                }
                                
                return doctorRepository.save(saux.get());

            }
        }
        return s;
    }
 
    
    public boolean delete(int id){
        Optional<Doctor> s=getDoctor(id);
        if(!s.isEmpty()){
            doctorRepository.delete(s.get());
            return true;
        }
        return false;

    }
}
