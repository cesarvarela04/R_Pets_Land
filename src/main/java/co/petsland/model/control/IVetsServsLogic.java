package co.petsland.model.control;

import co.petsland.model.VetsServs;
import co.petsland.model.dto.VetsServsDTO;

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
public interface IVetsServsLogic {
    public List<VetsServs> getVetsServs() throws Exception;

    /**
         * Save an new VetsServs entity
         */
    public void saveVetsServs(VetsServs entity) throws Exception;

    /**
         * Delete an existing VetsServs entity
         *
         */
    public void deleteVetsServs(VetsServs entity) throws Exception;

    /**
        * Update an existing VetsServs entity
        *
        */
    public void updateVetsServs(VetsServs entity) throws Exception;

    /**
         * Load an existing VetsServs entity
         *
         */
    public VetsServs getVetsServs(Long vsCodigo) throws Exception;

    public List<VetsServs> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<VetsServs> findPageVetsServs(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVetsServs() throws Exception;

    public List<VetsServsDTO> getDataVetsServs() throws Exception;
}
