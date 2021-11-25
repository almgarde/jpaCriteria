package com.nttdata.sevilla.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * IMPLEMENTACIÓN DAO CLIENT
 * 
 * @author agadelao
 *
 */

public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	/** Sesión de conexión con BBDD */
	private Session session;

	/**
	 * Constructor sobrecargado
	 * 
	 * @param session
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Client searchByNameAndSurname(String nameClient, String surname1Client, String surname2Client) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Buscar contratos del cliente
		final Client clientResult = (Client) session.createQuery("FROM Client WHERE nameClient ='" + nameClient
				+ "' AND surname1Client='" + surname1Client + "' AND surname2Client= '" + surname2Client + "'");

		return clientResult;
	}

	@Override
	public Client searchByDni(String dniClient) {

		// Estructura Criteria
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Client> cQuery = cb.createQuery(Client.class);
		final Root<Client> rootC = cQuery.from(Client.class);

		// Where
		final Predicate pr1 = cb.equal(rootC.<String>get("dniClient"), dniClient);

		// Select
		cQuery.select(rootC).where(pr1);

		// Ejecución consulta
		final Client clientResult = session.createQuery(cQuery).getSingleResult();

		return clientResult;
	}

}
