package co.petsland.presentation.backingBeans;

import co.petsland.exceptions.*;

import co.petsland.model.*;
import co.petsland.model.dto.EventosVeterinariasDTO;

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
public class EventosVeterinariasView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputText txtEvFavorito;
    private InputText txtEvMegusta;
    private InputText txtUsuCodigo_Usuarios;
    private InputText txtVetCodigo_Veterinarias;
    private InputText txtEvCodigo;
    private Calendar txtEvFechaf;
    private Calendar txtEvFechamg;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<EventosVeterinariasDTO> data;
    private EventosVeterinariasDTO selectedEventosVeterinarias;
    private EventosVeterinarias entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public EventosVeterinariasView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            EventosVeterinariasDTO eventosVeterinariasDTO = (EventosVeterinariasDTO) e.getObject();

            if (txtEvFavorito == null) {
                txtEvFavorito = new InputText();
            }

            txtEvFavorito.setValue(eventosVeterinariasDTO.getEvFavorito());

            if (txtEvMegusta == null) {
                txtEvMegusta = new InputText();
            }

            txtEvMegusta.setValue(eventosVeterinariasDTO.getEvMegusta());

            if (txtUsuCodigo_Usuarios == null) {
                txtUsuCodigo_Usuarios = new InputText();
            }

            txtUsuCodigo_Usuarios.setValue(eventosVeterinariasDTO.getUsuCodigo_Usuarios());

            if (txtVetCodigo_Veterinarias == null) {
                txtVetCodigo_Veterinarias = new InputText();
            }

            txtVetCodigo_Veterinarias.setValue(eventosVeterinariasDTO.getVetCodigo_Veterinarias());

            if (txtEvCodigo == null) {
                txtEvCodigo = new InputText();
            }

            txtEvCodigo.setValue(eventosVeterinariasDTO.getEvCodigo());

            if (txtEvFechaf == null) {
                txtEvFechaf = new Calendar();
            }

            txtEvFechaf.setValue(eventosVeterinariasDTO.getEvFechaf());

            if (txtEvFechamg == null) {
                txtEvFechamg = new Calendar();
            }

            txtEvFechamg.setValue(eventosVeterinariasDTO.getEvFechamg());

            Long evCodigo = FacesUtils.checkLong(txtEvCodigo);
            entity = businessDelegatorView.getEventosVeterinarias(evCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedEventosVeterinarias = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedEventosVeterinarias = null;

        if (txtEvFavorito != null) {
            txtEvFavorito.setValue(null);
            txtEvFavorito.setDisabled(true);
        }

        if (txtEvMegusta != null) {
            txtEvMegusta.setValue(null);
            txtEvMegusta.setDisabled(true);
        }

        if (txtUsuCodigo_Usuarios != null) {
            txtUsuCodigo_Usuarios.setValue(null);
            txtUsuCodigo_Usuarios.setDisabled(true);
        }

        if (txtVetCodigo_Veterinarias != null) {
            txtVetCodigo_Veterinarias.setValue(null);
            txtVetCodigo_Veterinarias.setDisabled(true);
        }

        if (txtEvFechaf != null) {
            txtEvFechaf.setValue(null);
            txtEvFechaf.setDisabled(true);
        }

        if (txtEvFechamg != null) {
            txtEvFechamg.setValue(null);
            txtEvFechamg.setDisabled(true);
        }

        if (txtEvCodigo != null) {
            txtEvCodigo.setValue(null);
            txtEvCodigo.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtEvFechaf() {
        Date inputDate = (Date) txtEvFechaf.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtEvFechamg() {
        Date inputDate = (Date) txtEvFechamg.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Long evCodigo = FacesUtils.checkLong(txtEvCodigo);
            entity = (evCodigo != null)
                ? businessDelegatorView.getEventosVeterinarias(evCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEvFavorito.setDisabled(false);
            txtEvMegusta.setDisabled(false);
            txtUsuCodigo_Usuarios.setDisabled(false);
            txtVetCodigo_Veterinarias.setDisabled(false);
            txtEvFechaf.setDisabled(false);
            txtEvFechamg.setDisabled(false);
            txtEvCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtEvFavorito.setValue(entity.getEvFavorito());
            txtEvFavorito.setDisabled(false);
            txtEvFechaf.setValue(entity.getEvFechaf());
            txtEvFechaf.setDisabled(false);
            txtEvFechamg.setValue(entity.getEvFechamg());
            txtEvFechamg.setDisabled(false);
            txtEvMegusta.setValue(entity.getEvMegusta());
            txtEvMegusta.setDisabled(false);
            txtUsuCodigo_Usuarios.setValue(entity.getUsuarios().getUsuCodigo());
            txtUsuCodigo_Usuarios.setDisabled(false);
            txtVetCodigo_Veterinarias.setValue(entity.getVeterinarias()
                                                     .getVetCodigo());
            txtVetCodigo_Veterinarias.setDisabled(false);
            txtEvCodigo.setValue(entity.getEvCodigo());
            txtEvCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedEventosVeterinarias = (EventosVeterinariasDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedEventosVeterinarias"));
        txtEvFavorito.setValue(selectedEventosVeterinarias.getEvFavorito());
        txtEvFavorito.setDisabled(false);
        txtEvFechaf.setValue(selectedEventosVeterinarias.getEvFechaf());
        txtEvFechaf.setDisabled(false);
        txtEvFechamg.setValue(selectedEventosVeterinarias.getEvFechamg());
        txtEvFechamg.setDisabled(false);
        txtEvMegusta.setValue(selectedEventosVeterinarias.getEvMegusta());
        txtEvMegusta.setDisabled(false);
        txtUsuCodigo_Usuarios.setValue(selectedEventosVeterinarias.getUsuCodigo_Usuarios());
        txtUsuCodigo_Usuarios.setDisabled(false);
        txtVetCodigo_Veterinarias.setValue(selectedEventosVeterinarias.getVetCodigo_Veterinarias());
        txtVetCodigo_Veterinarias.setDisabled(false);
        txtEvCodigo.setValue(selectedEventosVeterinarias.getEvCodigo());
        txtEvCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedEventosVeterinarias == null) && (entity == null)) {
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
            entity = new EventosVeterinarias();

            Long evCodigo = FacesUtils.checkLong(txtEvCodigo);

            entity.setEvCodigo(evCodigo);
            entity.setEvFavorito(FacesUtils.checkString(txtEvFavorito));
            entity.setEvFechaf(FacesUtils.checkDate(txtEvFechaf));
            entity.setEvFechamg(FacesUtils.checkDate(txtEvFechamg));
            entity.setEvMegusta(FacesUtils.checkString(txtEvMegusta));
            entity.setUsuarios((FacesUtils.checkLong(txtUsuCodigo_Usuarios) != null)
                ? businessDelegatorView.getUsuarios(FacesUtils.checkLong(
                        txtUsuCodigo_Usuarios)) : null);
            entity.setVeterinarias((FacesUtils.checkLong(
                    txtVetCodigo_Veterinarias) != null)
                ? businessDelegatorView.getVeterinarias(FacesUtils.checkLong(
                        txtVetCodigo_Veterinarias)) : null);
            businessDelegatorView.saveEventosVeterinarias(entity);
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
                Long evCodigo = new Long(selectedEventosVeterinarias.getEvCodigo());
                entity = businessDelegatorView.getEventosVeterinarias(evCodigo);
            }

            entity.setEvFavorito(FacesUtils.checkString(txtEvFavorito));
            entity.setEvFechaf(FacesUtils.checkDate(txtEvFechaf));
            entity.setEvFechamg(FacesUtils.checkDate(txtEvFechamg));
            entity.setEvMegusta(FacesUtils.checkString(txtEvMegusta));
            entity.setUsuarios((FacesUtils.checkLong(txtUsuCodigo_Usuarios) != null)
                ? businessDelegatorView.getUsuarios(FacesUtils.checkLong(
                        txtUsuCodigo_Usuarios)) : null);
            entity.setVeterinarias((FacesUtils.checkLong(
                    txtVetCodigo_Veterinarias) != null)
                ? businessDelegatorView.getVeterinarias(FacesUtils.checkLong(
                        txtVetCodigo_Veterinarias)) : null);
            businessDelegatorView.updateEventosVeterinarias(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedEventosVeterinarias = (EventosVeterinariasDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedEventosVeterinarias"));

            Long evCodigo = new Long(selectedEventosVeterinarias.getEvCodigo());
            entity = businessDelegatorView.getEventosVeterinarias(evCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long evCodigo = FacesUtils.checkLong(txtEvCodigo);
            entity = businessDelegatorView.getEventosVeterinarias(evCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteEventosVeterinarias(entity);
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
            selectedEventosVeterinarias = (EventosVeterinariasDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedEventosVeterinarias"));

            Long evCodigo = new Long(selectedEventosVeterinarias.getEvCodigo());
            entity = businessDelegatorView.getEventosVeterinarias(evCodigo);
            businessDelegatorView.deleteEventosVeterinarias(entity);
            data.remove(selectedEventosVeterinarias);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long evCodigo, String evFavorito,
        Date evFechaf, Date evFechamg, String evMegusta,
        Long usuCodigo_Usuarios, Long vetCodigo_Veterinarias)
        throws Exception {
        try {
            entity.setEvFavorito(FacesUtils.checkString(evFavorito));
            entity.setEvFechaf(FacesUtils.checkDate(evFechaf));
            entity.setEvFechamg(FacesUtils.checkDate(evFechamg));
            entity.setEvMegusta(FacesUtils.checkString(evMegusta));
            businessDelegatorView.updateEventosVeterinarias(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("EventosVeterinariasView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEvFavorito() {
        return txtEvFavorito;
    }

    public void setTxtEvFavorito(InputText txtEvFavorito) {
        this.txtEvFavorito = txtEvFavorito;
    }

    public InputText getTxtEvMegusta() {
        return txtEvMegusta;
    }

    public void setTxtEvMegusta(InputText txtEvMegusta) {
        this.txtEvMegusta = txtEvMegusta;
    }

    public InputText getTxtUsuCodigo_Usuarios() {
        return txtUsuCodigo_Usuarios;
    }

    public void setTxtUsuCodigo_Usuarios(InputText txtUsuCodigo_Usuarios) {
        this.txtUsuCodigo_Usuarios = txtUsuCodigo_Usuarios;
    }

    public InputText getTxtVetCodigo_Veterinarias() {
        return txtVetCodigo_Veterinarias;
    }

    public void setTxtVetCodigo_Veterinarias(
        InputText txtVetCodigo_Veterinarias) {
        this.txtVetCodigo_Veterinarias = txtVetCodigo_Veterinarias;
    }

    public Calendar getTxtEvFechaf() {
        return txtEvFechaf;
    }

    public void setTxtEvFechaf(Calendar txtEvFechaf) {
        this.txtEvFechaf = txtEvFechaf;
    }

    public Calendar getTxtEvFechamg() {
        return txtEvFechamg;
    }

    public void setTxtEvFechamg(Calendar txtEvFechamg) {
        this.txtEvFechamg = txtEvFechamg;
    }

    public InputText getTxtEvCodigo() {
        return txtEvCodigo;
    }

    public void setTxtEvCodigo(InputText txtEvCodigo) {
        this.txtEvCodigo = txtEvCodigo;
    }

    public List<EventosVeterinariasDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataEventosVeterinarias();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<EventosVeterinariasDTO> eventosVeterinariasDTO) {
        this.data = eventosVeterinariasDTO;
    }

    public EventosVeterinariasDTO getSelectedEventosVeterinarias() {
        return selectedEventosVeterinarias;
    }

    public void setSelectedEventosVeterinarias(
        EventosVeterinariasDTO eventosVeterinarias) {
        this.selectedEventosVeterinarias = eventosVeterinarias;
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
