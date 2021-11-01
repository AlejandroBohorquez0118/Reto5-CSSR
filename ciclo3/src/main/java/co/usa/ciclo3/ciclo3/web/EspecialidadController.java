/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.Modelo.Especialidad;
import co.usa.ciclo3.ciclo3.Service.EspecialidadService;
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
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})


public class EspecialidadController {
    
    
    @Autowired
    private EspecialidadService especialidadService;
    
    
    @GetMapping("/all")
    public List<Especialidad> getEspecialidad(){
    
        return especialidadService.getAll();
    
    }
    
    @GetMapping("/{id}")
    public Optional<Especialidad> getEspecialidades(@PathVariable("id")int id){
    
    return especialidadService.getEspecialidad(id);
    
    
    }
    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad save(@RequestBody Especialidad s){
    
        return especialidadService.save(s);
    
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad update(@RequestBody Especialidad especialidad) {
        return especialidadService.update(especialidad);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return especialidadService.delete(id);
    }
    
}
