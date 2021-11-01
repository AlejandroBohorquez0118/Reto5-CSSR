/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Modelo.Mensaje;
import co.usa.ciclo3.ciclo3.Repository.crud.MensajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roll-
 */
@Service
public class MensajeService {
    
    
    @Autowired
    private MensajeRepository mensajeRepository;
    
    public List<Mensaje> getAll(){
    
        return mensajeRepository.getAll();
        
    }
    
    
    public Optional<Mensaje> getMensaje(int id){
        
        return mensajeRepository.getMensaje(id);
        
    }
    
    public Mensaje save(Mensaje s){
    
        if(s.getIdMessage()==null){
        
            return mensajeRepository.save(s);
            
        } 
    
        else {
            Optional<Mensaje> paux=mensajeRepository.getMensaje(s.getIdMessage());
            if(paux.toString().equals("")){
                
                return mensajeRepository.save(s);
                
            }
            
            else{
                
                return s;
                
            }
    }
}
    
    public Mensaje update(Mensaje s){
        if(s.getIdMessage()!=null){
            Optional<Mensaje> saux = mensajeRepository.getMensaje(s.getIdMessage());
            if(!saux.isEmpty()){
                if(s.getMessageText()!=null){
                    saux.get().setMessageText(s.getMessageText());
                }
                if(s.getDoctor()!=null){
                    saux.get().setDoctor(s.getDoctor());
                }
                if(s.getClient()!=null){
                    saux.get().setClient(s.getClient());
                }
                return mensajeRepository.save(saux.get());

            }
        }
        return s;
    }
 
    
    public boolean delete(int id){
        Optional<Mensaje> s=getMensaje(id);
        if(!s.isEmpty()){
            mensajeRepository.delete(s.get());
            return true;
        }
        return false;

    }
}
