package co.petsland.dataaccess.dao;

import co.petsland.dataaccess.api.HibernateDaoImpl;
import co.petsland.model.Veterinarias;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;


/**
 * A data access object (DAO) providing persistence and search support for
 * Veterinarias entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Veterinarias
 */
@Scope("singleton")
@Repository("VeterinariasDAO")
public class VeterinariasDAO extends HibernateDaoImpl<Veterinarias, Long>
    implements IVeterinariasDAO {
    private static final Logger log = LoggerFactory.getLogger(VeterinariasDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IVeterinariasDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IVeterinariasDAO) ctx.getBean("VeterinariasDAO");
    }

    @SuppressWarnings("unchecked")
	@Override
	public Long existeVeterinaria(String nombre) throws Exception {
		Long exiten = 0L;
		try {
			Query query = getSession().getNamedQuery("existeVeterinaria");
			query.setParameter("pNombre", nombre);
			System.out.println("VetDao " + nombre );
			List<Long> cantA = query.list();

			if (cantA!=null) {
				exiten=cantA.get(0);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return exiten;
	}
}
