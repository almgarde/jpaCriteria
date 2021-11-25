package com.nttdata.sevilla.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipos de clase */
	private Class<T> entityClass;

	/** Sesión de conexión con BBDD */
	private Session session;

	/**
	 * Constructor sobrecargado
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public Long insert(T insertT) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción
		final Long insertTId = (Long) session.save(insertT);

		// Commit
		session.getTransaction().commit();

		return insertTId;
	}

	@Override
	public void update(T updateT) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción
		session.update(updateT);

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public T searchById(Long idT) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por IP (PK)
		final T entityResult = session.get(this.entityClass, idT);

		return entityResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List searchAll() {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda completa
		final List<T> entityListResult = session.createQuery("FROM " + this.entityClass.getName()).list();

		return entityListResult;

	}

	@Override
	public void delete(T removeT) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción
		session.remove(removeT);

		// Commit
		session.getTransaction().commit();

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
