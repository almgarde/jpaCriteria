package com.nttdata.sevilla.services;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.sevilla.persistence.Client;
import com.nttdata.sevilla.persistence.ClientDaoI;
import com.nttdata.sevilla.persistence.ClientDaoImpl;
import com.nttdata.sevilla.persistence.Contract;
import com.nttdata.sevilla.persistence.ContractDaoI;
import com.nttdata.sevilla.persistence.ContractDaoImpl;

/**
 * Servicio de gestión de contratos
 * 
 * @author agadelao
 *
 */
public class ContractServiceImpl implements ContractServiceI {

	/** Logger */
	final static Logger LOGGER = LoggerFactory.getLogger(ContractServiceImpl.class);

	/** DAO de la tabla contrato */
	private ContractDaoI contractDao;

	/** Constructor */
	public ContractServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public Long insertContract(Contract insertContract) {
		LOGGER.info("Inicio del método insertContract");

		Long contractIdInserted = null;

		// Condición de verificación
		if (insertContract != null && insertContract.getIdContract() == null) {
			// Añadido del contrato
			contractIdInserted = contractDao.insert(insertContract);
			LOGGER.trace("Se ha añadido el contrato " + contractIdInserted);
		} else {
			LOGGER.error("Se ha introducido un contrato nulo o el contrato a introducir ya existe");
		}
		LOGGER.info("Fin del método insertContract");
		return contractIdInserted;
	}

	@Override
	public void updateContract(Contract updateContract) {

		LOGGER.info("Inicio del método updateContract");

		// Condición de verificación
		if (updateContract != null && updateContract.getIdContract() != null) {
			// Actualizado del contrato
			contractDao.update(updateContract);
			LOGGER.trace("Se ha actualizado el contrato " + updateContract.getIdContract());
		} else {
			LOGGER.error("Se ha introducido un contrato nulo o el contrato a actualizar no existe");
		}
		LOGGER.info("Fin del método updateContract");

	}

	@Override
	public Contract searchContractById(Long idContract) {
		LOGGER.info("Inicio del método searchContractById");

		Contract contractSearched = null;

		// Condición de verificación
		if (idContract != null) {
			// Buscado de contrato
			contractSearched = contractDao.searchById(idContract);
			LOGGER.trace("Se ha encontrado el cliente " + idContract);
		} else {
			LOGGER.error("No se ha encontrado el cliente con id " + idContract);
		}
		LOGGER.info("Fin del método searchContractById");
		return contractSearched;
	}

	@Override
	public List<Contract> searchAllContracts() {
		LOGGER.info("Inicio del método searchAllContracts");
		LOGGER.info("Fin del método searchAllContracts");
		return contractDao.searchAll();
	}

	@Override
	public void deleteContracts(Contract removeContract) {

		LOGGER.info("Inicio del método deleteContracts");

		// Condición de verificación
		if (removeContract != null && removeContract.getIdContract() != null) {
			// Borrado del contrato
			contractDao.update(removeContract);
			LOGGER.trace("Se ha borrado el cliente" + removeContract.getIdContract());
		} else {
			LOGGER.error("Se ha introducido un cliente nulo o el cliente a borrar no existe");
		}

		LOGGER.info("Fin del método deleteContracts");

	}

	@Override
	public List<Contract> searchContractsByClientId(Long idClient) {
		LOGGER.info("Inicio del método searchContractById");

		List contractsSearched = null;

		// Condición de verificación
		if (idClient != null) {
			// Buscado de contrato
			contractsSearched = contractDao.searchByClientId(idClient);
			LOGGER.trace("Se han encontrado los contratos del cliente " + idClient);
		} else {
			LOGGER.error("No se han encontrado contratos del cliente con id " + idClient);
		}
		LOGGER.info("Fin del método searchContractById");
		return contractsSearched;
	}

	@Override
	public List<Contract> searchContractByClientIdAndMonthPrice(Long idClient, int monthPrice) {

		LOGGER.info("Inicio del método searchContractByClientIdAndMonthPrice");

		List contractsSearched = null;

		// Condición de verificación
		if (idClient != null && monthPrice >= 0) {
			// Buscado de contrato
			contractsSearched = contractDao.searchByClientIdAndMonthPrice(idClient, monthPrice);
			LOGGER.trace(
					"Se han encontrado los contratos del cliente " + idClient + " con precio menor que " + monthPrice);
		} else {
			LOGGER.error("No se han encontrado contratos del cliente con id " + idClient + " con precio menor que "
					+ monthPrice);
		}
		LOGGER.info("Fin del método searchContractByClientIdAndMonthPrice");
		return contractsSearched;
	}

}
