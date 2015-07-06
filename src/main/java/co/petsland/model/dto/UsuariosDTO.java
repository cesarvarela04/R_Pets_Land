package co.petsland.model.dto;

import java.io.Serializable;
import java.sql.*;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@XmlRootElement(name="veterinaria")
public class UsuariosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String usuClave;
    private Long usuCodigo;
    private String usuCrea;
    private String usuEmail;
    private String usuEstado;
    private Date usuFechaCreacion;
    private Date usuFechaModifica;
    private String usuModifica;
    private String usuNombre;
    private Long rolCodigo_Roles;
	private String rol;

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Long getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Long usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public String getUsuCrea() {
        return usuCrea;
    }

    public void setUsuCrea(String usuCrea) {
        this.usuCrea = usuCrea;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Date getUsuFechaCreacion() {
        return usuFechaCreacion;
    }

    public void setUsuFechaCreacion(Date usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

    public Date getUsuFechaModifica() {
        return usuFechaModifica;
    }

    public void setUsuFechaModifica(Date usuFechaModifica) {
        this.usuFechaModifica = usuFechaModifica;
    }

    public String getUsuModifica() {
        return usuModifica;
    }

    public void setUsuModifica(String usuModifica) {
        this.usuModifica = usuModifica;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public Long getRolCodigo_Roles() {
        return rolCodigo_Roles;
    }

    public void setRolCodigo_Roles(Long rolCodigo_Roles) {
        this.rolCodigo_Roles = rolCodigo_Roles;
    }

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}	
	
}
