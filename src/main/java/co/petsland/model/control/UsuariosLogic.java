package co.petsland.model.control;

import co.petsland.dataaccess.dao.*;
import co.petsland.exceptions.*;
import co.petsland.model.*;
import co.petsland.model.dto.UsuariosDTO;
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
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("UsuariosLogic")
public class UsuariosLogic implements IUsuariosLogic {
	/**
	 * DAO injected by Spring that manages Usuarios entities
	 *
	 */
	@Autowired
	private IUsuariosDAO usuariosDAO;

	/**
	 * DAO injected by Spring that manages EventosVeterinarias entities
	 *
	 */
	@Autowired
	private IEventosVeterinariasDAO eventosVeterinariasDAO;

	/**
	 * Logic injected by Spring that manages Roles entities
	 *
	 */
	@Autowired
	IRolesLogic logicRoles1;

	@Transactional(readOnly = true)
	public List<Usuarios> getUsuarios() throws Exception {
		List<Usuarios> list = new ArrayList<Usuarios>();

		try {
			list = usuariosDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Usuarios");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveUsuarios(Usuarios entity) throws Exception {
		try {
			if (entity.getRoles() == null) {
				throw new ZMessManager().new ForeignException("roles");
			}

			if (entity.getUsuClave() == null) {
				throw new ZMessManager().new EmptyFieldException("usuClave");
			}

			if ((entity.getUsuClave() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuClave(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuClave");
			}

			if (entity.getUsuCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("usuCodigo");
			}

			if (entity.getUsuCrea() == null) {
				throw new ZMessManager().new EmptyFieldException("usuCrea");
			}

			if ((entity.getUsuCrea() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuCrea(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuCrea");
			}

			if (entity.getUsuEmail() == null) {
				throw new ZMessManager().new EmptyFieldException("usuEmail");
			}

			if ((entity.getUsuEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuEmail(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuEmail");
			}

			if (entity.getUsuEstado() == null) {
				throw new ZMessManager().new EmptyFieldException("usuEstado");
			}

			if ((entity.getUsuEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"usuEstado");
			}

			if (entity.getUsuFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"usuFechaCreacion");
			}

			if ((entity.getUsuModifica() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuModifica(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"usuModifica");
			}

			if (entity.getUsuNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("usuNombre");
			}

			if ((entity.getUsuNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuNombre(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"usuNombre");
			}

			if (entity.getRoles().getRolCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"rolCodigo_Roles");
			}

			if (getUsuarios(entity.getUsuCodigo()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			usuariosDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteUsuarios(Usuarios entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Usuarios");
		}

		if (entity.getUsuCodigo() == null) {
			throw new ZMessManager().new EmptyFieldException("usuCodigo");
		}

		List<EventosVeterinarias> eventosVeterinariases = null;

		try {
			eventosVeterinariases = eventosVeterinariasDAO.findByProperty(
					"usuarios.usuCodigo", entity.getUsuCodigo());

			if (Utilities.validationsList(eventosVeterinariases) == true) {
				throw new ZMessManager().new DeletingException(
						"eventosVeterinariases");
			}

			usuariosDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateUsuarios(Usuarios entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Usuarios");
			}

			if (entity.getRoles() == null) {
				throw new ZMessManager().new ForeignException("roles");
			}

			if (entity.getUsuClave() == null) {
				throw new ZMessManager().new EmptyFieldException("usuClave");
			}

			if ((entity.getUsuClave() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuClave(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuClave");
			}

			if (entity.getUsuCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("usuCodigo");
			}

			if (entity.getUsuCrea() == null) {
				throw new ZMessManager().new EmptyFieldException("usuCrea");
			}

			if ((entity.getUsuCrea() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuCrea(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuCrea");
			}

			if (entity.getUsuEmail() == null) {
				throw new ZMessManager().new EmptyFieldException("usuEmail");
			}

			if ((entity.getUsuEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuEmail(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuEmail");
			}

			if (entity.getUsuEstado() == null) {
				throw new ZMessManager().new EmptyFieldException("usuEstado");
			}

			if ((entity.getUsuEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"usuEstado");
			}

			if (entity.getUsuFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"usuFechaCreacion");
			}

			if ((entity.getUsuModifica() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuModifica(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"usuModifica");
			}

			if (entity.getUsuNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("usuNombre");
			}

			if ((entity.getUsuNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUsuNombre(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"usuNombre");
			}

			if (entity.getRoles().getRolCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"rolCodigo_Roles");
			}

			usuariosDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<UsuariosDTO> getDataUsuarios() throws Exception {
		try {
			List<Usuarios> usuarios = usuariosDAO.findAll();

			List<UsuariosDTO> usuariosDTO = new ArrayList<UsuariosDTO>();

			for (Usuarios usuariosTmp : usuarios) {
				UsuariosDTO usuariosDTO2 = new UsuariosDTO();

				usuariosDTO2.setUsuCodigo(usuariosTmp.getUsuCodigo());
				usuariosDTO2
						.setUsuClave((usuariosTmp.getUsuClave() != null) ? usuariosTmp
								.getUsuClave() : null);
				usuariosDTO2
						.setUsuCrea((usuariosTmp.getUsuCrea() != null) ? usuariosTmp
								.getUsuCrea() : null);
				usuariosDTO2
						.setUsuEmail((usuariosTmp.getUsuEmail() != null) ? usuariosTmp
								.getUsuEmail() : null);
				usuariosDTO2
						.setUsuEstado((usuariosTmp.getUsuEstado() != null) ? usuariosTmp
								.getUsuEstado() : null);
				usuariosDTO2.setUsuFechaCreacion(usuariosTmp
						.getUsuFechaCreacion());
				usuariosDTO2.setUsuFechaModifica(usuariosTmp
						.getUsuFechaModifica());
				usuariosDTO2
						.setUsuModifica((usuariosTmp.getUsuModifica() != null) ? usuariosTmp
								.getUsuModifica() : null);
				usuariosDTO2
						.setUsuNombre((usuariosTmp.getUsuNombre() != null) ? usuariosTmp
								.getUsuNombre() : null);
				usuariosDTO2.setRolCodigo_Roles((usuariosTmp.getRoles()
						.getRolCodigo() != null) ? usuariosTmp.getRoles()
						.getRolCodigo() : null);
				usuariosDTO.add(usuariosDTO2);
			}

			return usuariosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Usuarios getUsuarios(Long usuCodigo) throws Exception {
		Usuarios entity = null;

		try {
			entity = usuariosDAO.findById(usuCodigo);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuarios");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Usuarios> findPageUsuarios(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Usuarios> entity = null;

		try {
			entity = usuariosDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuarios Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberUsuarios() throws Exception {
		Long entity = null;

		try {
			entity = usuariosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuarios Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como
	 *            se llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1];
	 *            representa si el valor necesita o no ''(comillas simples)usado
	 *            para campos de tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que
	 *            se va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa
	 *            que tipo de busqueda voy a hacer.., ejemplo: where
	 *            nombre=william o where nombre<>william, en este campo iria el
	 *            tipo de comparador que quiero si es = o <>
	 *
	 *            Se itera de 4 en 4..., entonces 4 registros del arreglo
	 *            representan 1 busqueda en un campo, si se ponen mas pues el
	 *            continuara buscando en lo que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *            la diferencia son estas dos posiciones
	 *
	 *            [0] = String variable = (String) varibles[j]; la variable ne
	 *            la BD que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en
	 *            un rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en
	 *            un rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria
	 *            value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3];
	 *            comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4];
	 *            comparador 2 ejemplo: a comparador1>1 and a comparador2<5 (el
	 *            original: a > 1 and a < 5) *
	 * @param variablesBetweenDates
	 *            (en este caso solo para mysql) [0] = String variable =
	 *            (String) varibles[k]; el nombre de la variable que hace
	 *            referencia a una fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *            comparar(deben ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *            comparar(deben ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<Usuarios> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Usuarios> list = new ArrayList<Usuarios>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null)
						&& (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null)
						&& (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null)
						&& (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0) ? ("(" + value + " "
							+ comparator1 + " " + variable + " and " + variable
							+ " " + comparator2 + " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1
									+ " " + variable + " and " + variable + " "
									+ comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null)
						&& (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0) ? ("(model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')") : (tempWhere + " AND (model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')");
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
			list = usuariosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public UsuariosDTO loginUsario(String correo, String pass) throws Exception {
		return usuariosDAO.loginUsario(correo, pass);
	}

	@Transactional(readOnly = true)
	@Override
	public UsuariosDTO consultaUsuarioXEmail(String email) throws Exception {
		return usuariosDAO.consultaUsuarioXEmail(email);
	}

	@Override
	public Object updateVeterinaria(Veterinarias entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
