/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.Modelo.Reservaciones;
import co.usa.ciclo3.ciclo3.Modelo.StatusReport;
import co.usa.ciclo3.ciclo3.Reportes.ContadorClientes;
import co.usa.ciclo3.ciclo3.Service.ReservacionesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roll-
 */

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ReservacionesController {
    
    @Autowired
    private ReservacionesService reservacionesService;
    
    
    @GetMapping("/all")
    public List<Reservaciones> getReservaciones(){
    
        return reservacionesService.getAll();
    
    }
    
    @GetMapping("/{id}")
    public Optional<Reservaciones> getReservaciones(@PathVariable("id")int id){
    
    return reservacionesService.getReservaciones(id);
    
    
    }
    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones s){
    
        return reservacionesService.save(s);
    
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones s) {
        return reservacionesService.update(s);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return reservacionesService.delete(id);
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservaciones>getReservationDatePeriod(@PathVariable("dateOne")String dateOne,@PathVariable("dateTwo")String dateTwo){
    
        return reservacionesService.getReservaPeriodo(dateOne, dateTwo);
        
    }
    
    @GetMapping("/report-clients")
    public List<ContadorClientes> getReservationsReportsClients(){
    
        return reservacionesService.getTopClients();
        
    }
    
    @GetMapping("/report-status")
    public StatusReport getStatusReport() {
        return reservacionesService.getStatusReport();
    }
    
}
