
package co.usa.ciclo3.ciclo3.Repository.crud;

import co.usa.ciclo3.ciclo3.Modelo.Calificaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CalificacionesRepository {
    @Autowired
    private CalificacionesCrudRepository crud;
    
    public List<Calificaciones> getAll() {
        return (List<Calificaciones>) crud.findAll();
    }
    
    public Optional<Calificaciones> getCalificaciones(int id) {
        return crud.findById(id);
    }
    
    public Calificaciones save(Calificaciones score) {
        return crud.save(score);
    }
    
    public void delete(Calificaciones score) {
        crud.delete(score);
    }
}
