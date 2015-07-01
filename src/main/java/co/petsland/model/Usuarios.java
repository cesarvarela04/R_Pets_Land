package co.petsland.model;
// Generated 28/06/2015 09:53:51 PM by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Long usuCodigo;
     private Roles roles;
     private String usuNombre;
     private String usuClave;
     private String usuEmail;
     private Date usuFechaCreacion;
     private Date usuFechaModifica;
     private String usuCrea;
     private String usuModifica;
     private String usuEstado;
     private Set<EventosVeterinarias> eventosVeterinariases = new HashSet<EventosVeterinarias>(0);

    public Usuarios() {
    }

	
    public Usuarios(Long usuCodigo, Roles roles, String usuNombre, String usuClave, String usuEmail, Date usuFechaCreacion, String usuCrea, String usuEstado) {
        this.usuCodigo = usuCodigo;
        this.roles = roles;
        this.usuNombre = usuNombre;
        this.usuClave = usuClave;
        this.usuEmail = usuEmail;
        this.usuFechaCreacion = usuFechaCreacion;
        this.usuCrea = usuCrea;
        this.usuEstado = usuEstado;
    }
    public Usuarios(Long usuCodigo, Roles roles, String usuNombre, String usuClave, String usuEmail, Date usuFechaCreacion, Date usuFechaModifica, String usuCrea, String usuModifica, String usuEstado, Set<EventosVeterinarias> eventosVeterinariases) {
       this.usuCodigo = usuCodigo;
       this.roles = roles;
       this.usuNombre = usuNombre;
       this.usuClave = usuClave;
       this.usuEmail = usuEmail;
       this.usuFechaCreacion = usuFechaCreacion;
       this.usuFechaModifica = usuFechaModifica;
       this.usuCrea = usuCrea;
       this.usuModifica = usuModifica;
       this.usuEstado = usuEstado;
       this.eventosVeterinariases = eventosVeterinariases;
    }
   
    public Long getUsuCodigo() {
        return this.usuCodigo;
    }
    
    public void setUsuCodigo(Long usuCodigo) {
        this.usuCodigo = usuCodigo;
    }
    public Roles getRoles() {
        return this.roles;
    }
    
    public void setRoles(Roles roles) {
        this.roles = roles;
    }
    public String getUsuNombre() {
        return this.usuNombre;
    }
    
    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }
    public String getUsuClave() {
        return this.usuClave;
    }
    
    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }
    public String getUsuEmail() {
        return this.usuEmail;
    }
    
    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }
    public Date getUsuFechaCreacion() {
        return this.usuFechaCreacion;
    }
    
    public void setUsuFechaCreacion(Date usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }
    public Date getUsuFechaModifica() {
        return this.usuFechaModifica;
    }
    
    public void setUsuFechaModifica(Date usuFechaModifica) {
        this.usuFechaModifica = usuFechaModifica;
    }
    public String getUsuCrea() {
        return this.usuCrea;
    }
    
    public void setUsuCrea(String usuCrea) {
        this.usuCrea = usuCrea;
    }
    public String getUsuModifica() {
        return this.usuModifica;
    }
    
    public void setUsuModifica(String usuModifica) {
        this.usuModifica = usuModifica;
    }
    public String getUsuEstado() {
        return this.usuEstado;
    }
    
    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }
    public Set<EventosVeterinarias> getEventosVeterinariases() {
        return this.eventosVeterinariases;
    }
    
    public void setEventosVeterinariases(Set<EventosVeterinarias> eventosVeterinariases) {
        this.eventosVeterinariases = eventosVeterinariases;
    }




}


