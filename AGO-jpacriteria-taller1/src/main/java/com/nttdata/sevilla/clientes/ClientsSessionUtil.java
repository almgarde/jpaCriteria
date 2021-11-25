package com.nttdata.sevilla.clientes;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Gestión de sesiones
 * 
 * @author agadelao
 *
 */
public class ClientsSessionUtil {

	/** Logger */
	final static Logger LOGGER = LoggerFactory.getLogger(ClientsSessionUtil.class);

	/** Factoría de sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/** Generación de factoría de sesiones */
	static {

		try {

			// Generación de configuración.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Throwable ex) {

			// Error de inicialización.
			LOGGER.error("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Retorna la factoría de sesiones.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
