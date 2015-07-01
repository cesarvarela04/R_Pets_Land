package co.petsland.model;
// Generated 28/06/2015 09:53:51 PM by Hibernate Tools 4.0.0



/**
 * VetsServs generated by hbm2java
 */
public class VetsServs  implements java.io.Serializable {


     private Long vsCodigo;
     private Servicios servicios;
     private Veterinarias veterinarias;
     private String vsEstado;

    public VetsServs() {
    }

	
    public VetsServs(Long vsCodigo, Servicios servicios, Veterinarias veterinarias) {
        this.vsCodigo = vsCodigo;
        this.servicios = servicios;
        this.veterinarias = veterinarias;
    }
    public VetsServs(Long vsCodigo, Servicios servicios, Veterinarias veterinarias, String vsEstado) {
       this.vsCodigo = vsCodigo;
       this.servicios = servicios;
       this.veterinarias = veterinarias;
       this.vsEstado = vsEstado;
    }
   
    public Long getVsCodigo() {
        return this.vsCodigo;
    }
    
    public void setVsCodigo(Long vsCodigo) {
        this.vsCodigo = vsCodigo;
    }
    public Servicios getServicios() {
        return this.servicios;
    }
    
    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }
    public Veterinarias getVeterinarias() {
        return this.veterinarias;
    }
    
    public void setVeterinarias(Veterinarias veterinarias) {
        this.veterinarias = veterinarias;
    }
    public String getVsEstado() {
        return this.vsEstado;
    }
    
    public void setVsEstado(String vsEstado) {
        this.vsEstado = vsEstado;
    }




}

