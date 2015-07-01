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
public class ServiciosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long serCodigo;
    private String serEstado;
    private String serNombre;
    private String serUsuCrea;
    private String serUsuModifica;

    public Long getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(Long serCodigo) {
        this.serCodigo = serCodigo;
    }

    public String getSerEstado() {
        return serEstado;
    }

    public void setSerEstado(String serEstado) {
        this.serEstado = serEstado;
    }

    public String getSerNombre() {
        return serNombre;
    }

    public void setSerNombre(String serNombre) {
        this.serNombre = serNombre;
    }

    public String getSerUsuCrea() {
        return serUsuCrea;
    }

    public void setSerUsuCrea(String serUsuCrea) {
        this.serUsuCrea = serUsuCrea;
    }

    public String getSerUsuModifica() {
        return serUsuModifica;
    }

    public void setSerUsuModifica(String serUsuModifica) {
        this.serUsuModifica = serUsuModifica;
    }
}
