package com.nttdata.sevilla.services;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.sevilla.persistence.Client;
import com.nttdata.sevilla.persistence.ClientDaoI;
import com.nttdata.sevilla.persistence.ClientDaoImpl;

/**
 * Servicio de gestión de clientes
 * 
 * @author agadelao
 *
 */
public class ClientServiceImpl implements ClientServiceI {

	/** Logger */
	final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	/** DAO de la tabla cliente */
	private ClientDaoI clientDao;

	/** Constructor */
	public ClientServiceImpl(final Session session) {
		this.clientDao = new ClientDaoImpl(session);
	}

	@Override
	public Long insertClient(Client insertClient) {

		LOGGER.info("Inicio del método insertClient");

		Long clientIdInserted = null;

		// Condición de verificación
		if (insertClient != null && insertClient.getIdClient() == null) {
			// Añadido de cliente
			clientIdInserted = clientDao.insert(insertClient);
			LOGGER.trace("Se ha añadido el cliente " + clientIdInserted);
		} else {
			LOGGER.error("Se ha introducido un cliente nulo o el cliente a introducir ya existe");
		}
		LOGGER.info("Fin del método insertClient");
		return clientIdInserted;
	}

	@Override
	public void updateClient(Client updateClient) {
		LOGGER.info("Inicio del método updateClient");

		// Condición de verificación
		if (updateClient != null && updateClient.getIdClient() != null) {
			// Actualizado del cliente
			clientDao.update(updateClient);
			LOGGER.trace("Se ha actualizado el cliente " + updateClient.getIdClient());
		} else {
			LOGGER.error("Se ha introducido un cliente nulo o el cliente a actualizar no existe");
		}
		LOGGER.info("Fin del método updateClient");

	}

	@Override
	public Client searchClientById(Long idClient) {

		LOGGER.info("Inicio del método searchClientById");

		Client clientSearched = null;

		// Condición de verificación
		if (idClient != null) {
			// Buscado de cliente
			clientSearched = clientDao.searchById(idClient);
			LOGGER.trace("Se ha encontrado el cliente " + idClient);
		} else {
			LOGGER.error("No se ha encontrado el cliente con id " + idClient);
		}
		LOGGER.info("Fin del método searchClientById");
		return clientSearched;
	}

	@Override
	public List<Client> searchAllClients() {

		LOGGER.info("Inicio del método searchAllClients");
		LOGGER.info("Fin del método searchAllClients");
		return clientDao.searchAll();

	}

	@Override
	public void deleteClient(Client removeClient) {
		LOGGER.info("Inicio del método deleteClient");

		// Condición de verificación
		if (removeClient != null && removeClient.getIdClient() != null) {
			// Borrado del cliente
			clientDao.update(removeClient);
			LOGGER.trace("Se ha borrado el cliente" + removeClient.getIdClient());
		} else {
			LOGGER.error("Se ha introducido un cliente nulo o el cliente a borrar no existe");
		}

		LOGGER.info("Fin del método deleteClient");

	}

	@Override
	public Client searchClientByNameAndSurnames(String nameClient, String surname1Client, String surname2Client) {

		LOGGER.info("Inicio del método searchClientByNameAndSurnames");

		Client clientSearched = null;

		// Condición de verificación. NOTA: Según la BBDD, el segundo apellido puede ser
		// nulo

		if (nameClient != null && !nameClient.isBlank() && surname1Client != null && !surname1Client.isBlank()) {
			clientSearched = clientDao.searchByNameAndSurname(nameClient, surname1Client, surname2Client);
		} else {
			LOGGER.error("Se ha introducido un nombre o apellido nulos o no se ha encontrado el cliente");
		}

		LOGGER.info("Fin del método searchClientByNameAndSurnames");
		return clientSearched;
	}

	@Override
	public Client searchClientByDni(String dniClient) {

		LOGGER.info("Inicio del método searchClientByDni");

		Client clientSearched = null;

		// Condición de verificación

		if (dniClient != null && !dniClient.isBlank()) {
			clientSearched = clientDao.searchByDni(dniClient);
		} else {
			LOGGER.error("Se ha introducido un dni nulo o no se ha encontrado el cliente");
		}

		LOGGER.info("Fin del método searchClientByDni");
		return clientSearched;
	}

}
