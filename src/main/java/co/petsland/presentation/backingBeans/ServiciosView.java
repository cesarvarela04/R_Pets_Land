package co.petsland.presentation.backingBeans;

import co.petsland.exceptions.*;

import co.petsland.model.*;
import co.petsland.model.dto.ServiciosDTO;

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
public class ServiciosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputText txtSerEstado;
    private InputText txtSerNombre;
    private InputText txtSerUsuCrea;
    private InputText txtSerUsuModifica;
    private InputText txtSerCodigo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ServiciosDTO> data;
    private ServiciosDTO selectedServicios;
    private Servicios entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ServiciosView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ServiciosDTO serviciosDTO = (ServiciosDTO) e.getObject();

            if (txtSerEstado == null) {
                txtSerEstado = new InputText();
            }

            txtSerEstado.setValue(serviciosDTO.getSerEstado());

            if (txtSerNombre == null) {
                txtSerNombre = new InputText();
            }

            txtSerNombre.setValue(serviciosDTO.getSerNombre());

            if (txtSerUsuCrea == null) {
                txtSerUsuCrea = new InputText();
            }

            txtSerUsuCrea.setValue(serviciosDTO.getSerUsuCrea());

            if (txtSerUsuModifica == null) {
                txtSerUsuModifica = new InputText();
            }

            txtSerUsuModifica.setValue(serviciosDTO.getSerUsuModifica());

            if (txtSerCodigo == null) {
                txtSerCodigo = new InputText();
            }

            txtSerCodigo.setValue(serviciosDTO.getSerCodigo());

            Long serCodigo = FacesUtils.checkLong(txtSerCodigo);
            entity = businessDelegatorView.getServicios(serCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedServicios = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedServicios = null;

        if (txtSerEstado != null) {
            txtSerEstado.setValue(null);
            txtSerEstado.setDisabled(true);
        }

        if (txtSerNombre != null) {
            txtSerNombre.setValue(null);
            txtSerNombre.setDisabled(true);
        }

        if (txtSerUsuCrea != null) {
            txtSerUsuCrea.setValue(null);
            txtSerUsuCrea.setDisabled(true);
        }

        if (txtSerUsuModifica != null) {
            txtSerUsuModifica.setValue(null);
            txtSerUsuModifica.setDisabled(true);
        }

        if (txtSerCodigo != null) {
            txtSerCodigo.setValue(null);
            txtSerCodigo.setDisabled(false);
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
            Long serCodigo = FacesUtils.checkLong(txtSerCodigo);
            entity = (serCodigo != null)
                ? businessDelegatorView.getServicios(serCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtSerEstado.setDisabled(false);
            txtSerNombre.setDisabled(false);
            txtSerUsuCrea.setDisabled(false);
            txtSerUsuModifica.setDisabled(false);
            txtSerCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtSerEstado.setValue(entity.getSerEstado());
            txtSerEstado.setDisabled(false);
            txtSerNombre.setValue(entity.getSerNombre());
            txtSerNombre.setDisabled(false);
            txtSerUsuCrea.setValue(entity.getSerUsuCrea());
            txtSerUsuCrea.setDisabled(false);
            txtSerUsuModifica.setValue(entity.getSerUsuModifica());
            txtSerUsuModifica.setDisabled(false);
            txtSerCodigo.setValue(entity.getSerCodigo());
            txtSerCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedServicios = (ServiciosDTO) (evt.getComponent().getAttributes()
                                               .get("selectedServicios"));
        txtSerEstado.setValue(selectedServicios.getSerEstado());
        txtSerEstado.setDisabled(false);
        txtSerNombre.setValue(selectedServicios.getSerNombre());
        txtSerNombre.setDisabled(false);
        txtSerUsuCrea.setValue(selectedServicios.getSerUsuCrea());
        txtSerUsuCrea.setDisabled(false);
        txtSerUsuModifica.setValue(selectedServicios.getSerUsuModifica());
        txtSerUsuModifica.setDisabled(false);
        txtSerCodigo.setValue(selectedServicios.getSerCodigo());
        txtSerCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedServicios == null) && (entity == null)) {
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
            entity = new Servicios();

            Long serCodigo = FacesUtils.checkLong(txtSerCodigo);

            entity.setSerCodigo(serCodigo);
            entity.setSerEstado(FacesUtils.checkString(txtSerEstado));
            entity.setSerNombre(FacesUtils.checkString(txtSerNombre));
            entity.setSerUsuCrea(FacesUtils.checkString(txtSerUsuCrea));
            entity.setSerUsuModifica(FacesUtils.checkString(txtSerUsuModifica));
            businessDelegatorView.saveServicios(entity);
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
                Long serCodigo = new Long(selectedServicios.getSerCodigo());
                entity = businessDelegatorView.getServicios(serCodigo);
            }

            entity.setSerEstado(FacesUtils.checkString(txtSerEstado));
            entity.setSerNombre(FacesUtils.checkString(txtSerNombre));
            entity.setSerUsuCrea(FacesUtils.checkString(txtSerUsuCrea));
            entity.setSerUsuModifica(FacesUtils.checkString(txtSerUsuModifica));
            businessDelegatorView.updateServicios(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedServicios = (ServiciosDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedServicios"));

            Long serCodigo = new Long(selectedServicios.getSerCodigo());
            entity = businessDelegatorView.getServicios(serCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long serCodigo = FacesUtils.checkLong(txtSerCodigo);
            entity = businessDelegatorView.getServicios(serCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteServicios(entity);
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
            selectedServicios = (ServiciosDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedServicios"));

            Long serCodigo = new Long(selectedServicios.getSerCodigo());
            entity = businessDelegatorView.getServicios(serCodigo);
            businessDelegatorView.deleteServicios(entity);
            data.remove(selectedServicios);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long serCodigo, String serEstado,
        String serNombre, String serUsuCrea, String serUsuModifica)
        throws Exception {
        try {
            entity.setSerEstado(FacesUtils.checkString(serEstado));
            entity.setSerNombre(FacesUtils.checkString(serNombre));
            entity.setSerUsuCrea(FacesUtils.checkString(serUsuCrea));
            entity.setSerUsuModifica(FacesUtils.checkString(serUsuModifica));
            businessDelegatorView.updateServicios(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ServiciosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtSerEstado() {
        return txtSerEstado;
    }

    public void setTxtSerEstado(InputText txtSerEstado) {
        this.txtSerEstado = txtSerEstado;
    }

    public InputText getTxtSerNombre() {
        return txtSerNombre;
    }

    public void setTxtSerNombre(InputText txtSerNombre) {
        this.txtSerNombre = txtSerNombre;
    }

    public InputText getTxtSerUsuCrea() {
        return txtSerUsuCrea;
    }

    public void setTxtSerUsuCrea(InputText txtSerUsuCrea) {
        this.txtSerUsuCrea = txtSerUsuCrea;
    }

    public InputText getTxtSerUsuModifica() {
        return txtSerUsuModifica;
    }

    public void setTxtSerUsuModifica(InputText txtSerUsuModifica) {
        this.txtSerUsuModifica = txtSerUsuModifica;
    }

    public InputText getTxtSerCodigo() {
        return txtSerCodigo;
    }

    public void setTxtSerCodigo(InputText txtSerCodigo) {
        this.txtSerCodigo = txtSerCodigo;
    }

    public List<ServiciosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataServicios();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ServiciosDTO> serviciosDTO) {
        this.data = serviciosDTO;
    }

    public ServiciosDTO getSelectedServicios() {
        return selectedServicios;
    }

    public void setSelectedServicios(ServiciosDTO servicios) {
        this.selectedServicios = servicios;
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
