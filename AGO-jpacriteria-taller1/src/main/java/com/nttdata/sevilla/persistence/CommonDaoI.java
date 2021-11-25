package com.nttdata.sevilla.persistence;

import java.util.List;

public interface CommonDaoI<T> {

	/**
	 * Método para insertar registros
	 * 
	 * @param insertT
	 * @return Long
	 */
	public Long insert(final T insertT);

	/**
	 * Método para actualizar registros
	 * 
	 * @param updateT
	 */
	public void update(final T updateT);

	/**
	 * Método para buscar registros por ID
	 * 
	 * @param idT
	 * @return T
	 */
	public T searchById(final Long idT);

	/**
	 * Método para buscar todos los registros
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();

	/**
	 * Método para eliminar registros
	 * 
	 * @param removeT
	 */
	public void delete(final T removeT);

}
