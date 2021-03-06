package co.petsland.dataaccess.dao;

import co.petsland.dataaccess.api.HibernateDaoImpl;
import co.petsland.model.Servicios;

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
 * Servicios entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Servicios
 */
@Scope("singleton")
@Repository("ServiciosDAO")
public class ServiciosDAO extends HibernateDaoImpl<Servicios, Long>
    implements IServiciosDAO {
    private static final Logger log = LoggerFactory.getLogger(ServiciosDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IServiciosDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IServiciosDAO) ctx.getBean("ServiciosDAO");
    }

    @SuppressWarnings("unchecked")
	@Override
	public Long existeServicios(String nombre) throws Exception {
		Long exiten = 0L;
		try {
			Query query = getSession().getNamedQuery("existeServicio");
			query.setParameter("pNombre", nombre);

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
