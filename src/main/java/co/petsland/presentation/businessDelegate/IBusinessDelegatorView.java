package co.petsland.presentation.businessDelegate;

import co.petsland.model.EventosVeterinarias;
import co.petsland.model.Roles;
import co.petsland.model.Servicios;
import co.petsland.model.Sucursales;
import co.petsland.model.Usuarios;
import co.petsland.model.Veterinarias;
import co.petsland.model.VetsServs;
import co.petsland.model.control.EventosVeterinariasLogic;
import co.petsland.model.control.IEventosVeterinariasLogic;
import co.petsland.model.control.IRolesLogic;
import co.petsland.model.control.IServiciosLogic;
import co.petsland.model.control.ISucursalesLogic;
import co.petsland.model.control.IUsuariosLogic;
import co.petsland.model.control.IVeterinariasLogic;
import co.petsland.model.control.IVetsServsLogic;
import co.petsland.model.control.RolesLogic;
import co.petsland.model.control.ServiciosLogic;
import co.petsland.model.control.SucursalesLogic;
import co.petsland.model.control.UsuariosLogic;
import co.petsland.model.control.VeterinariasLogic;
import co.petsland.model.control.VetsServsLogic;
import co.petsland.model.dto.EventosVeterinariasDTO;
import co.petsland.model.dto.RolesDTO;
import co.petsland.model.dto.ServiciosDTO;
import co.petsland.model.dto.SucursalesDTO;
import co.petsland.model.dto.UsuariosDTO;
import co.petsland.model.dto.VeterinariasDTO;
import co.petsland.model.dto.VetsServsDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<EventosVeterinarias> getEventosVeterinarias()
        throws Exception;

    public void saveEventosVeterinarias(EventosVeterinarias entity)
        throws Exception;

    public void deleteEventosVeterinarias(EventosVeterinarias entity)
        throws Exception;

    public void updateEventosVeterinarias(EventosVeterinarias entity)
        throws Exception;

    public EventosVeterinarias getEventosVeterinarias(Long evCodigo)
        throws Exception;

    public List<EventosVeterinarias> findByCriteriaInEventosVeterinarias(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<EventosVeterinarias> findPageEventosVeterinarias(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberEventosVeterinarias() throws Exception;

    public List<EventosVeterinariasDTO> getDataEventosVeterinarias()
        throws Exception;

    public List<Roles> getRoles() throws Exception;

    public void saveRoles(Roles entity) throws Exception;

    public void deleteRoles(Roles entity) throws Exception;

    public void updateRoles(Roles entity) throws Exception;

    public Roles getRoles(Long rolCodigo) throws Exception;

    public List<Roles> findByCriteriaInRoles(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Roles> findPageRoles(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRoles() throws Exception;

    public List<RolesDTO> getDataRoles() throws Exception;

    public List<Servicios> getServicios() throws Exception;

    public void saveServicios(Servicios entity) throws Exception;

    public void deleteServicios(Servicios entity) throws Exception;

    public void updateServicios(Servicios entity) throws Exception;

    public Servicios getServicios(Long serCodigo) throws Exception;

    public List<Servicios> findByCriteriaInServicios(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Servicios> findPageServicios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberServicios() throws Exception;

    public List<ServiciosDTO> getDataServicios() throws Exception;

    public List<Sucursales> getSucursales() throws Exception;

    public void saveSucursales(Sucursales entity) throws Exception;

    public void deleteSucursales(Sucursales entity) throws Exception;

    public void updateSucursales(Sucursales entity) throws Exception;

    public Sucursales getSucursales(Long sucCodigo) throws Exception;

    public List<Sucursales> findByCriteriaInSucursales(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Sucursales> findPageSucursales(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSucursales() throws Exception;

    public List<SucursalesDTO> getDataSucursales() throws Exception;

    public List<Usuarios> getUsuarios() throws Exception;

    public void saveUsuarios(Usuarios entity) throws Exception;

    public void deleteUsuarios(Usuarios entity) throws Exception;

    public void updateUsuarios(Usuarios entity) throws Exception;

    public Usuarios getUsuarios(Long usuCodigo) throws Exception;

    public List<Usuarios> findByCriteriaInUsuarios(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarios() throws Exception;

    public List<UsuariosDTO> getDataUsuarios() throws Exception;

    public List<Veterinarias> getVeterinarias() throws Exception;

    public void saveVeterinarias(Veterinarias entity) throws Exception;

    public void deleteVeterinarias(Veterinarias entity)
        throws Exception;

    public void updateVeterinarias(Veterinarias entity)
        throws Exception;

    public Veterinarias getVeterinarias(Long vetCodigo)
        throws Exception;

    public List<Veterinarias> findByCriteriaInVeterinarias(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Veterinarias> findPageVeterinarias(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVeterinarias() throws Exception;

    public List<VeterinariasDTO> getDataVeterinarias()
        throws Exception;

    public List<VetsServs> getVetsServs() throws Exception;

    public void saveVetsServs(VetsServs entity) throws Exception;

    public void deleteVetsServs(VetsServs entity) throws Exception;

    public void updateVetsServs(VetsServs entity) throws Exception;

    public VetsServs getVetsServs(Long vsCodigo) throws Exception;

    public List<VetsServs> findByCriteriaInVetsServs(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<VetsServs> findPageVetsServs(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVetsServs() throws Exception;

    public List<VetsServsDTO> getDataVetsServs() throws Exception;

	public UsuariosDTO consultaUsuarioXEmail(String email) throws Exception;

	
}
