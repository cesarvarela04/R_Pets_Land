package co.petsland.model.control;

import co.petsland.model.EventosVeterinarias;
import co.petsland.model.dto.EventosVeterinariasDTO;

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
public interface IEventosVeterinariasLogic {
    public List<EventosVeterinarias> getEventosVeterinarias()
        throws Exception;

    /**
         * Save an new EventosVeterinarias entity
         */
    public void saveEventosVeterinarias(EventosVeterinarias entity)
        throws Exception;

    /**
         * Delete an existing EventosVeterinarias entity
         *
         */
    public void deleteEventosVeterinarias(EventosVeterinarias entity)
        throws Exception;

    /**
        * Update an existing EventosVeterinarias entity
        *
        */
    public void updateEventosVeterinarias(EventosVeterinarias entity)
        throws Exception;

    /**
         * Load an existing EventosVeterinarias entity
         *
         */
    public EventosVeterinarias getEventosVeterinarias(Long evCodigo)
        throws Exception;

    public List<EventosVeterinarias> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<EventosVeterinarias> findPageEventosVeterinarias(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberEventosVeterinarias() throws Exception;

    public List<EventosVeterinariasDTO> getDataEventosVeterinarias()
        throws Exception;
}
