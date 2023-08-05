package core.service;

import org.hibernate.*;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import static core.util.hibernateUtil.getSessionFactory;

public interface CoreService {
	
	private Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	default Transaction beginTransation() {
		return getSession().beginTransaction();
	}
	
	default void commit() {
		getSession().getTransaction().commit();
	}
	
	default void rollback() {
		getSession().getTransaction().rollback();
	}
}
