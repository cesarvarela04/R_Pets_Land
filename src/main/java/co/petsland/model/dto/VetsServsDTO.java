package co.petsland.model.dto;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class VetsServsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long vsCodigo;
    private String vsEstado;
    private Long serCodigo_Servicios;
    private Long vetCodigo_Veterinarias;

    public Long getVsCodigo() {
        return vsCodigo;
    }

    public void setVsCodigo(Long vsCodigo) {
        this.vsCodigo = vsCodigo;
    }

    public String getVsEstado() {
        return vsEstado;
    }

    public void setVsEstado(String vsEstado) {
        this.vsEstado = vsEstado;
    }

    public Long getSerCodigo_Servicios() {
        return serCodigo_Servicios;
    }

    public void setSerCodigo_Servicios(Long serCodigo_Servicios) {
        this.serCodigo_Servicios = serCodigo_Servicios;
    }

    public Long getVetCodigo_Veterinarias() {
        return vetCodigo_Veterinarias;
    }

    public void setVetCodigo_Veterinarias(Long vetCodigo_Veterinarias) {
        this.vetCodigo_Veterinarias = vetCodigo_Veterinarias;
    }
}
