package co.petsland.model.control;

import co.petsland.model.Veterinarias;
import co.petsland.model.dto.VeterinariasDTO;

import java.math.BigDecimal;
import java.util.*;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IVeterinariasLogic {
    public List<Veterinarias> getVeterinarias() throws Exception;

    /**
         * Save an new Veterinarias entity
         */
    public void saveVeterinarias(Veterinarias entity) throws Exception;

    /**
         * Delete an existing Veterinarias entity
         *
         */
    public void deleteVeterinarias(Veterinarias entity)
        throws Exception;

    /**
        * Update an existing Veterinarias entity
        *
        */
    public void updateVeterinarias(Veterinarias entity)
        throws Exception;

    /**
         * Load an existing Veterinarias entity
         *
         */
    public Veterinarias getVeterinarias(Long vetCodigo)
        throws Exception;

    public List<Veterinarias> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Veterinarias> findPageVeterinarias(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVeterinarias() throws Exception;

    public List<VeterinariasDTO> getDataVeterinarias()
        throws Exception;

    public Long existeVeterinaria(String nombre) throws Exception;
}
