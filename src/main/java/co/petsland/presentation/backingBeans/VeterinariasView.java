package co.petsland.presentation.backingBeans;

import co.petsland.datamodel.VeterinariasDataModel;
import co.petsland.exceptions.*;
import co.petsland.model.*;
import co.petsland.model.dto.UsuariosDTO;
import co.petsland.model.dto.VeterinariasDTO;
import co.petsland.presentation.businessDelegate.*;
import co.petsland.utilities.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class VeterinariasView implements Serializable {
	private static final long serialVersionUID = 1L;
	private InputText txtVetDireccion;
	private InputText txtVetEstado;
	private InputText txtVetNombre;
	private InputText txtVetTelefono;
	private InputText txtVetUrl;
	private InputText txtVetUsuCrea;
	private InputText txtVetUsuModifica;
	private InputText txtVetCodigo;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<VeterinariasDTO> data;
	private List<VeterinariasDTO> listaVeterinarias;
	private VeterinariasDTO selectedVeterinarias;
	private Veterinarias entity;
	private boolean showDialog;
	private boolean guardar;
	private String estado;
	private VeterinariasDataModel veterinariaDataModel;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private UsuariosDTO usuario;

	private static Session session;
	private static ServiceRegistry serviceRegistry;
	
	public VeterinariasView() {
		super();
	}
	
	@PostConstruct
    public void traerUsuarios(){
		
		usuario=(UsuariosDTO) FacesUtils.getManagedBeanFromSession("usuario");
				
    }
	

	/*
	 * public void rowEventListener(RowEditEvent e) { try { VeterinariasDTO
	 * veterinariasDTO = (VeterinariasDTO) e.getObject();
	 * 
	 * if (txtVetDireccion == null) { txtVetDireccion = new InputText(); }
	 * 
	 * txtVetDireccion.setValue(veterinariasDTO.getVetDireccion());
	 * 
	 * if (txtVetEstado == null) { txtVetEstado = new InputText(); }
	 * 
	 * txtVetEstado.setValue(veterinariasDTO.getVetEstado());
	 * 
	 * if (txtVetNombre == null) { txtVetNombre = new InputText(); }
	 * 
	 * txtVetNombre.setValue(veterinariasDTO.getVetNombre());
	 * 
	 * if (txtVetTelefono == null) { txtVetTelefono = new InputText(); }
	 * 
	 * txtVetTelefono.setValue(veterinariasDTO.getVetTelefono());
	 * 
	 * if (txtVetUrl == null) { txtVetUrl = new InputText(); }
	 * 
	 * txtVetUrl.setValue(veterinariasDTO.getVetUrl());
	 * 
	 * if (txtVetUsuCrea == null) { txtVetUsuCrea = new InputText(); }
	 * 
	 * txtVetUsuCrea.setValue(veterinariasDTO.getVetUsuCrea());
	 * 
	 * if (txtVetUsuModifica == null) { txtVetUsuModifica = new InputText(); }
	 * 
	 * txtVetUsuModifica.setValue(veterinariasDTO.getVetUsuModifica());
	 * 
	 * if (txtVetCodigo == null) { txtVetCodigo = new InputText(); }
	 * 
	 * txtVetCodigo.setValue(veterinariasDTO.getVetCodigo());
	 * 
	 * Long vetCodigo = FacesUtils.checkLong(txtVetCodigo); entity =
	 * businessDelegatorView.getVeterinarias(vetCodigo);
	 * 
	 * action_modify(); } catch (Exception ex) { } }
	 * 
	 * public String action_new() { action_clear(); selectedVeterinarias = null;
	 * setShowDialog(true);
	 * 
	 * return ""; }
	 * 
	 * public String action_clear() { entity = null; selectedVeterinarias =
	 * null;
	 * 
	 * if (txtVetDireccion != null) { txtVetDireccion.setValue(null);
	 * txtVetDireccion.setDisabled(true); }
	 * 
	 * if (txtVetEstado != null) { txtVetEstado.setValue(null);
	 * txtVetEstado.setDisabled(true); }
	 * 
	 * if (txtVetNombre != null) { txtVetNombre.setValue(null);
	 * txtVetNombre.setDisabled(true); }
	 * 
	 * if (txtVetTelefono != null) { txtVetTelefono.setValue(null);
	 * txtVetTelefono.setDisabled(true); }
	 * 
	 * if (txtVetUrl != null) { txtVetUrl.setValue(null);
	 * txtVetUrl.setDisabled(true); }
	 * 
	 * if (txtVetUsuCrea != null) { txtVetUsuCrea.setValue(null);
	 * txtVetUsuCrea.setDisabled(true); }
	 * 
	 * if (txtVetUsuModifica != null) { txtVetUsuModifica.setValue(null);
	 * txtVetUsuModifica.setDisabled(true); }
	 * 
	 * if (txtVetCodigo != null) { txtVetCodigo.setValue(null);
	 * txtVetCodigo.setDisabled(false); }
	 * 
	 * if (btnSave != null) { btnSave.setDisabled(true); }
	 * 
	 * if (btnDelete != null) { btnDelete.setDisabled(true); }
	 * 
	 * return ""; }
	 * 
	 * public void listener_txtId() { try { Long vetCodigo =
	 * FacesUtils.checkLong(txtVetCodigo); entity = (vetCodigo != null) ?
	 * businessDelegatorView.getVeterinarias(vetCodigo) : null; } catch
	 * (Exception e) { entity = null; }
	 * 
	 * if (entity == null) { txtVetDireccion.setDisabled(false);
	 * txtVetEstado.setDisabled(false); txtVetNombre.setDisabled(false);
	 * txtVetTelefono.setDisabled(false); txtVetUrl.setDisabled(false);
	 * txtVetUsuCrea.setDisabled(false); txtVetUsuModifica.setDisabled(false);
	 * txtVetCodigo.setDisabled(false); btnSave.setDisabled(false); } else {
	 * txtVetDireccion.setValue(entity.getVetDireccion());
	 * txtVetDireccion.setDisabled(false);
	 * txtVetEstado.setValue(entity.getVetEstado());
	 * txtVetEstado.setDisabled(false);
	 * txtVetNombre.setValue(entity.getVetNombre());
	 * txtVetNombre.setDisabled(false);
	 * txtVetTelefono.setValue(entity.getVetTelefono());
	 * txtVetTelefono.setDisabled(false);
	 * txtVetUrl.setValue(entity.getVetUrl()); txtVetUrl.setDisabled(false);
	 * txtVetUsuCrea.setValue(entity.getVetUsuCrea());
	 * txtVetUsuCrea.setDisabled(false);
	 * txtVetUsuModifica.setValue(entity.getVetUsuModifica());
	 * txtVetUsuModifica.setDisabled(false);
	 * txtVetCodigo.setValue(entity.getVetCodigo());
	 * txtVetCodigo.setDisabled(true); btnSave.setDisabled(false);
	 * 
	 * if (btnDelete != null) { btnDelete.setDisabled(false); } } }
	 * 
	 * public String action_edit(ActionEvent evt) { selectedVeterinarias =
	 * (VeterinariasDTO) (evt.getComponent() .getAttributes()
	 * .get("selectedVeterinarias"));
	 * txtVetDireccion.setValue(selectedVeterinarias.getVetDireccion());
	 * txtVetDireccion.setDisabled(false);
	 * txtVetEstado.setValue(selectedVeterinarias.getVetEstado());
	 * txtVetEstado.setDisabled(false);
	 * txtVetNombre.setValue(selectedVeterinarias.getVetNombre());
	 * txtVetNombre.setDisabled(false);
	 * txtVetTelefono.setValue(selectedVeterinarias.getVetTelefono());
	 * txtVetTelefono.setDisabled(false);
	 * txtVetUrl.setValue(selectedVeterinarias.getVetUrl());
	 * txtVetUrl.setDisabled(false);
	 * txtVetUsuCrea.setValue(selectedVeterinarias.getVetUsuCrea());
	 * txtVetUsuCrea.setDisabled(false);
	 * txtVetUsuModifica.setValue(selectedVeterinarias.getVetUsuModifica());
	 * txtVetUsuModifica.setDisabled(false);
	 * txtVetCodigo.setValue(selectedVeterinarias.getVetCodigo());
	 * txtVetCodigo.setDisabled(true); btnSave.setDisabled(false);
	 * setShowDialog(true);
	 * 
	 * return ""; }
	 */

	public String action_save() {
		try {
			if ((selectedVeterinarias == null) && (entity == null)) {
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
			entity = new Veterinarias();

			Long vetCodigo = FacesUtils.checkLong(txtVetCodigo);

			entity.setVetCodigo(vetCodigo);
			entity.setVetDireccion(FacesUtils.checkString(txtVetDireccion));
			entity.setVetEstado(FacesUtils.checkString(txtVetEstado));
			entity.setVetNombre(FacesUtils.checkString(txtVetNombre));
			entity.setVetTelefono(FacesUtils.checkString(txtVetTelefono));
			entity.setVetUrl(FacesUtils.checkString(txtVetUrl));
			entity.setVetUsuCrea(FacesUtils.checkString(txtVetUsuCrea));
			entity.setVetUsuModifica(FacesUtils.checkString(txtVetUsuModifica));
			businessDelegatorView.saveVeterinarias(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			//action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long vetCodigo = new Long(selectedVeterinarias.getVetCodigo());
				entity = businessDelegatorView.getVeterinarias(vetCodigo);
			}

			entity.setVetDireccion(FacesUtils.checkString(txtVetDireccion));
			entity.setVetEstado(FacesUtils.checkString(txtVetEstado));
			entity.setVetNombre(FacesUtils.checkString(txtVetNombre));
			entity.setVetTelefono(FacesUtils.checkString(txtVetTelefono));
			entity.setVetUrl(FacesUtils.checkString(txtVetUrl));
			entity.setVetUsuCrea(FacesUtils.checkString(txtVetUsuCrea));
			entity.setVetUsuModifica(FacesUtils.checkString(txtVetUsuModifica));
			businessDelegatorView.updateVeterinarias(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
/*
	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedVeterinarias = (VeterinariasDTO) (evt.getComponent()
					.getAttributes().get("selectedVeterinarias"));

			Long vetCodigo = new Long(selectedVeterinarias.getVetCodigo());
			entity = businessDelegatorView.getVeterinarias(vetCodigo);
			//action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}*/
	
	public String guardarVeterinaria() {

		try {

			if (btnModify.isDisabled() == false) {

				entity = new Veterinarias();
				
				entity.setVetEstado(estado);
				entity.setVetTelefono(FacesUtils.checkString(txtVetTelefono));
				entity.setVetDireccion(FacesUtils.checkString(txtVetDireccion));
				entity.setVetUsuCrea(usuario.getUsuEmail());
				entity.setVetNombre(FacesUtils.checkString(txtVetNombre));
				businessDelegatorView.saveVeterinarias(entity);				
				FacesUtils.addInfoMessage("Se guardo con exito la veterinaria");

				
			} else {

				entity = new Veterinarias();
				
				entity.setVetCodigo(selectedVeterinarias.getVetCodigo());
				entity.setVetEstado(estado);
				entity.setVetTelefono(FacesUtils.checkString(txtVetTelefono));
				entity.setVetDireccion(FacesUtils.checkString(txtVetDireccion));
				entity.setVetUsuCrea(usuario.getUsuEmail());
				entity.setVetUsuModifica(usuario.getUsuEmail());
				entity.setVetNombre(FacesUtils.checkString(txtVetNombre));
				businessDelegatorView.updateVeterinarias(entity);

				FacesUtils.addInfoMessage("Se modifico con exito la veterinaria");

			}
			data = null;

			veterinariaDataModel = new VeterinariasDataModel(getData());

			RequestContext.getCurrentInstance().update("formDlg2");

			try {
				selectedVeterinarias = data.get(0);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				System.out.println("Exception e" + e);
			}

			limpiar();

			RequestContext.getCurrentInstance().update("form:tabla");

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			System.out.println("e.getMessage()" + e.getMessage());
		}

		return "";

	}

	public String action_delete_master() {
		try {
			Long vetCodigo = FacesUtils.checkLong(txtVetCodigo);
			entity = businessDelegatorView.getVeterinarias(vetCodigo);
		//	action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	/*public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteVeterinarias(entity);
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
			selectedVeterinarias = (VeterinariasDTO) (evt.getComponent()
					.getAttributes().get("selectedVeterinarias"));

			Long vetCodigo = new Long(selectedVeterinarias.getVetCodigo());
			entity = businessDelegatorView.getVeterinarias(vetCodigo);
			businessDelegatorView.deleteVeterinarias(entity);
			data.remove(selectedVeterinarias);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}*/

	public String action_modifyWitDTO(Long vetCodigo, String vetDireccion,
			String vetEstado, String vetNombre, String vetTelefono,
			String vetUrl, String vetUsuCrea, String vetUsuModifica)
			throws Exception {
		try {
			entity.setVetDireccion(FacesUtils.checkString(vetDireccion));
			entity.setVetEstado(FacesUtils.checkString(vetEstado));
			entity.setVetNombre(FacesUtils.checkString(vetNombre));
			entity.setVetTelefono(FacesUtils.checkString(vetTelefono));
			entity.setVetUrl(FacesUtils.checkString(vetUrl));
			entity.setVetUsuCrea(FacesUtils.checkString(vetUsuCrea));
			entity.setVetUsuModifica(FacesUtils.checkString(vetUsuModifica));
			businessDelegatorView.updateVeterinarias(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("VeterinariasView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtVetDireccion() {
		return txtVetDireccion;
	}

	public void setTxtVetDireccion(InputText txtVetDireccion) {
		this.txtVetDireccion = txtVetDireccion;
	}

	public InputText getTxtVetEstado() {
		return txtVetEstado;
	}

	public void setTxtVetEstado(InputText txtVetEstado) {
		this.txtVetEstado = txtVetEstado;
	}

	public InputText getTxtVetNombre() {
		return txtVetNombre;
	}

	public void setTxtVetNombre(InputText txtVetNombre) {
		this.txtVetNombre = txtVetNombre;
	}

	public InputText getTxtVetTelefono() {
		return txtVetTelefono;
	}

	public void setTxtVetTelefono(InputText txtVetTelefono) {
		this.txtVetTelefono = txtVetTelefono;
	}

	public InputText getTxtVetUrl() {
		return txtVetUrl;
	}

	public void setTxtVetUrl(InputText txtVetUrl) {
		this.txtVetUrl = txtVetUrl;
	}

	public InputText getTxtVetUsuCrea() {
		return txtVetUsuCrea;
	}

	public void setTxtVetUsuCrea(InputText txtVetUsuCrea) {
		this.txtVetUsuCrea = txtVetUsuCrea;
	}

	public InputText getTxtVetUsuModifica() {
		return txtVetUsuModifica;
	}

	public void setTxtVetUsuModifica(InputText txtVetUsuModifica) {
		this.txtVetUsuModifica = txtVetUsuModifica;
	}

	public InputText getTxtVetCodigo() {
		return txtVetCodigo;
	}

	public void setTxtVetCodigo(InputText txtVetCodigo) {
		this.txtVetCodigo = txtVetCodigo;
	}

	public List<VeterinariasDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataVeterinarias();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<VeterinariasDTO> veterinariasDTO) {
		this.data = veterinariasDTO;
	}

	public VeterinariasDTO getSelectedVeterinarias() {
		return selectedVeterinarias;
	}

	public void setSelectedVeterinarias(VeterinariasDTO veterinarias) {
		this.selectedVeterinarias = veterinarias;
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

	public String limpiar() {

		txtVetNombre.setValue("");
		txtVetTelefono.setValue("");
		txtVetDireccion.setValue("");
		estado = "R";

		btnModify.setDisabled(false);

		return "";
	}

	public String editar() {

		btnModify.setDisabled(true);

		if (selectedVeterinarias != null) {
			txtVetNombre.setValue(selectedVeterinarias.getVetNombre());
			txtVetTelefono.setValue(selectedVeterinarias.getVetTelefono());
			txtVetDireccion.setValue(selectedVeterinarias.getVetDireccion());
			estado = selectedVeterinarias.getVetEstado();
		} else {
			FacesUtils
					.addErrorMessage("No ha seleccionado ninguna Veterinaria");
		}

		return "";
	}

	public VeterinariasDataModel getVeterinariaDataModel() {
		if (veterinariaDataModel == null) {
			veterinariaDataModel = new VeterinariasDataModel(getData());
			try {
				selectedVeterinarias = data.get(0);
			} catch (Exception e) {
			}
		}
		return veterinariaDataModel;
	}

	public void setVeterinariaDataModel(
			VeterinariasDataModel veterinariaDataModel) {
		this.veterinariaDataModel = veterinariaDataModel;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isGuardar() {
		return guardar;
	}

	public void setGuardar(boolean guardar) {
		this.guardar = guardar;
	}

	public List<VeterinariasDTO> getListaVeterinarias() {
		try {
			if(listaVeterinarias==null){
				listaVeterinarias=businessDelegatorView.getDataVeterinarias();	
			}
			
		} catch (Exception e) {
			
		}

		return listaVeterinarias;
	}

	public void setListaVeterinarias(List<VeterinariasDTO> listaVeterinarias) {
		this.listaVeterinarias = listaVeterinarias;
	}
	
	private static void initSession() {
		Configuration configuration = new Configuration().configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();

		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	private static void endSession() {
		session.getTransaction().commit();
		session.close();

		StandardServiceRegistryBuilder.destroy(serviceRegistry);
	}

}
