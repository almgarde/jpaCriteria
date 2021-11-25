package com.nttdata.sevilla.services;

import java.util.List;

import com.nttdata.sevilla.persistence.Client;
import com.nttdata.sevilla.persistence.Contract;

/**
 * Interfaz de gestión de contratos
 * 
 * @author agadelao
 *
 */
public interface ContractServiceI {

	/**
	 * Método para añadir nuevos contratos
	 * 
	 * @param insertContract
	 * @return Long
	 */
	public Long insertContract(final Contract insertContract);

	/**
	 * Método para actualizar contratos
	 * 
	 * @param updateContract
	 */
	public void updateContract(final Contract updateContract);

	/**
	 * Método para buscar contratos por ID
	 * 
	 * @param idContract
	 * @return Contract
	 */
	public Contract searchContractById(Long idContract);

	/**
	 * Método para traer todos los contratos
	 * 
	 * @return List
	 */
	public List<Contract> searchAllContracts();

	/**
	 * Método para borrar un contrato
	 * 
	 * @param removeContract
	 */
	public void deleteContracts(final Contract removeContract);

	/**
	 * Método para buscar los contratos por el ID del cliente
	 * 
	 * @param idClient
	 * @return List<Contract>
	 */
	public List<Contract> searchContractsByClientId(Long idClient);

	/**
	 * Método para buscar los contratos por el ID del cliente con un precio mensual
	 * menores a X
	 * 
	 * @param idClient
	 * @param monthPrice
	 * @return List<Contract>
	 */
	public List<Contract> searchContractByClientIdAndMonthPrice(Long idClient, int monthPrice);

}
