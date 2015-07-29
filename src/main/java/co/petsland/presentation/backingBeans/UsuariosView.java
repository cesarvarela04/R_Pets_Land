package co.petsland.presentation.backingBeans;

import co.petsland.exceptions.*;
import co.petsland.model.*;
import co.petsland.model.dto.UsuariosDTO;
import co.petsland.presentation.businessDelegate.*;
import co.petsland.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;

import java.io.Serializable;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class UsuariosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private String txtUsuClave;
	private String txtUsuClave2;
	private InputText txtUsuCrea;
	private String txtUsuEmail;
	private InputText txtUsuEstado;
	private InputText txtUsuModifica;
	private String txtUsuNombre;
	private InputText txtRolCodigo_Roles;
	private InputText txtUsuCodigo;
	private Calendar txtUsuFechaCreacion;
	private Calendar txtUsuFechaModifica;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<UsuariosDTO> data;
	private UsuariosDTO usuario;
	private UsuariosDTO selectedUsuarios;
	private Usuarios entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public UsuariosView() {
		super();
	}

	@PostConstruct
	public void consultarUsuario()  {
   
		try {
			String email = FacesContext.getCurrentInstance()
					.getExternalContext().getUserPrincipal().getName();
			if (email != null && email.length() > 1) {
				usuario = businessDelegatorView.consultaUsuarioXEmail(email);
				FacesUtils.setManagedBeanInSession("usuario", usuario);
				txtUsuNombre = usuario.getUsuNombre();
				txtUsuEmail = usuario.getUsuEmail();
				txtUsuClave = usuario.getUsuClave();
				txtUsuClave2 = usuario.getUsuClave();
				
			} else {
				usuario = new UsuariosDTO();
				usuario.setRol("No existe ninguna sesion activa");
				System.out.println("No existe ninguna sesion activa");
			}

		} catch (Exception e) {
			
		}

	}
	
	
	public String registroUsuario() {

		try {
			
			Roles rol = businessDelegatorView.getRoles(2L);

			entity = new Usuarios();
			entity.setUsuNombre(txtUsuNombre);
			entity.setUsuClave(txtUsuClave);
			entity.setUsuEmail(txtUsuEmail);
			entity.setUsuFechaCreacion(new Date());
			entity.setUsuFechaModifica(new Date());
			entity.setUsuCrea("ROOT");
			entity.setUsuModifica("ROOT");
			entity.setUsuEstado("A");
			entity.setRoles(rol);

			if (txtUsuClave.equals(txtUsuClave2)) {

			} else {
				throw new Exception("No coincide la contraseña ingresada");
			}

			businessDelegatorView.saveUsuarios(entity);
			
			//EmailController mail=new EmailController();
			//String subject="Registro Exitoso en el sistema PETSLAND";
			//String messageBody="Bienvenido USER <br>  Usuario: " + txtEmail +" <br> Password:" + txtClave;
			//mail.performTask(txtEmail, subject, messageBody, null);
			
			FacesUtils.addInfoMessage("Registro Exitoso");
			
			

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	
	
	public String modificarUsuario() {
		try {

			entity = businessDelegatorView.getUsuarios(usuario.getUsuCodigo());		

			entity.setUsuNombre(txtUsuNombre);
			entity.setUsuClave(txtUsuClave);
			entity.setUsuEmail(txtUsuEmail);
			entity.setUsuFechaModifica(new Date());
			entity.setUsuModifica(usuario.getUsuNombre());
			entity.setUsuEstado("A");

			if (txtUsuClave.equals(txtUsuClave2)) {

			} else {
				throw new Exception("No coincide la contraseña ingresada");
			}
			businessDelegatorView.updateUsuarios(entity);
			FacesUtils.addInfoMessage("El usuario se modifico con exito");
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}


	/*public void rowEventListener(RowEditEvent e) {
		try {
			UsuariosDTO usuariosDTO = (UsuariosDTO) e.getObject();

			if (txtUsuClave == null) {
				txtUsuClave = new InputText();
			}

			txtUsuClave.setValue(usuariosDTO.getUsuClave());

			if (txtUsuCrea == null) {
				txtUsuCrea = new InputText();
			}

			txtUsuCrea.setValue(usuariosDTO.getUsuCrea());

			if (txtUsuEmail == null) {
				txtUsuEmail = new InputText();
			}

			txtUsuEmail.setValue(usuariosDTO.getUsuEmail());

			if (txtUsuEstado == null) {
				txtUsuEstado = new InputText();
			}

			txtUsuEstado.setValue(usuariosDTO.getUsuEstado());

			if (txtUsuModifica == null) {
				txtUsuModifica = new InputText();
			}

			txtUsuModifica.setValue(usuariosDTO.getUsuModifica());

			if (txtUsuNombre == null) {
				txtUsuNombre = new InputText();
			}

			txtUsuNombre.setValue(usuariosDTO.getUsuNombre());

			if (txtRolCodigo_Roles == null) {
				txtRolCodigo_Roles = new InputText();
			}

			txtRolCodigo_Roles.setValue(usuariosDTO.getRolCodigo_Roles());

			if (txtUsuCodigo == null) {
				txtUsuCodigo = new InputText();
			}

			txtUsuCodigo.setValue(usuariosDTO.getUsuCodigo());

			if (txtUsuFechaCreacion == null) {
				txtUsuFechaCreacion = new Calendar();
			}

			txtUsuFechaCreacion.setValue(usuariosDTO.getUsuFechaCreacion());

			if (txtUsuFechaModifica == null) {
				txtUsuFechaModifica = new Calendar();
			}

			txtUsuFechaModifica.setValue(usuariosDTO.getUsuFechaModifica());

			Long usuCodigo = FacesUtils.checkLong(txtUsuCodigo);
			entity = businessDelegatorView.getUsuarios(usuCodigo);

			action_modify();
		} catch (Exception ex) {
		}
	}*/

	public String action_new() {
		action_clear();
		usuario = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		usuario = null;

		/*if (txtUsuClave != null) {
			txtUsuClave.setValue(null);
			txtUsuClave.setDisabled(true);
		}
*/
		if (txtUsuCrea != null) {
			txtUsuCrea.setValue(null);
			txtUsuCrea.setDisabled(true);
		}

/*		if (txtUsuEmail != null) {
			txtUsuEmail.setValue(null);
			txtUsuEmail.setDisabled(true);
		}*/

		if (txtUsuEstado != null) {
			txtUsuEstado.setValue(null);
			txtUsuEstado.setDisabled(true);
		}

		if (txtUsuModifica != null) {
			txtUsuModifica.setValue(null);
			txtUsuModifica.setDisabled(true);
		}

/*		if (txtUsuNombre != null) {
			txtUsuNombre.setValue(null);
			txtUsuNombre.setDisabled(true);
		}*/

		if (txtRolCodigo_Roles != null) {
			txtRolCodigo_Roles.setValue(null);
			txtRolCodigo_Roles.setDisabled(true);
		}

		if (txtUsuFechaCreacion != null) {
			txtUsuFechaCreacion.setValue(null);
			txtUsuFechaCreacion.setDisabled(true);
		}

		if (txtUsuFechaModifica != null) {
			txtUsuFechaModifica.setValue(null);
			txtUsuFechaModifica.setDisabled(true);
		}

		if (txtUsuCodigo != null) {
			txtUsuCodigo.setValue(null);
			txtUsuCodigo.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtUsuFechaCreacion() {
		Date inputDate = (Date) txtUsuFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtUsuFechaModifica() {
		Date inputDate = (Date) txtUsuFechaModifica.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	/*public void listener_txtId() {
		try {
			Long usuCodigo = FacesUtils.checkLong(txtUsuCodigo);
			entity = (usuCodigo != null) ? businessDelegatorView
					.getUsuarios(usuCodigo) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtUsuClave.setDisabled(false);
			txtUsuCrea.setDisabled(false);
			txtUsuEmail.setDisabled(false);
			txtUsuEstado.setDisabled(false);
			txtUsuModifica.setDisabled(false);
			txtUsuNombre.setDisabled(false);
			txtRolCodigo_Roles.setDisabled(false);
			txtUsuFechaCreacion.setDisabled(false);
			txtUsuFechaModifica.setDisabled(false);
			txtUsuCodigo.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtUsuClave.setValue(entity.getUsuClave());
			txtUsuClave.setDisabled(false);
			txtUsuCrea.setValue(entity.getUsuCrea());
			txtUsuCrea.setDisabled(false);
			txtUsuEmail.setValue(entity.getUsuEmail());
			txtUsuEmail.setDisabled(false);
			txtUsuEstado.setValue(entity.getUsuEstado());
			txtUsuEstado.setDisabled(false);
			txtUsuFechaCreacion.setValue(entity.getUsuFechaCreacion());
			txtUsuFechaCreacion.setDisabled(false);
			txtUsuFechaModifica.setValue(entity.getUsuFechaModifica());
			txtUsuFechaModifica.setDisabled(false);
			txtUsuModifica.setValue(entity.getUsuModifica());
			txtUsuModifica.setDisabled(false);
			txtUsuNombre.setValue(entity.getUsuNombre());
			txtUsuNombre.setDisabled(false);
			txtRolCodigo_Roles.setValue(entity.getRoles().getRolCodigo());
			txtRolCodigo_Roles.setDisabled(false);
			txtUsuCodigo.setValue(entity.getUsuCodigo());
			txtUsuCodigo.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}*/

	/*public String action_edit(ActionEvent evt) {
		usuario = (UsuariosDTO) (evt.getComponent().getAttributes()
				.get("usuario"));
		txtUsuClave.setValue(usuario.getUsuClave());
		txtUsuClave.setDisabled(false);
		txtUsuCrea.setValue(usuario.getUsuCrea());
		txtUsuCrea.setDisabled(false);
		txtUsuEmail.setValue(usuario.getUsuEmail());
		txtUsuEmail.setDisabled(false);
		txtUsuEstado.setValue(usuario.getUsuEstado());
		txtUsuEstado.setDisabled(false);
		txtUsuFechaCreacion.setValue(usuario.getUsuFechaCreacion());
		txtUsuFechaCreacion.setDisabled(false);
		txtUsuFechaModifica.setValue(usuario.getUsuFechaModifica());
		txtUsuFechaModifica.setDisabled(false);
		txtUsuModifica.setValue(usuario.getUsuModifica());
		txtUsuModifica.setDisabled(false);
		txtUsuNombre.setValue(usuario.getUsuNombre());
		txtUsuNombre.setDisabled(false);
		txtRolCodigo_Roles.setValue(usuario.getRolCodigo_Roles());
		txtRolCodigo_Roles.setDisabled(false);
		txtUsuCodigo.setValue(usuario.getUsuCodigo());
		txtUsuCodigo.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}*/

	public String action_save() {
		try {
			if ((usuario == null) && (entity == null)) {
				action_create();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_create() {
		try {
			entity = new Usuarios();

			Long usuCodigo = FacesUtils.checkLong(txtUsuCodigo);

			entity.setUsuClave(FacesUtils.checkString(txtUsuClave));
			entity.setUsuCodigo(usuCodigo);
			entity.setUsuCrea(FacesUtils.checkString(txtUsuCrea));
			entity.setUsuEmail(FacesUtils.checkString(txtUsuEmail));
			entity.setUsuEstado(FacesUtils.checkString(txtUsuEstado));
			entity.setUsuFechaCreacion(FacesUtils
					.checkDate(txtUsuFechaCreacion));
			entity.setUsuFechaModifica(FacesUtils
					.checkDate(txtUsuFechaModifica));
			entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
			entity.setUsuNombre(FacesUtils.checkString(txtUsuNombre));
			entity.setRoles((FacesUtils.checkLong(txtRolCodigo_Roles) != null) ? businessDelegatorView
					.getRoles(FacesUtils.checkLong(txtRolCodigo_Roles)) : null);
			businessDelegatorView.saveUsuarios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long usuCodigo = new Long(usuario.getUsuCodigo());
				entity = businessDelegatorView.getUsuarios(usuCodigo);
			}

			entity.setUsuClave(FacesUtils.checkString(txtUsuClave));
			entity.setUsuCrea(FacesUtils.checkString(txtUsuCrea));
			entity.setUsuEmail(FacesUtils.checkString(txtUsuEmail));
			entity.setUsuEstado(FacesUtils.checkString(txtUsuEstado));
			entity.setUsuFechaCreacion(FacesUtils
					.checkDate(txtUsuFechaCreacion));
			entity.setUsuFechaModifica(FacesUtils
					.checkDate(txtUsuFechaModifica));
			entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
			entity.setUsuNombre(FacesUtils.checkString(txtUsuNombre));
			entity.setRoles((FacesUtils.checkLong(txtRolCodigo_Roles) != null) ? businessDelegatorView
					.getRoles(FacesUtils.checkLong(txtRolCodigo_Roles)) : null);
			businessDelegatorView.updateUsuarios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			usuario = (UsuariosDTO) (evt.getComponent().getAttributes()
					.get("usuario"));

			Long usuCodigo = new Long(usuario.getUsuCodigo());
			entity = businessDelegatorView.getUsuarios(usuCodigo);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long usuCodigo = FacesUtils.checkLong(txtUsuCodigo);
			entity = businessDelegatorView.getUsuarios(usuCodigo);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteUsuarios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			usuario = (UsuariosDTO) (evt.getComponent().getAttributes()
					.get("usuario"));

			Long usuCodigo = new Long(usuario.getUsuCodigo());
			entity = businessDelegatorView.getUsuarios(usuCodigo);
			businessDelegatorView.deleteUsuarios(entity);
			data.remove(usuario);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String usuClave, Long usuCodigo,
			String usuCrea, String usuEmail, String usuEstado,
			Date usuFechaCreacion, Date usuFechaModifica, String usuModifica,
			String usuNombre, Long rolCodigo_Roles) throws Exception {
		try {
			entity.setUsuClave(FacesUtils.checkString(usuClave));
			entity.setUsuCrea(FacesUtils.checkString(usuCrea));
			entity.setUsuEmail(FacesUtils.checkString(usuEmail));
			entity.setUsuEstado(FacesUtils.checkString(usuEstado));
			entity.setUsuFechaCreacion(FacesUtils.checkDate(usuFechaCreacion));
			entity.setUsuFechaModifica(FacesUtils.checkDate(usuFechaModifica));
			entity.setUsuModifica(FacesUtils.checkString(usuModifica));
			entity.setUsuNombre(FacesUtils.checkString(usuNombre));
			businessDelegatorView.updateUsuarios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("UsuariosView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public String getTxtUsuClave() {
		return txtUsuClave;
	}

	public void setTxtUsuClave(String txtUsuClave) {
		this.txtUsuClave = txtUsuClave;
	}
	
	public String getTxtUsuClave2() {
		return txtUsuClave2;
	}

	public void setTxtUsuClave2(String txtUsuClave2) {
		this.txtUsuClave2 = txtUsuClave2;
	}

	public InputText getTxtUsuCrea() {
		return txtUsuCrea;
	}

	public void setTxtUsuCrea(InputText txtUsuCrea) {
		this.txtUsuCrea = txtUsuCrea;
	}

	public String getTxtUsuEmail() {
		return txtUsuEmail;
	}

	public void setTxtUsuEmail(String txtUsuEmail) {
		this.txtUsuEmail = txtUsuEmail;
	}

	public InputText getTxtUsuEstado() {
		return txtUsuEstado;
	}

	public void setTxtUsuEstado(InputText txtUsuEstado) {
		this.txtUsuEstado = txtUsuEstado;
	}

	public InputText getTxtUsuModifica() {
		return txtUsuModifica;
	}

	public void setTxtUsuModifica(InputText txtUsuModifica) {
		this.txtUsuModifica = txtUsuModifica;
	}

	public String getTxtUsuNombre() {
		return txtUsuNombre;
	}

	public void setTxtUsuNombre(String txtUsuNombre) {
		this.txtUsuNombre = txtUsuNombre;
	}

	public InputText getTxtRolCodigo_Roles() {
		return txtRolCodigo_Roles;
	}

	public void setTxtRolCodigo_Roles(InputText txtRolCodigo_Roles) {
		this.txtRolCodigo_Roles = txtRolCodigo_Roles;
	}

	public Calendar getTxtUsuFechaCreacion() {
		return txtUsuFechaCreacion;
	}

	public void setTxtUsuFechaCreacion(Calendar txtUsuFechaCreacion) {
		this.txtUsuFechaCreacion = txtUsuFechaCreacion;
	}

	public Calendar getTxtUsuFechaModifica() {
		return txtUsuFechaModifica;
	}

	public void setTxtUsuFechaModifica(Calendar txtUsuFechaModifica) {
		this.txtUsuFechaModifica = txtUsuFechaModifica;
	}

	public InputText getTxtUsuCodigo() {
		return txtUsuCodigo;
	}

	public void setTxtUsuCodigo(InputText txtUsuCodigo) {
		this.txtUsuCodigo = txtUsuCodigo;
	}

	public List<UsuariosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataUsuarios();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<UsuariosDTO> usuariosDTO) {
		this.data = usuariosDTO;
	}

	public UsuariosDTO getusuario() {
		return usuario;
	}

	public void setusuario(UsuariosDTO usuarios) {
		this.usuario = usuarios;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public UsuariosDTO getSelectedUsuarios() {
		return selectedUsuarios;
	}

	public void setSelectedUsuarios(UsuariosDTO selectedUsuarios) {
		this.selectedUsuarios = selectedUsuarios;
	}
}
