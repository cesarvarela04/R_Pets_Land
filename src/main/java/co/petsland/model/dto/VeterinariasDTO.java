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
public class VeterinariasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long vetCodigo;
    private String vetDireccion;
    private String vetEstado;
    private String vetNombre;
    private String vetTelefono;
    private String vetUrl;
    private String vetUsuCrea;
    private String vetUsuModifica;

    public Long getVetCodigo() {
        return vetCodigo;
    }

    public void setVetCodigo(Long vetCodigo) {
        this.vetCodigo = vetCodigo;
    }

    public String getVetDireccion() {
        return vetDireccion;
    }

    public void setVetDireccion(String vetDireccion) {
        this.vetDireccion = vetDireccion;
    }

    public String getVetEstado() {
        return vetEstado;
    }

    public void setVetEstado(String vetEstado) {
        this.vetEstado = vetEstado;
    }

    public String getVetNombre() {
        return vetNombre;
    }

    public void setVetNombre(String vetNombre) {
        this.vetNombre = vetNombre;
    }

    public String getVetTelefono() {
        return vetTelefono;
    }

    public void setVetTelefono(String vetTelefono) {
        this.vetTelefono = vetTelefono;
    }

    public String getVetUrl() {
        return vetUrl;
    }

    public void setVetUrl(String vetUrl) {
        this.vetUrl = vetUrl;
    }

    public String getVetUsuCrea() {
        return vetUsuCrea;
    }

    public void setVetUsuCrea(String vetUsuCrea) {
        this.vetUsuCrea = vetUsuCrea;
    }

    public String getVetUsuModifica() {
        return vetUsuModifica;
    }

    public void setVetUsuModifica(String vetUsuModifica) {
        this.vetUsuModifica = vetUsuModifica;
    }
}
