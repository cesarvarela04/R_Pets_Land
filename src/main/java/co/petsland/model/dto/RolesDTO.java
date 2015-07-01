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
public class RolesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long rolCodigo;
    private String rolEstado;
    private Date rolFechaCrea;
    private Date rolFechaModifica;
    private String rolNombre;
    private String rolUsuCrea;
    private String rolUsuModifica;

    public Long getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(Long rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    public String getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(String rolEstado) {
        this.rolEstado = rolEstado;
    }

    public Date getRolFechaCrea() {
        return rolFechaCrea;
    }

    public void setRolFechaCrea(Date rolFechaCrea) {
        this.rolFechaCrea = rolFechaCrea;
    }

    public Date getRolFechaModifica() {
        return rolFechaModifica;
    }

    public void setRolFechaModifica(Date rolFechaModifica) {
        this.rolFechaModifica = rolFechaModifica;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolUsuCrea() {
        return rolUsuCrea;
    }

    public void setRolUsuCrea(String rolUsuCrea) {
        this.rolUsuCrea = rolUsuCrea;
    }

    public String getRolUsuModifica() {
        return rolUsuModifica;
    }

    public void setRolUsuModifica(String rolUsuModifica) {
        this.rolUsuModifica = rolUsuModifica;
    }
}
