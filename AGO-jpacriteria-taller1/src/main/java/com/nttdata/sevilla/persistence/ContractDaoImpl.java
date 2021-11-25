package com.nttdata.sevilla.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * IMPLEMENTACIÓN DAO CONTRACT
 * 
 * @author agadelao
 *
 */

public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** Sesión de conexión con BBDD */
	private Session session;

	/**
	 * Constructor sobrecargado
	 * 
	 * @param session
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Contract> searchByClientId(Long idClient) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Buscar contratos del cliente
		final List<Contract> contractList = session
				.createQuery("FROM Contract WHERE client.idClient ='" + idClient + "'").list();

		return contractList;
	}

	@Override
	public List<Contract> searchByClientIdAndMonthPrice(Long clientId, int priceMonth) {

		// Estructura Criteria
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Contract> queryCon = cb.createQuery(Contract.class);
		final Root<Contract> rootCon = queryCon.from(Contract.class);
		final Join<Contract, Client> queryConCli = rootCon.join("client");

		// Where
		final Predicate pr1 = cb.equal(queryConCli.<Long>get("idClient"), clientId);
		final Predicate pr2 = cb.lessThan(queryConCli.getParent().<Integer>get("monthPrice"), priceMonth);

		// Select
		queryCon.select(rootCon).where(cb.and(pr1, pr2));

		// Ejecución consulta
		final List<Contract> clientsResult = session.createQuery(queryCon).getResultList();

		return clientsResult;
	}

}
