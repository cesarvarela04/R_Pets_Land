package co.petsland.presentation.backingBeans;

import co.petsland.exceptions.*;

import co.petsland.model.*;
import co.petsland.model.dto.VetsServsDTO;

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
public class VetsServsView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputText txtVsEstado;
    private InputText txtSerCodigo_Servicios;
    private InputText txtVetCodigo_Veterinarias;
    private InputText txtVsCodigo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<VetsServsDTO> data;
    private VetsServsDTO selectedVetsServs;
    private VetsServs entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    
    
    public VetsServsView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            VetsServsDTO vetsServsDTO = (VetsServsDTO) e.getObject();

            if (txtVsEstado == null) {
                txtVsEstado = new InputText();
            }

            txtVsEstado.setValue(vetsServsDTO.getVsEstado());

            if (txtSerCodigo_Servicios == null) {
                txtSerCodigo_Servicios = new InputText();
            }

            txtSerCodigo_Servicios.setValue(vetsServsDTO.getSerCodigo_Servicios());

            if (txtVetCodigo_Veterinarias == null) {
                txtVetCodigo_Veterinarias = new InputText();
            }

            txtVetCodigo_Veterinarias.setValue(vetsServsDTO.getVetCodigo_Veterinarias());

            if (txtVsCodigo == null) {
                txtVsCodigo = new InputText();
            }

            txtVsCodigo.setValue(vetsServsDTO.getVsCodigo());

            Long vsCodigo = FacesUtils.checkLong(txtVsCodigo);
            entity = businessDelegatorView.getVetsServs(vsCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedVetsServs = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedVetsServs = null;

        if (txtVsEstado != null) {
            txtVsEstado.setValue(null);
            txtVsEstado.setDisabled(true);
        }

        if (txtSerCodigo_Servicios != null) {
            txtSerCodigo_Servicios.setValue(null);
            txtSerCodigo_Servicios.setDisabled(true);
        }

        if (txtVetCodigo_Veterinarias != null) {
            txtVetCodigo_Veterinarias.setValue(null);
            txtVetCodigo_Veterinarias.setDisabled(true);
        }

        if (txtVsCodigo != null) {
            txtVsCodigo.setValue(null);
            txtVsCodigo.setDisabled(false);
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
            Long vsCodigo = FacesUtils.checkLong(txtVsCodigo);
            entity = (vsCodigo != null)
                ? businessDelegatorView.getVetsServs(vsCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtVsEstado.setDisabled(false);
            txtSerCodigo_Servicios.setDisabled(false);
            txtVetCodigo_Veterinarias.setDisabled(false);
            txtVsCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtVsEstado.setValue(entity.getVsEstado());
            txtVsEstado.setDisabled(false);
            txtSerCodigo_Servicios.setValue(entity.getServicios().getSerCodigo());
            txtSerCodigo_Servicios.setDisabled(false);
            txtVetCodigo_Veterinarias.setValue(entity.getVeterinarias()
                                                     .getVetCodigo());
            txtVetCodigo_Veterinarias.setDisabled(false);
            txtVsCodigo.setValue(entity.getVsCodigo());
            txtVsCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedVetsServs = (VetsServsDTO) (evt.getComponent().getAttributes()
                                               .get("selectedVetsServs"));
        txtVsEstado.setValue(selectedVetsServs.getVsEstado());
        txtVsEstado.setDisabled(false);
        txtSerCodigo_Servicios.setValue(selectedVetsServs.getSerCodigo_Servicios());
        txtSerCodigo_Servicios.setDisabled(false);
        txtVetCodigo_Veterinarias.setValue(selectedVetsServs.getVetCodigo_Veterinarias());
        txtVetCodigo_Veterinarias.setDisabled(false);
        txtVsCodigo.setValue(selectedVetsServs.getVsCodigo());
        txtVsCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedVetsServs == null) && (entity == null)) {
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
            entity = new VetsServs();

            Long vsCodigo = FacesUtils.checkLong(txtVsCodigo);

            entity.setVsCodigo(vsCodigo);
            entity.setVsEstado(FacesUtils.checkString(txtVsEstado));
            entity.setServicios((FacesUtils.checkLong(txtSerCodigo_Servicios) != null)
                ? businessDelegatorView.getServicios(FacesUtils.checkLong(
                        txtSerCodigo_Servicios)) : null);
            entity.setVeterinarias((FacesUtils.checkLong(
                    txtVetCodigo_Veterinarias) != null)
                ? businessDelegatorView.getVeterinarias(FacesUtils.checkLong(
                        txtVetCodigo_Veterinarias)) : null);
            businessDelegatorView.saveVetsServs(entity);
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
                Long vsCodigo = new Long(selectedVetsServs.getVsCodigo());
                entity = businessDelegatorView.getVetsServs(vsCodigo);
            }

            entity.setVsEstado(FacesUtils.checkString(txtVsEstado));
            entity.setServicios((FacesUtils.checkLong(txtSerCodigo_Servicios) != null)
                ? businessDelegatorView.getServicios(FacesUtils.checkLong(
                        txtSerCodigo_Servicios)) : null);
            entity.setVeterinarias((FacesUtils.checkLong(
                    txtVetCodigo_Veterinarias) != null)
                ? businessDelegatorView.getVeterinarias(FacesUtils.checkLong(
                        txtVetCodigo_Veterinarias)) : null);
            businessDelegatorView.updateVetsServs(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedVetsServs = (VetsServsDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedVetsServs"));

            Long vsCodigo = new Long(selectedVetsServs.getVsCodigo());
            entity = businessDelegatorView.getVetsServs(vsCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long vsCodigo = FacesUtils.checkLong(txtVsCodigo);
            entity = businessDelegatorView.getVetsServs(vsCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteVetsServs(entity);
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
            selectedVetsServs = (VetsServsDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedVetsServs"));

            Long vsCodigo = new Long(selectedVetsServs.getVsCodigo());
            entity = businessDelegatorView.getVetsServs(vsCodigo);
            businessDelegatorView.deleteVetsServs(entity);
            data.remove(selectedVetsServs);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long vsCodigo, String vsEstado,
        Long serCodigo_Servicios, Long vetCodigo_Veterinarias)
        throws Exception {
        try {
            entity.setVsEstado(FacesUtils.checkString(vsEstado));
            businessDelegatorView.updateVetsServs(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("VetsServsView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtVsEstado() {
        return txtVsEstado;
    }

    public void setTxtVsEstado(InputText txtVsEstado) {
        this.txtVsEstado = txtVsEstado;
    }

    public InputText getTxtSerCodigo_Servicios() {
        return txtSerCodigo_Servicios;
    }

    public void setTxtSerCodigo_Servicios(InputText txtSerCodigo_Servicios) {
        this.txtSerCodigo_Servicios = txtSerCodigo_Servicios;
    }

    public InputText getTxtVetCodigo_Veterinarias() {
        return txtVetCodigo_Veterinarias;
    }

    public void setTxtVetCodigo_Veterinarias(
        InputText txtVetCodigo_Veterinarias) {
        this.txtVetCodigo_Veterinarias = txtVetCodigo_Veterinarias;
    }

    public InputText getTxtVsCodigo() {
        return txtVsCodigo;
    }

    public void setTxtVsCodigo(InputText txtVsCodigo) {
        this.txtVsCodigo = txtVsCodigo;
    }

    public List<VetsServsDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataVetsServs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<VetsServsDTO> vetsServsDTO) {
        this.data = vetsServsDTO;
    }

    public VetsServsDTO getSelectedVetsServs() {
        return selectedVetsServs;
    }

    public void setSelectedVetsServs(VetsServsDTO vetsServs) {
        this.selectedVetsServs = vetsServs;
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
