package co.petsland.model.control;

import co.petsland.model.Usuarios;
import co.petsland.model.Veterinarias;
import co.petsland.model.dto.UsuariosDTO;

import java.math.BigDecimal;
import java.util.*;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IUsuariosLogic {
    public List<Usuarios> getUsuarios() throws Exception;

    /**
         * Save an new Usuarios entity
         */
    public void saveUsuarios(Usuarios entity) throws Exception;

    /**
         * Delete an existing Usuarios entity
         *
         */
    public void deleteUsuarios(Usuarios entity) throws Exception;

    /**
        * Update an existing Usuarios entity
        *
        */
    public void updateUsuarios(Usuarios entity) throws Exception;

    /**
         * Load an existing Usuarios entity
         *
         */
    public Usuarios getUsuarios(Long usuCodigo) throws Exception;

    public List<Usuarios> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarios() throws Exception;

    public List<UsuariosDTO> getDataUsuarios() throws Exception;

    public UsuariosDTO loginUsario(String correo, String pass) throws Exception;

	public UsuariosDTO consultaUsuarioXEmail(String email) throws Exception;

	public Object updateVeterinaria(Veterinarias entity) throws Exception;
}
