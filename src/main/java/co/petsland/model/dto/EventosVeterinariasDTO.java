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
public class EventosVeterinariasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long evCodigo;
    private String evFavorito;
    private Date evFechaf;
    private Date evFechamg;
    private String evMegusta;
    private Long usuCodigo_Usuarios;
    private Long vetCodigo_Veterinarias;

    public Long getEvCodigo() {
        return evCodigo;
    }

    public void setEvCodigo(Long evCodigo) {
        this.evCodigo = evCodigo;
    }

    public String getEvFavorito() {
        return evFavorito;
    }

    public void setEvFavorito(String evFavorito) {
        this.evFavorito = evFavorito;
    }

    public Date getEvFechaf() {
        return evFechaf;
    }

    public void setEvFechaf(Date evFechaf) {
        this.evFechaf = evFechaf;
    }

    public Date getEvFechamg() {
        return evFechamg;
    }

    public void setEvFechamg(Date evFechamg) {
        this.evFechamg = evFechamg;
    }

    public String getEvMegusta() {
        return evMegusta;
    }

    public void setEvMegusta(String evMegusta) {
        this.evMegusta = evMegusta;
    }

    public Long getUsuCodigo_Usuarios() {
        return usuCodigo_Usuarios;
    }

    public void setUsuCodigo_Usuarios(Long usuCodigo_Usuarios) {
        this.usuCodigo_Usuarios = usuCodigo_Usuarios;
    }

    public Long getVetCodigo_Veterinarias() {
        return vetCodigo_Veterinarias;
    }

    public void setVetCodigo_Veterinarias(Long vetCodigo_Veterinarias) {
        this.vetCodigo_Veterinarias = vetCodigo_Veterinarias;
    }
}
