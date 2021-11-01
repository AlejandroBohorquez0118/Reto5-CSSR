/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository.crud;

import co.usa.ciclo3.ciclo3.Modelo.Cliente;
import co.usa.ciclo3.ciclo3.Modelo.Reservaciones;
import co.usa.ciclo3.ciclo3.Reportes.ContadorClientes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roll-
 */
@Repository
public class ReservacionesRepository {
 
    
    @Autowired
    private ReservacionesCrudRepository reservacionesCrudRepository;
    
    public List<Reservaciones> getAll(){
    
        return (List<Reservaciones>) reservacionesCrudRepository.findAll();
        
    }
    
    public Optional<Reservaciones> getReservaciones(int id){
    
    return reservacionesCrudRepository.findById(id);
    
    }
    
    public Reservaciones save(Reservaciones s){
    
    return reservacionesCrudRepository.save(s);
    
    }
    
    public void delete(Reservaciones s) {
        reservacionesCrudRepository.delete(s);
    }
    
    public List<Reservaciones> getReservaPerdiodo(Date a, Date b){
    
    return reservacionesCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    
    }
    
    public List<ContadorClientes> getTopClients(){
    
    List<ContadorClientes> res= new ArrayList<>();
    List<Object[]> report= reservacionesCrudRepository.countTotalReservationByClient();
    for(int i = 0; i<report.size(); i++){
    
    res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
    }
    return res;
    }
 
    public List<Reservaciones> getReservacionesByStatus(String s) {
        return reservacionesCrudRepository.findAllByStatus(s);
    }
}
