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
import co.petsland.presentation.businessDelegate.IBusinessDelegatorView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    @Autowired
    private IEventosVeterinariasLogic eventosVeterinariasLogic;
    @Autowired
    private IRolesLogic rolesLogic;
    @Autowired
    private IServiciosLogic serviciosLogic;
    @Autowired
    private ISucursalesLogic sucursalesLogic;
    @Autowired
    private IUsuariosLogic usuariosLogic;
    @Autowired
    private IVeterinariasLogic veterinariasLogic;
    @Autowired
    private IVetsServsLogic vetsServsLogic;

    public List<EventosVeterinarias> getEventosVeterinarias()
        throws Exception {
        return eventosVeterinariasLogic.getEventosVeterinarias();
    }

    public void saveEventosVeterinarias(EventosVeterinarias entity)
        throws Exception {
        eventosVeterinariasLogic.saveEventosVeterinarias(entity);
    }

    public void deleteEventosVeterinarias(EventosVeterinarias entity)
        throws Exception {
        eventosVeterinariasLogic.deleteEventosVeterinarias(entity);
    }

    public void updateEventosVeterinarias(EventosVeterinarias entity)
        throws Exception {
        eventosVeterinariasLogic.updateEventosVeterinarias(entity);
    }

    public EventosVeterinarias getEventosVeterinarias(Long evCodigo)
        throws Exception {
        EventosVeterinarias eventosVeterinarias = null;

        try {
            eventosVeterinarias = eventosVeterinariasLogic.getEventosVeterinarias(evCodigo);
        } catch (Exception e) {
            throw e;
        }

        return eventosVeterinarias;
    }

    public List<EventosVeterinarias> findByCriteriaInEventosVeterinarias(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return eventosVeterinariasLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<EventosVeterinarias> findPageEventosVeterinarias(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return eventosVeterinariasLogic.findPageEventosVeterinarias(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberEventosVeterinarias() throws Exception {
        return eventosVeterinariasLogic.findTotalNumberEventosVeterinarias();
    }

    public List<EventosVeterinariasDTO> getDataEventosVeterinarias()
        throws Exception {
        return eventosVeterinariasLogic.getDataEventosVeterinarias();
    }

    public List<Roles> getRoles() throws Exception {
        return rolesLogic.getRoles();
    }

    public void saveRoles(Roles entity) throws Exception {
        rolesLogic.saveRoles(entity);
    }

    public void deleteRoles(Roles entity) throws Exception {
        rolesLogic.deleteRoles(entity);
    }

    public void updateRoles(Roles entity) throws Exception {
        rolesLogic.updateRoles(entity);
    }

    public Roles getRoles(Long rolCodigo) throws Exception {
        Roles roles = null;

        try {
            roles = rolesLogic.getRoles(rolCodigo);
        } catch (Exception e) {
            throw e;
        }

        return roles;
    }

    public List<Roles> findByCriteriaInRoles(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return rolesLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Roles> findPageRoles(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return rolesLogic.findPageRoles(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberRoles() throws Exception {
        return rolesLogic.findTotalNumberRoles();
    }

    public List<RolesDTO> getDataRoles() throws Exception {
        return rolesLogic.getDataRoles();
    }

    public List<Servicios> getServicios() throws Exception {
        return serviciosLogic.getServicios();
    }

    public void saveServicios(Servicios entity) throws Exception {
        serviciosLogic.saveServicios(entity);
    }

    public void deleteServicios(Servicios entity) throws Exception {
        serviciosLogic.deleteServicios(entity);
    }

    public void updateServicios(Servicios entity) throws Exception {
        serviciosLogic.updateServicios(entity);
    }

    public Servicios getServicios(Long serCodigo) throws Exception {
        Servicios servicios = null;

        try {
            servicios = serviciosLogic.getServicios(serCodigo);
        } catch (Exception e) {
            throw e;
        }

        return servicios;
    }

    public List<Servicios> findByCriteriaInServicios(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return serviciosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Servicios> findPageServicios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return serviciosLogic.findPageServicios(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberServicios() throws Exception {
        return serviciosLogic.findTotalNumberServicios();
    }

    public List<ServiciosDTO> getDataServicios() throws Exception {
        return serviciosLogic.getDataServicios();
    }

    public List<Sucursales> getSucursales() throws Exception {
        return sucursalesLogic.getSucursales();
    }

    public void saveSucursales(Sucursales entity) throws Exception {
        sucursalesLogic.saveSucursales(entity);
    }

    public void deleteSucursales(Sucursales entity) throws Exception {
        sucursalesLogic.deleteSucursales(entity);
    }

    public void updateSucursales(Sucursales entity) throws Exception {
        sucursalesLogic.updateSucursales(entity);
    }

    public Sucursales getSucursales(Long sucCodigo) throws Exception {
        Sucursales sucursales = null;

        try {
            sucursales = sucursalesLogic.getSucursales(sucCodigo);
        } catch (Exception e) {
            throw e;
        }

        return sucursales;
    }

    public List<Sucursales> findByCriteriaInSucursales(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return sucursalesLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Sucursales> findPageSucursales(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return sucursalesLogic.findPageSucursales(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberSucursales() throws Exception {
        return sucursalesLogic.findTotalNumberSucursales();
    }

    public List<SucursalesDTO> getDataSucursales() throws Exception {
        return sucursalesLogic.getDataSucursales();
    }

    public List<Usuarios> getUsuarios() throws Exception {
        return usuariosLogic.getUsuarios();
    }

    public void saveUsuarios(Usuarios entity) throws Exception {
        usuariosLogic.saveUsuarios(entity);
    }

    public void deleteUsuarios(Usuarios entity) throws Exception {
        usuariosLogic.deleteUsuarios(entity);
    }

    public void updateUsuarios(Usuarios entity) throws Exception {
        usuariosLogic.updateUsuarios(entity);
    }

    public Usuarios getUsuarios(Long usuCodigo) throws Exception {
        Usuarios usuarios = null;

        try {
            usuarios = usuariosLogic.getUsuarios(usuCodigo);
        } catch (Exception e) {
            throw e;
        }

        return usuarios;
    }

    public List<Usuarios> findByCriteriaInUsuarios(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuariosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuariosLogic.findPageUsuarios(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuarios() throws Exception {
        return usuariosLogic.findTotalNumberUsuarios();
    }

    public List<UsuariosDTO> getDataUsuarios() throws Exception {
        return usuariosLogic.getDataUsuarios();
    }

    public List<Veterinarias> getVeterinarias() throws Exception {
        return veterinariasLogic.getVeterinarias();
    }

    public void saveVeterinarias(Veterinarias entity) throws Exception {
        veterinariasLogic.saveVeterinarias(entity);
    }

    public void deleteVeterinarias(Veterinarias entity)
        throws Exception {
        veterinariasLogic.deleteVeterinarias(entity);
    }

    public void updateVeterinarias(Veterinarias entity)
        throws Exception {
        veterinariasLogic.updateVeterinarias(entity);
    }

    public Veterinarias getVeterinarias(Long vetCodigo)
        throws Exception {
        Veterinarias veterinarias = null;

        try {
            veterinarias = veterinariasLogic.getVeterinarias(vetCodigo);
        } catch (Exception e) {
            throw e;
        }

        return veterinarias;
    }

    public List<Veterinarias> findByCriteriaInVeterinarias(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return veterinariasLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Veterinarias> findPageVeterinarias(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return veterinariasLogic.findPageVeterinarias(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberVeterinarias() throws Exception {
        return veterinariasLogic.findTotalNumberVeterinarias();
    }

    public List<VeterinariasDTO> getDataVeterinarias()
        throws Exception {
        return veterinariasLogic.getDataVeterinarias();
    }

    public List<VetsServs> getVetsServs() throws Exception {
        return vetsServsLogic.getVetsServs();
    }

    public void saveVetsServs(VetsServs entity) throws Exception {
        vetsServsLogic.saveVetsServs(entity);
    }

    public void deleteVetsServs(VetsServs entity) throws Exception {
        vetsServsLogic.deleteVetsServs(entity);
    }

    public void updateVetsServs(VetsServs entity) throws Exception {
        vetsServsLogic.updateVetsServs(entity);
    }

    public VetsServs getVetsServs(Long vsCodigo) throws Exception {
        VetsServs vetsServs = null;

        try {
            vetsServs = vetsServsLogic.getVetsServs(vsCodigo);
        } catch (Exception e) {
            throw e;
        }

        return vetsServs;
    }

    public List<VetsServs> findByCriteriaInVetsServs(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return vetsServsLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<VetsServs> findPageVetsServs(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return vetsServsLogic.findPageVetsServs(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberVetsServs() throws Exception {
        return vetsServsLogic.findTotalNumberVetsServs();
    }

    public List<VetsServsDTO> getDataVetsServs() throws Exception {
        return vetsServsLogic.getDataVetsServs();
    }

	@Override
	public UsuariosDTO consultaUsuarioXEmail(String email) throws Exception {
		return usuariosLogic.consultaUsuarioXEmail(email);
	}
}
