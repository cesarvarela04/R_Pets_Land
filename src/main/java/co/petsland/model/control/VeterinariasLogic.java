package co.petsland.model.control;

import co.petsland.dataaccess.dao.*;

import co.petsland.exceptions.*;

import co.petsland.model.*;
import co.petsland.model.dto.VeterinariasDTO;

import co.petsland.utilities.Utilities;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("VeterinariasLogic")
public class VeterinariasLogic implements IVeterinariasLogic {
    /**
     * DAO injected by Spring that manages Veterinarias entities
     *
     */
    @Autowired
    private IVeterinariasDAO veterinariasDAO;

    /**
    * DAO injected by Spring that manages EventosVeterinarias entities
    *
    */
    @Autowired
    private IEventosVeterinariasDAO eventosVeterinariasDAO;

    /**
    * DAO injected by Spring that manages Sucursales entities
    *
    */
    @Autowired
    private ISucursalesDAO sucursalesDAO;

    /**
    * DAO injected by Spring that manages VetsServs entities
    *
    */
    @Autowired
    private IVetsServsDAO vetsServsDAO;

    @Transactional(readOnly = true)
    public List<Veterinarias> getVeterinarias() throws Exception {
        List<Veterinarias> list = new ArrayList<Veterinarias>();

        try {
            list = veterinariasDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Veterinarias");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveVeterinarias(Veterinarias entity) throws Exception {
        try {
            if (entity.getVetCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("vetCodigo");
            }

            if (entity.getVetDireccion() == null) {
                throw new ZMessManager().new EmptyFieldException("vetDireccion");
            }

            if ((entity.getVetDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetDireccion(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetDireccion");
            }

            if (entity.getVetEstado() == null) {
                throw new ZMessManager().new EmptyFieldException("vetEstado");
            }

            if ((entity.getVetEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetEstado");
            }

            if (entity.getVetNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("vetNombre");
            }

            if ((entity.getVetNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetNombre(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetNombre");
            }

            if (entity.getVetTelefono() == null) {
                throw new ZMessManager().new EmptyFieldException("vetTelefono");
            }

            if ((entity.getVetTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetTelefono(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetTelefono");
            }

            if ((entity.getVetUrl() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getVetUrl(),
                        150) == false)) {
                throw new ZMessManager().new NotValidFormatException("vetUrl");
            }

            if (entity.getVetUsuCrea() == null) {
                throw new ZMessManager().new EmptyFieldException("vetUsuCrea");
            }

            if ((entity.getVetUsuCrea() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetUsuCrea(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetUsuCrea");
            }

            if ((entity.getVetUsuModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetUsuModifica(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetUsuModifica");
            }

            if (getVeterinarias(entity.getVetCodigo()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            veterinariasDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteVeterinarias(Veterinarias entity)
        throws Exception {
        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Veterinarias");
        }

        if (entity.getVetCodigo() == null) {
            throw new ZMessManager().new EmptyFieldException("vetCodigo");
        }

        List<EventosVeterinarias> eventosVeterinariases = null;
        List<Sucursales> sucursaleses = null;
        List<VetsServs> vetsServses = null;

        try {
            eventosVeterinariases = eventosVeterinariasDAO.findByProperty("veterinarias.vetCodigo",
                    entity.getVetCodigo());

            if (Utilities.validationsList(eventosVeterinariases) == true) {
                throw new ZMessManager().new DeletingException(
                    "eventosVeterinariases");
            }

            sucursaleses = sucursalesDAO.findByProperty("veterinarias.vetCodigo",
                    entity.getVetCodigo());

            if (Utilities.validationsList(sucursaleses) == true) {
                throw new ZMessManager().new DeletingException("sucursaleses");
            }

            vetsServses = vetsServsDAO.findByProperty("veterinarias.vetCodigo",
                    entity.getVetCodigo());

            if (Utilities.validationsList(vetsServses) == true) {
                throw new ZMessManager().new DeletingException("vetsServses");
            }

            veterinariasDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateVeterinarias(Veterinarias entity)
        throws Exception {
        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Veterinarias");
            }

            if (entity.getVetCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("vetCodigo");
            }

            if (entity.getVetDireccion() == null) {
                throw new ZMessManager().new EmptyFieldException("vetDireccion");
            }

            if ((entity.getVetDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetDireccion(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetDireccion");
            }

            if (entity.getVetEstado() == null) {
                throw new ZMessManager().new EmptyFieldException("vetEstado");
            }

            if ((entity.getVetEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetEstado");
            }

            if (entity.getVetNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("vetNombre");
            }

            if ((entity.getVetNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetNombre(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetNombre");
            }

            if (entity.getVetTelefono() == null) {
                throw new ZMessManager().new EmptyFieldException("vetTelefono");
            }

            if ((entity.getVetTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetTelefono(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetTelefono");
            }

            if ((entity.getVetUrl() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getVetUrl(),
                        150) == false)) {
                throw new ZMessManager().new NotValidFormatException("vetUrl");
            }

            if (entity.getVetUsuCrea() == null) {
                throw new ZMessManager().new EmptyFieldException("vetUsuCrea");
            }

            if ((entity.getVetUsuCrea() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetUsuCrea(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetUsuCrea");
            }

            if ((entity.getVetUsuModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVetUsuModifica(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "vetUsuModifica");
            }

            veterinariasDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<VeterinariasDTO> getDataVeterinarias()
        throws Exception {
        try {
            List<Veterinarias> veterinarias = veterinariasDAO.findAll();

            List<VeterinariasDTO> veterinariasDTO = new ArrayList<VeterinariasDTO>();

            for (Veterinarias veterinariasTmp : veterinarias) {
                VeterinariasDTO veterinariasDTO2 = new VeterinariasDTO();

                veterinariasDTO2.setVetCodigo(veterinariasTmp.getVetCodigo());
                veterinariasDTO2.setVetDireccion((veterinariasTmp.getVetDireccion() != null)
                    ? veterinariasTmp.getVetDireccion() : null);
                veterinariasDTO2.setVetEstado((veterinariasTmp.getVetEstado() != null)
                    ? veterinariasTmp.getVetEstado() : null);
                veterinariasDTO2.setVetNombre((veterinariasTmp.getVetNombre() != null)
                    ? veterinariasTmp.getVetNombre() : null);
                veterinariasDTO2.setVetTelefono((veterinariasTmp.getVetTelefono() != null)
                    ? veterinariasTmp.getVetTelefono() : null);
                veterinariasDTO2.setVetUrl((veterinariasTmp.getVetUrl() != null)
                    ? veterinariasTmp.getVetUrl() : null);
                veterinariasDTO2.setVetUsuCrea((veterinariasTmp.getVetUsuCrea() != null)
                    ? veterinariasTmp.getVetUsuCrea() : null);
                veterinariasDTO2.setVetUsuModifica((veterinariasTmp.getVetUsuModifica() != null)
                    ? veterinariasTmp.getVetUsuModifica() : null);
                veterinariasDTO.add(veterinariasDTO2);
            }

            return veterinariasDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Veterinarias getVeterinarias(Long vetCodigo)
        throws Exception {
        Veterinarias entity = null;

        try {
            entity = veterinariasDAO.findById(vetCodigo);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Veterinarias");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Veterinarias> findPageVeterinarias(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Veterinarias> entity = null;

        try {
            entity = veterinariasDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Veterinarias Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberVeterinarias() throws Exception {
        Long entity = null;

        try {
            entity = veterinariasDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Veterinarias Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Veterinarias> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Veterinarias> list = new ArrayList<Veterinarias>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = veterinariasDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
