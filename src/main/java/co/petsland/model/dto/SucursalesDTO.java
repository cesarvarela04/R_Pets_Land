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
public class SucursalesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long sucCodigo;
    private String sucDireccion;
    private String sucTelefono;
    private Long vetCodigo_Veterinarias;

    public Long getSucCodigo() {
        return sucCodigo;
    }

    public void setSucCodigo(Long sucCodigo) {
        this.sucCodigo = sucCodigo;
    }

    public String getSucDireccion() {
        return sucDireccion;
    }

    public void setSucDireccion(String sucDireccion) {
        this.sucDireccion = sucDireccion;
    }

    public String getSucTelefono() {
        return sucTelefono;
    }

    public void setSucTelefono(String sucTelefono) {
        this.sucTelefono = sucTelefono;
    }

    public Long getVetCodigo_Veterinarias() {
        return vetCodigo_Veterinarias;
    }

    public void setVetCodigo_Veterinarias(Long vetCodigo_Veterinarias) {
        this.vetCodigo_Veterinarias = vetCodigo_Veterinarias;
    }
}
