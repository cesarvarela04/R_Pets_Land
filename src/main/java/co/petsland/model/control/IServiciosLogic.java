package co.petsland.model.control;

import co.petsland.model.Servicios;
import co.petsland.model.dto.ServiciosDTO;

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
public interface IServiciosLogic {
    public List<Servicios> getServicios() throws Exception;

    /**
         * Save an new Servicios entity
         */
    public void saveServicios(Servicios entity) throws Exception;

    /**
         * Delete an existing Servicios entity
         *
         */
    public void deleteServicios(Servicios entity) throws Exception;

    /**
        * Update an existing Servicios entity
        *
        */
    public void updateServicios(Servicios entity) throws Exception;

    /**
         * Load an existing Servicios entity
         *
         */
    public Servicios getServicios(Long serCodigo) throws Exception;

    public List<Servicios> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Servicios> findPageServicios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberServicios() throws Exception;

    public List<ServiciosDTO> getDataServicios() throws Exception;
}
