package com.nttdata.sevilla.clientes;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.sevilla.persistence.Client;
import com.nttdata.sevilla.persistence.Contract;
import com.nttdata.sevilla.services.ClientServiceI;
import com.nttdata.sevilla.services.ClientServiceImpl;
import com.nttdata.sevilla.services.ContractServiceI;
import com.nttdata.sevilla.services.ContractServiceImpl;

/**
 * CLIENTES Y CONTRATOS
 * 
 * @author agadelao
 *
 */
public class ClientesYContratosMain {

	/**
	 * Clase principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión

		final Session session = ClientsSessionUtil.getSessionFactory().openSession();

		// Inicialización de servicios

		final ClientServiceI clientService = new ClientServiceImpl(session);
		final ContractServiceI contractService = new ContractServiceImpl(session);

		final Client client1 = new Client();
		client1.setNameClient("Alma");
		client1.setSurname1Client("García");
		client1.setSurname2Client("Obra");
		client1.setDniClient("22D");
		client1.setUpdateUser("agadelao");
		client1.setUpdateDate(new Date());

		clientService.insertClient(client1);

		final Contract contract1 = new Contract();
		contract1.setStartDate(new Date());
		contract1.setEndDate(new Date());
		contract1.setMonthPrice(35);
		contract1.setUpdateUser("agadelao");
		contract1.setUpdateDate(new Date());
		contract1.setClient(client1);

		final Contract contract2 = new Contract();
		contract2.setStartDate(new Date());
		contract2.setEndDate(new Date());
		contract2.setMonthPrice(25);
		contract2.setUpdateUser("agadelao");
		contract2.setUpdateDate(new Date());
		contract2.setClient(client1);

		final Contract contract3 = new Contract();
		contract3.setStartDate(new Date());
		contract3.setEndDate(new Date());
		contract3.setMonthPrice(45);
		contract3.setUpdateUser("agadelao");
		contract3.setUpdateDate(new Date());
		contract3.setClient(client1);

		contractService.insertContract(contract1);
		contractService.insertContract(contract2);
		contractService.insertContract(contract3);

		// Client cliente = clientService.searchClientById(1L);

		//Client cliente = clientService.searchClientByDni("22D");
		//System.out.println(cliente);

		System.out.println("-----------------------------");

		List contratos = contractService.searchContractByClientIdAndMonthPrice(1L, 40);
		
		for (Iterator iterator = contratos.iterator(); iterator.hasNext();) {
			Contract contrato = (Contract) iterator.next();
			System.out.println(contrato);
			
		}

		session.close();

	}
}
