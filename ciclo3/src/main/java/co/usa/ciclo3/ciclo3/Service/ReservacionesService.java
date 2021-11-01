/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Modelo.Reservaciones;
import co.usa.ciclo3.ciclo3.Modelo.StatusReport;
import co.usa.ciclo3.ciclo3.Reportes.ContadorClientes;
import co.usa.ciclo3.ciclo3.Repository.crud.ReservacionesRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roll-
 */
@Service
public class ReservacionesService {
   
    @Autowired
    private ReservacionesRepository reservacionesRepository;
    
    public List<Reservaciones> getAll(){
    
        return reservacionesRepository.getAll();
        
    }
    
    
    public Optional<Reservaciones> getReservaciones(int id){
        
        return reservacionesRepository.getReservaciones(id);
        
    }
    
    public Reservaciones save(Reservaciones s){
    
        if(s.getIdReservation()==null){
        
            return reservacionesRepository.save(s);
            
        } 
    
        else {
            Optional<Reservaciones> paux=reservacionesRepository.getReservaciones(s.getIdReservation());
            if(paux.isEmpty()){
                
                return reservacionesRepository.save(s);
                
            }
            
            else{
                
                return s;
                
            }
    }
}
    public Reservaciones update(Reservaciones s){
        if(s.getIdReservation()!=null){
            Optional<Reservaciones> saux = reservacionesRepository.getReservaciones(s.getIdReservation());
            if(!saux.isEmpty()){
                if(s.getStartDate()!=null){
                    saux.get().setStartDate(s.getStartDate());
                }
                if(s.getDevolutionDate()!=null){
                    saux.get().setDevolutionDate(s.getDevolutionDate());
                }
                if(s.getStatus()!=null){
                    saux.get().setStatus(s.getStatus());
                }
                if(s.getDoctor()!=null){
                    saux.get().setDoctor(s.getDoctor());
                }
                if(s.getClient()!=null){
                    saux.get().setClient(s.getClient());
                }
                
                return reservacionesRepository.save(saux.get());

            }
        }
        return s;
    }
 
    
    public boolean delete(int id){
        Optional<Reservaciones> s=getReservaciones(id);
        if(!s.isEmpty()){
            reservacionesRepository.delete(s.get());
            return true;
        }
        return false;

    }

    public List<Reservaciones>getReservaPeriodo(String dateA, String dateB){
    
    SimpleDateFormat parser= new SimpleDateFormat("yyyy-MM-dd");
    Date aDate= new Date();
    Date bDate= new Date();
    
    try {
    
        aDate= parser.parse(dateA);
        bDate= parser.parse(dateB);
                
    } 
    catch(ParseException event){
    
        event.printStackTrace();
    
    }
    
    if(aDate.before(bDate)){
        
        return reservacionesRepository.getReservaPerdiodo(aDate, bDate);
        
    }else{
    
    return new ArrayList<>();
    
    }
    }
    
    public List<ContadorClientes> getTopClients(){
    
    return reservacionesRepository.getTopClients();
    
    }
    
    public StatusReport getStatusReport() {
        List<Reservaciones> completed = reservacionesRepository.getReservacionesByStatus("completed");
        List<Reservaciones> cancelled = reservacionesRepository.getReservacionesByStatus("cancelled");
        StatusReport s = new StatusReport(completed.size(), cancelled.size());
        return s;
    }
    }
