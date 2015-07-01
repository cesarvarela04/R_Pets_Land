package co.petsland.model.control;

import co.petsland.dataaccess.dao.*;

import co.petsland.exceptions.*;

import co.petsland.model.*;
import co.petsland.model.dto.ServiciosDTO;

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
@Service("ServiciosLogic")
public class ServiciosLogic implements IServiciosLogic {
    /**
     * DAO injected by Spring that manages Servicios entities
     *
     */
    @Autowired
    private IServiciosDAO serviciosDAO;

    /**
    * DAO injected by Spring that manages VetsServs entities
    *
    */
    @Autowired
    private IVetsServsDAO vetsServsDAO;

    @Transactional(readOnly = true)
    public List<Servicios> getServicios() throws Exception {
        List<Servicios> list = new ArrayList<Servicios>();

        try {
            list = serviciosDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Servicios");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveServicios(Servicios entity) throws Exception {
        try {
            if (entity.getSerCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("serCodigo");
            }

            if (entity.getSerEstado() == null) {
                throw new ZMessManager().new EmptyFieldException("serEstado");
            }

            if ((entity.getSerEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serEstado");
            }

            if (entity.getSerNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("serNombre");
            }

            if ((entity.getSerNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerNombre(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serNombre");
            }

            if (entity.getSerUsuCrea() == null) {
                throw new ZMessManager().new EmptyFieldException("serUsuCrea");
            }

            if ((entity.getSerUsuCrea() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerUsuCrea(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serUsuCrea");
            }

            if ((entity.getSerUsuModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerUsuModifica(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serUsuModifica");
            }

            if (getServicios(entity.getSerCodigo()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            serviciosDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteServicios(Servicios entity) throws Exception {
        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Servicios");
        }

        if (entity.getSerCodigo() == null) {
            throw new ZMessManager().new EmptyFieldException("serCodigo");
        }

        List<VetsServs> vetsServses = null;

        try {
            vetsServses = vetsServsDAO.findByProperty("servicios.serCodigo",
                    entity.getSerCodigo());

            if (Utilities.validationsList(vetsServses) == true) {
                throw new ZMessManager().new DeletingException("vetsServses");
            }

            serviciosDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateServicios(Servicios entity) throws Exception {
        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Servicios");
            }

            if (entity.getSerCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("serCodigo");
            }

            if (entity.getSerEstado() == null) {
                throw new ZMessManager().new EmptyFieldException("serEstado");
            }

            if ((entity.getSerEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serEstado");
            }

            if (entity.getSerNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("serNombre");
            }

            if ((entity.getSerNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerNombre(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serNombre");
            }

            if (entity.getSerUsuCrea() == null) {
                throw new ZMessManager().new EmptyFieldException("serUsuCrea");
            }

            if ((entity.getSerUsuCrea() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerUsuCrea(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serUsuCrea");
            }

            if ((entity.getSerUsuModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerUsuModifica(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serUsuModifica");
            }

            serviciosDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<ServiciosDTO> getDataServicios() throws Exception {
        try {
            List<Servicios> servicios = serviciosDAO.findAll();

            List<ServiciosDTO> serviciosDTO = new ArrayList<ServiciosDTO>();

            for (Servicios serviciosTmp : servicios) {
                ServiciosDTO serviciosDTO2 = new ServiciosDTO();

                serviciosDTO2.setSerCodigo(serviciosTmp.getSerCodigo());
                serviciosDTO2.setSerEstado((serviciosTmp.getSerEstado() != null)
                    ? serviciosTmp.getSerEstado() : null);
                serviciosDTO2.setSerNombre((serviciosTmp.getSerNombre() != null)
                    ? serviciosTmp.getSerNombre() : null);
                serviciosDTO2.setSerUsuCrea((serviciosTmp.getSerUsuCrea() != null)
                    ? serviciosTmp.getSerUsuCrea() : null);
                serviciosDTO2.setSerUsuModifica((serviciosTmp.getSerUsuModifica() != null)
                    ? serviciosTmp.getSerUsuModifica() : null);
                serviciosDTO.add(serviciosDTO2);
            }

            return serviciosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Servicios getServicios(Long serCodigo) throws Exception {
        Servicios entity = null;

        try {
            entity = serviciosDAO.findById(serCodigo);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Servicios");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Servicios> findPageServicios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Servicios> entity = null;

        try {
            entity = serviciosDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Servicios Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberServicios() throws Exception {
        Long entity = null;

        try {
            entity = serviciosDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Servicios Count");
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
    public List<Servicios> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Servicios> list = new ArrayList<Servicios>();
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
            list = serviciosDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
