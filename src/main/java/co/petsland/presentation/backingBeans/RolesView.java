package co.petsland.presentation.backingBeans;

import co.petsland.exceptions.*;

import co.petsland.model.*;
import co.petsland.model.dto.RolesDTO;

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
public class RolesView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputText txtRolEstado;
    private InputText txtRolNombre;
    private InputText txtRolUsuCrea;
    private InputText txtRolUsuModifica;
    private InputText txtRolCodigo;
    private Calendar txtRolFechaCrea;
    private Calendar txtRolFechaModifica;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RolesDTO> data;
    private RolesDTO selectedRoles;
    private Roles entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RolesView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            RolesDTO rolesDTO = (RolesDTO) e.getObject();

            if (txtRolEstado == null) {
                txtRolEstado = new InputText();
            }

            txtRolEstado.setValue(rolesDTO.getRolEstado());

            if (txtRolNombre == null) {
                txtRolNombre = new InputText();
            }

            txtRolNombre.setValue(rolesDTO.getRolNombre());

            if (txtRolUsuCrea == null) {
                txtRolUsuCrea = new InputText();
            }

            txtRolUsuCrea.setValue(rolesDTO.getRolUsuCrea());

            if (txtRolUsuModifica == null) {
                txtRolUsuModifica = new InputText();
            }

            txtRolUsuModifica.setValue(rolesDTO.getRolUsuModifica());

            if (txtRolCodigo == null) {
                txtRolCodigo = new InputText();
            }

            txtRolCodigo.setValue(rolesDTO.getRolCodigo());

            if (txtRolFechaCrea == null) {
                txtRolFechaCrea = new Calendar();
            }

            txtRolFechaCrea.setValue(rolesDTO.getRolFechaCrea());

            if (txtRolFechaModifica == null) {
                txtRolFechaModifica = new Calendar();
            }

            txtRolFechaModifica.setValue(rolesDTO.getRolFechaModifica());

            Long rolCodigo = FacesUtils.checkLong(txtRolCodigo);
            entity = businessDelegatorView.getRoles(rolCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedRoles = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRoles = null;

        if (txtRolEstado != null) {
            txtRolEstado.setValue(null);
            txtRolEstado.setDisabled(true);
        }

        if (txtRolNombre != null) {
            txtRolNombre.setValue(null);
            txtRolNombre.setDisabled(true);
        }

        if (txtRolUsuCrea != null) {
            txtRolUsuCrea.setValue(null);
            txtRolUsuCrea.setDisabled(true);
        }

        if (txtRolUsuModifica != null) {
            txtRolUsuModifica.setValue(null);
            txtRolUsuModifica.setDisabled(true);
        }

        if (txtRolFechaCrea != null) {
            txtRolFechaCrea.setValue(null);
            txtRolFechaCrea.setDisabled(true);
        }

        if (txtRolFechaModifica != null) {
            txtRolFechaModifica.setValue(null);
            txtRolFechaModifica.setDisabled(true);
        }

        if (txtRolCodigo != null) {
            txtRolCodigo.setValue(null);
            txtRolCodigo.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtRolFechaCrea() {
        Date inputDate = (Date) txtRolFechaCrea.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtRolFechaModifica() {
        Date inputDate = (Date) txtRolFechaModifica.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Long rolCodigo = FacesUtils.checkLong(txtRolCodigo);
            entity = (rolCodigo != null)
                ? businessDelegatorView.getRoles(rolCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtRolEstado.setDisabled(false);
            txtRolNombre.setDisabled(false);
            txtRolUsuCrea.setDisabled(false);
            txtRolUsuModifica.setDisabled(false);
            txtRolFechaCrea.setDisabled(false);
            txtRolFechaModifica.setDisabled(false);
            txtRolCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtRolEstado.setValue(entity.getRolEstado());
            txtRolEstado.setDisabled(false);
            txtRolFechaCrea.setValue(entity.getRolFechaCrea());
            txtRolFechaCrea.setDisabled(false);
            txtRolFechaModifica.setValue(entity.getRolFechaModifica());
            txtRolFechaModifica.setDisabled(false);
            txtRolNombre.setValue(entity.getRolNombre());
            txtRolNombre.setDisabled(false);
            txtRolUsuCrea.setValue(entity.getRolUsuCrea());
            txtRolUsuCrea.setDisabled(false);
            txtRolUsuModifica.setValue(entity.getRolUsuModifica());
            txtRolUsuModifica.setDisabled(false);
            txtRolCodigo.setValue(entity.getRolCodigo());
            txtRolCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRoles = (RolesDTO) (evt.getComponent().getAttributes()
                                       .get("selectedRoles"));
        txtRolEstado.setValue(selectedRoles.getRolEstado());
        txtRolEstado.setDisabled(false);
        txtRolFechaCrea.setValue(selectedRoles.getRolFechaCrea());
        txtRolFechaCrea.setDisabled(false);
        txtRolFechaModifica.setValue(selectedRoles.getRolFechaModifica());
        txtRolFechaModifica.setDisabled(false);
        txtRolNombre.setValue(selectedRoles.getRolNombre());
        txtRolNombre.setDisabled(false);
        txtRolUsuCrea.setValue(selectedRoles.getRolUsuCrea());
        txtRolUsuCrea.setDisabled(false);
        txtRolUsuModifica.setValue(selectedRoles.getRolUsuModifica());
        txtRolUsuModifica.setDisabled(false);
        txtRolCodigo.setValue(selectedRoles.getRolCodigo());
        txtRolCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRoles == null) && (entity == null)) {
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
            entity = new Roles();

            Long rolCodigo = FacesUtils.checkLong(txtRolCodigo);

            entity.setRolCodigo(rolCodigo);
            entity.setRolEstado(FacesUtils.checkString(txtRolEstado));
            entity.setRolFechaCrea(FacesUtils.checkDate(txtRolFechaCrea));
            entity.setRolFechaModifica(FacesUtils.checkDate(txtRolFechaModifica));
            entity.setRolNombre(FacesUtils.checkString(txtRolNombre));
            entity.setRolUsuCrea(FacesUtils.checkString(txtRolUsuCrea));
            entity.setRolUsuModifica(FacesUtils.checkString(txtRolUsuModifica));
            businessDelegatorView.saveRoles(entity);
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
                Long rolCodigo = new Long(selectedRoles.getRolCodigo());
                entity = businessDelegatorView.getRoles(rolCodigo);
            }

            entity.setRolEstado(FacesUtils.checkString(txtRolEstado));
            entity.setRolFechaCrea(FacesUtils.checkDate(txtRolFechaCrea));
            entity.setRolFechaModifica(FacesUtils.checkDate(txtRolFechaModifica));
            entity.setRolNombre(FacesUtils.checkString(txtRolNombre));
            entity.setRolUsuCrea(FacesUtils.checkString(txtRolUsuCrea));
            entity.setRolUsuModifica(FacesUtils.checkString(txtRolUsuModifica));
            businessDelegatorView.updateRoles(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRoles = (RolesDTO) (evt.getComponent().getAttributes()
                                           .get("selectedRoles"));

            Long rolCodigo = new Long(selectedRoles.getRolCodigo());
            entity = businessDelegatorView.getRoles(rolCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long rolCodigo = FacesUtils.checkLong(txtRolCodigo);
            entity = businessDelegatorView.getRoles(rolCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRoles(entity);
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
            selectedRoles = (RolesDTO) (evt.getComponent().getAttributes()
                                           .get("selectedRoles"));

            Long rolCodigo = new Long(selectedRoles.getRolCodigo());
            entity = businessDelegatorView.getRoles(rolCodigo);
            businessDelegatorView.deleteRoles(entity);
            data.remove(selectedRoles);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long rolCodigo, String rolEstado,
        Date rolFechaCrea, Date rolFechaModifica, String rolNombre,
        String rolUsuCrea, String rolUsuModifica) throws Exception {
        try {
            entity.setRolEstado(FacesUtils.checkString(rolEstado));
            entity.setRolFechaCrea(FacesUtils.checkDate(rolFechaCrea));
            entity.setRolFechaModifica(FacesUtils.checkDate(rolFechaModifica));
            entity.setRolNombre(FacesUtils.checkString(rolNombre));
            entity.setRolUsuCrea(FacesUtils.checkString(rolUsuCrea));
            entity.setRolUsuModifica(FacesUtils.checkString(rolUsuModifica));
            businessDelegatorView.updateRoles(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RolesView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtRolEstado() {
        return txtRolEstado;
    }

    public void setTxtRolEstado(InputText txtRolEstado) {
        this.txtRolEstado = txtRolEstado;
    }

    public InputText getTxtRolNombre() {
        return txtRolNombre;
    }

    public void setTxtRolNombre(InputText txtRolNombre) {
        this.txtRolNombre = txtRolNombre;
    }

    public InputText getTxtRolUsuCrea() {
        return txtRolUsuCrea;
    }

    public void setTxtRolUsuCrea(InputText txtRolUsuCrea) {
        this.txtRolUsuCrea = txtRolUsuCrea;
    }

    public InputText getTxtRolUsuModifica() {
        return txtRolUsuModifica;
    }

    public void setTxtRolUsuModifica(InputText txtRolUsuModifica) {
        this.txtRolUsuModifica = txtRolUsuModifica;
    }

    public Calendar getTxtRolFechaCrea() {
        return txtRolFechaCrea;
    }

    public void setTxtRolFechaCrea(Calendar txtRolFechaCrea) {
        this.txtRolFechaCrea = txtRolFechaCrea;
    }

    public Calendar getTxtRolFechaModifica() {
        return txtRolFechaModifica;
    }

    public void setTxtRolFechaModifica(Calendar txtRolFechaModifica) {
        this.txtRolFechaModifica = txtRolFechaModifica;
    }

    public InputText getTxtRolCodigo() {
        return txtRolCodigo;
    }

    public void setTxtRolCodigo(InputText txtRolCodigo) {
        this.txtRolCodigo = txtRolCodigo;
    }

    public List<RolesDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRoles();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RolesDTO> rolesDTO) {
        this.data = rolesDTO;
    }

    public RolesDTO getSelectedRoles() {
        return selectedRoles;
    }

    public void setSelectedRoles(RolesDTO roles) {
        this.selectedRoles = roles;
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
