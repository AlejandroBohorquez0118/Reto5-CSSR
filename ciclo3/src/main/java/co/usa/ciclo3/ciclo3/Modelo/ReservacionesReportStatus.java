
package co.usa.ciclo3.ciclo3.Modelo;


/**
 *
 * Modelo de un objeto que reporta a través
 * de una consulta el número de reservaciones
 * completadas y el número de reservaciones 
 * canceladas.
 */
public class ReservacionesReportStatus {
    private Integer completed;
    private Integer cancelled;

    public ReservacionesReportStatus(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }
 
}
