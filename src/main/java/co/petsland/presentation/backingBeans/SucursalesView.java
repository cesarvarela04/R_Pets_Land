package co.petsland.presentation.backingBeans;

import co.petsland.exceptions.*;

import co.petsland.model.*;
import co.petsland.model.dto.SucursalesDTO;

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

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class SucursalesView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputText txtSucDireccion;
    private InputText txtSucTelefono;
    private InputText txtVetCodigo_Veterinarias;
    private InputText txtSucCodigo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<SucursalesDTO> data;
    private SucursalesDTO selectedSucursales;
    private Sucursales entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public SucursalesView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            SucursalesDTO sucursalesDTO = (SucursalesDTO) e.getObject();

            if (txtSucDireccion == null) {
                txtSucDireccion = new InputText();
            }

            txtSucDireccion.setValue(sucursalesDTO.getSucDireccion());

            if (txtSucTelefono == null) {
                txtSucTelefono = new InputText();
            }

            txtSucTelefono.setValue(sucursalesDTO.getSucTelefono());

            if (txtVetCodigo_Veterinarias == null) {
                txtVetCodigo_Veterinarias = new InputText();
            }

            txtVetCodigo_Veterinarias.setValue(sucursalesDTO.getVetCodigo_Veterinarias());

            if (txtSucCodigo == null) {
                txtSucCodigo = new InputText();
            }

            txtSucCodigo.setValue(sucursalesDTO.getSucCodigo());

            Long sucCodigo = FacesUtils.checkLong(txtSucCodigo);
            entity = businessDelegatorView.getSucursales(sucCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedSucursales = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedSucursales = null;

        if (txtSucDireccion != null) {
            txtSucDireccion.setValue(null);
            txtSucDireccion.setDisabled(true);
        }

        if (txtSucTelefono != null) {
            txtSucTelefono.setValue(null);
            txtSucTelefono.setDisabled(true);
        }

        if (txtVetCodigo_Veterinarias != null) {
            txtVetCodigo_Veterinarias.setValue(null);
            txtVetCodigo_Veterinarias.setDisabled(true);
        }

        if (txtSucCodigo != null) {
            txtSucCodigo.setValue(null);
            txtSucCodigo.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Long sucCodigo = FacesUtils.checkLong(txtSucCodigo);
            entity = (sucCodigo != null)
                ? businessDelegatorView.getSucursales(sucCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtSucDireccion.setDisabled(false);
            txtSucTelefono.setDisabled(false);
            txtVetCodigo_Veterinarias.setDisabled(false);
            txtSucCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtSucDireccion.setValue(entity.getSucDireccion());
            txtSucDireccion.setDisabled(false);
            txtSucTelefono.setValue(entity.getSucTelefono());
            txtSucTelefono.setDisabled(false);
            txtVetCodigo_Veterinarias.setValue(entity.getVeterinarias()
                                                     .getVetCodigo());
            txtVetCodigo_Veterinarias.setDisabled(false);
            txtSucCodigo.setValue(entity.getSucCodigo());
            txtSucCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedSucursales = (SucursalesDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedSucursales"));
        txtSucDireccion.setValue(selectedSucursales.getSucDireccion());
        txtSucDireccion.setDisabled(false);
        txtSucTelefono.setValue(selectedSucursales.getSucTelefono());
        txtSucTelefono.setDisabled(false);
        txtVetCodigo_Veterinarias.setValue(selectedSucursales.getVetCodigo_Veterinarias());
        txtVetCodigo_Veterinarias.setDisabled(false);
        txtSucCodigo.setValue(selectedSucursales.getSucCodigo());
        txtSucCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedSucursales == null) && (entity == null)) {
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
            entity = new Sucursales();

            Long sucCodigo = FacesUtils.checkLong(txtSucCodigo);

            entity.setSucCodigo(sucCodigo);
            entity.setSucDireccion(FacesUtils.checkString(txtSucDireccion));
            entity.setSucTelefono(FacesUtils.checkString(txtSucTelefono));
            entity.setVeterinarias((FacesUtils.checkLong(
                    txtVetCodigo_Veterinarias) != null)
                ? businessDelegatorView.getVeterinarias(FacesUtils.checkLong(
                        txtVetCodigo_Veterinarias)) : null);
            businessDelegatorView.saveSucursales(entity);
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
                Long sucCodigo = new Long(selectedSucursales.getSucCodigo());
                entity = businessDelegatorView.getSucursales(sucCodigo);
            }

            entity.setSucDireccion(FacesUtils.checkString(txtSucDireccion));
            entity.setSucTelefono(FacesUtils.checkString(txtSucTelefono));
            entity.setVeterinarias((FacesUtils.checkLong(
                    txtVetCodigo_Veterinarias) != null)
                ? businessDelegatorView.getVeterinarias(FacesUtils.checkLong(
                        txtVetCodigo_Veterinarias)) : null);
            businessDelegatorView.updateSucursales(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedSucursales = (SucursalesDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedSucursales"));

            Long sucCodigo = new Long(selectedSucursales.getSucCodigo());
            entity = businessDelegatorView.getSucursales(sucCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long sucCodigo = FacesUtils.checkLong(txtSucCodigo);
            entity = businessDelegatorView.getSucursales(sucCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteSucursales(entity);
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
            selectedSucursales = (SucursalesDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedSucursales"));

            Long sucCodigo = new Long(selectedSucursales.getSucCodigo());
            entity = businessDelegatorView.getSucursales(sucCodigo);
            businessDelegatorView.deleteSucursales(entity);
            data.remove(selectedSucursales);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long sucCodigo, String sucDireccion,
        String sucTelefono, Long vetCodigo_Veterinarias)
        throws Exception {
        try {
            entity.setSucDireccion(FacesUtils.checkString(sucDireccion));
            entity.setSucTelefono(FacesUtils.checkString(sucTelefono));
            businessDelegatorView.updateSucursales(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("SucursalesView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtSucDireccion() {
        return txtSucDireccion;
    }

    public void setTxtSucDireccion(InputText txtSucDireccion) {
        this.txtSucDireccion = txtSucDireccion;
    }

    public InputText getTxtSucTelefono() {
        return txtSucTelefono;
    }

    public void setTxtSucTelefono(InputText txtSucTelefono) {
        this.txtSucTelefono = txtSucTelefono;
    }

    public InputText getTxtVetCodigo_Veterinarias() {
        return txtVetCodigo_Veterinarias;
    }

    public void setTxtVetCodigo_Veterinarias(
        InputText txtVetCodigo_Veterinarias) {
        this.txtVetCodigo_Veterinarias = txtVetCodigo_Veterinarias;
    }

    public InputText getTxtSucCodigo() {
        return txtSucCodigo;
    }

    public void setTxtSucCodigo(InputText txtSucCodigo) {
        this.txtSucCodigo = txtSucCodigo;
    }

    public List<SucursalesDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataSucursales();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<SucursalesDTO> sucursalesDTO) {
        this.data = sucursalesDTO;
    }

    public SucursalesDTO getSelectedSucursales() {
        return selectedSucursales;
    }

    public void setSelectedSucursales(SucursalesDTO sucursales) {
        this.selectedSucursales = sucursales;
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
}
