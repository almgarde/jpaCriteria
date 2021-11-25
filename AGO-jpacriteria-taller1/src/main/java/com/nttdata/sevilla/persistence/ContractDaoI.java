package com.nttdata.sevilla.persistence;

import java.util.List;

/**
 * INTERFAZ DAO CONTRACT
 * 
 * @author agadelao
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract> {

	/**
	 * Método para buscar contratos por ID
	 * 
	 * @param idClient
	 * @return Contract
	 */
	public List<Contract> searchByClientId(final Long idClient);

	/**
	 * Método para buscar contratos por ID y precio mensual
	 * 
	 * @param clientId
	 * @param priceMonth
	 * @return
	 */
	public List<Contract> searchByClientIdAndMonthPrice(final Long clientId, final int priceMonth);

}
