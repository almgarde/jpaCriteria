package com.nttdata.sevilla.persistence;

import java.util.List;

/**
 * INTERFAZ DAO CLIENT
 * 
 * @author agadelao
 *
 */
public interface ClientDaoI extends CommonDaoI<Client> {

	/**
	 * Método para buscar clientes por nombre y apellidos
	 * 
	 * @param nameClient
	 * @param surname1Client
	 * @param surname2Client
	 * @return Client
	 */
	public Client searchByNameAndSurname(final String nameClient, final String surname1Client,
			final String surname2Client);

	/**
	 * Método para buscar clientes por DNI
	 * 
	 * @param dniClient
	 * @return Client
	 */
	public Client searchByDni(final String dniClient);

}
