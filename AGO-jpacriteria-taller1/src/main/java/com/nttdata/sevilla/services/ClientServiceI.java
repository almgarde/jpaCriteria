package com.nttdata.sevilla.services;

import java.util.List;

import com.nttdata.sevilla.persistence.Client;

/**
 * Interfaz de gestión de clientes
 * 
 * @author agadelao
 *
 */
public interface ClientServiceI {

	/**
	 * Método para añadir nuevos clientes
	 * 
	 * @param insertClient
	 * @return Long
	 */
	public Long insertClient(final Client insertClient);

	/**
	 * Método para actualizar clientes
	 * 
	 * @param updateClient
	 */
	public void updateClient(final Client updateClient);

	/**
	 * Método para buscar clientes por ID
	 * 
	 * @param idClient
	 * @return Client
	 */
	public Client searchClientById(Long idClient);

	/**
	 * Método para traer todos los clientes
	 * 
	 * @return List
	 */
	public List<Client> searchAllClients();

	/**
	 * Método para borrar un cliente
	 * 
	 * @param removeClient
	 */
	public void deleteClient(final Client removeClient);

	/**
	 * Método para buscar un cliente por nombre, primer y segundo apellido
	 * 
	 * @param nameClient
	 * @param surname1Client
	 * @param surname2Client
	 * @return Client
	 */
	public Client searchClientByNameAndSurnames(String nameClient, String surname1Client, String surname2Client);

	/**
	 * Método para buscar un cliente por dni
	 * 
	 * @param dniClient
	 * @return
	 */
	public Client searchClientByDni(String dniClient);
}
