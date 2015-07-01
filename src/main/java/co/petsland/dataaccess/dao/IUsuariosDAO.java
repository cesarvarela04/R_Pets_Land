package co.petsland.dataaccess.dao;

import co.petsland.dataaccess.api.Dao;
import co.petsland.model.Usuarios;
import co.petsland.model.dto.UsuariosDTO;

/**
 * Interface for UsuariosDAO.
 *
 */
public interface IUsuariosDAO extends Dao<Usuarios, Long> {
	public UsuariosDTO loginUsario(String correo, String pass) throws Exception;

	public UsuariosDTO consultaUsuarioXEmail(String email) throws Exception;


}
