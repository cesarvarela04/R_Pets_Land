package co.petsland.model.control;

import co.petsland.model.Sucursales;
import co.petsland.model.dto.SucursalesDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ISucursalesLogic {
    public List<Sucursales> getSucursales() throws Exception;

    /**
         * Save an new Sucursales entity
         */
    public void saveSucursales(Sucursales entity) throws Exception;

    /**
         * Delete an existing Sucursales entity
         *
         */
    public void deleteSucursales(Sucursales entity) throws Exception;

    /**
        * Update an existing Sucursales entity
        *
        */
    public void updateSucursales(Sucursales entity) throws Exception;

    /**
         * Load an existing Sucursales entity
         *
         */
    public Sucursales getSucursales(Long sucCodigo) throws Exception;

    public List<Sucursales> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Sucursales> findPageSucursales(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSucursales() throws Exception;

    public List<SucursalesDTO> getDataSucursales() throws Exception;
}
