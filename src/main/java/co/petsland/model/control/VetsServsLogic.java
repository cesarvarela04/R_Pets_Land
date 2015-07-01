package co.petsland.model.control;

import co.petsland.dataaccess.dao.*;

import co.petsland.exceptions.*;

import co.petsland.model.*;
import co.petsland.model.dto.VetsServsDTO;

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
@Service("VetsServsLogic")
public class VetsServsLogic implements IVetsServsLogic {
    /**
     * DAO injected by Spring that manages VetsServs entities
     *
     */
    @Autowired
    private IVetsServsDAO vetsServsDAO;

    /**
    * Logic injected by Spring that manages Servicios entities
    *
    */
    @Autowired
    IServiciosLogic logicServicios1;

    /**
    * Logic injected by Spring that manages Veterinarias entities
    *
    */
    @Autowired
    IVeterinariasLogic logicVeterinarias2;

    @Transactional(readOnly = true)
    public List<VetsServs> getVetsServs() throws Exception {
        List<VetsServs> list = new ArrayList<VetsServs>();

        try {
            list = vetsServsDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "VetsServs");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveVetsServs(VetsServs entity) throws Exception {
        try {
            if (entity.getServicios() == null) {
                throw new ZMessManager().new ForeignException("servicios");
            }

            if (entity.getVeterinarias() == null) {
                throw new ZMessManager().new ForeignException("veterinarias");
            }

            if (entity.getVsCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("vsCodigo");
            }

            if ((entity.getVsEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVsEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("vsEstado");
            }

            if (entity.getServicios().getSerCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "serCodigo_Servicios");
            }

            if (entity.getVeterinarias().getVetCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "vetCodigo_Veterinarias");
            }

            if (getVetsServs(entity.getVsCodigo()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            vetsServsDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteVetsServs(VetsServs entity) throws Exception {
        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("VetsServs");
        }

        if (entity.getVsCodigo() == null) {
            throw new ZMessManager().new EmptyFieldException("vsCodigo");
        }

        try {
            vetsServsDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateVetsServs(VetsServs entity) throws Exception {
        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("VetsServs");
            }

            if (entity.getServicios() == null) {
                throw new ZMessManager().new ForeignException("servicios");
            }

            if (entity.getVeterinarias() == null) {
                throw new ZMessManager().new ForeignException("veterinarias");
            }

            if (entity.getVsCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("vsCodigo");
            }

            if ((entity.getVsEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVsEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("vsEstado");
            }

            if (entity.getServicios().getSerCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "serCodigo_Servicios");
            }

            if (entity.getVeterinarias().getVetCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "vetCodigo_Veterinarias");
            }

            vetsServsDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<VetsServsDTO> getDataVetsServs() throws Exception {
        try {
            List<VetsServs> vetsServs = vetsServsDAO.findAll();

            List<VetsServsDTO> vetsServsDTO = new ArrayList<VetsServsDTO>();

            for (VetsServs vetsServsTmp : vetsServs) {
                VetsServsDTO vetsServsDTO2 = new VetsServsDTO();

                vetsServsDTO2.setVsCodigo(vetsServsTmp.getVsCodigo());
                vetsServsDTO2.setVsEstado((vetsServsTmp.getVsEstado() != null)
                    ? vetsServsTmp.getVsEstado() : null);
                vetsServsDTO2.setSerCodigo_Servicios((vetsServsTmp.getServicios()
                                                                  .getSerCodigo() != null)
                    ? vetsServsTmp.getServicios().getSerCodigo() : null);
                vetsServsDTO2.setVetCodigo_Veterinarias((vetsServsTmp.getVeterinarias()
                                                                     .getVetCodigo() != null)
                    ? vetsServsTmp.getVeterinarias().getVetCodigo() : null);
                vetsServsDTO.add(vetsServsDTO2);
            }

            return vetsServsDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public VetsServs getVetsServs(Long vsCodigo) throws Exception {
        VetsServs entity = null;

        try {
            entity = vetsServsDAO.findById(vsCodigo);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("VetsServs");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<VetsServs> findPageVetsServs(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<VetsServs> entity = null;

        try {
            entity = vetsServsDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("VetsServs Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberVetsServs() throws Exception {
        Long entity = null;

        try {
            entity = vetsServsDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("VetsServs Count");
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
    public List<VetsServs> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<VetsServs> list = new ArrayList<VetsServs>();
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
            list = vetsServsDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
