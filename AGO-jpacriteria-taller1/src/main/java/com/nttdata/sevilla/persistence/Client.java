package com.nttdata.sevilla.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * ENTIDAD CLIENT
 * 
 * @author agadelao
 *
 */

@Entity
@Table(name = "NTTDATA_ORACLE_HIBERNATE_CLIENTS")
public class Client extends AbstractEntity implements Serializable {

		
	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** ID del cliente */
	private Long idClient;

	/** Nombre del cliente */
	private String nameClient;

	/** Primer apellido del cliente */
	private String surname1Client;

	/** Segundo apellido del cliente */
	private String surname2Client;

	/** DNI del cliente */
	private String dniClient;
	
	/** Lista de contratos del cliente */
	private List<Contract> contractList;

	/**
	 * @return the idClient
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the nameClient
	 */
	@Column(name = "NAME_CLIENT", nullable = false)
	public String getNameClient() {
		return nameClient;
	}

	/**
	 * @param nameClient the nameClient to set
	 */
	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	/**
	 * @return the surname1Client
	 */
	@Column(name = "SURNAME1_CLIENT", nullable = false)
	public String getSurname1Client() {
		return surname1Client;
	}

	/**
	 * @param surname1Client the surname1Client to set
	 */
	public void setSurname1Client(String surname1Client) {
		this.surname1Client = surname1Client;
	}

	/**
	 * @return the surname2Client
	 */
	@Column(name = "SURNAME2_CLIENT")
	public String getSurname2Client() {
		return surname2Client;
	}

	/**
	 * @param surname2Client the surname2Client to set
	 */
	public void setSurname2Client(String surname2Client) {
		this.surname2Client = surname2Client;
	}

	/**
	 * @return the dniClient
	 */
	@Column(name = "DNI_CLIENT", nullable = false, length = 9, unique = true)
	public String getDniClient() {
		return dniClient;
	}

	/**
	 * @param dniClient the dniClient to set
	 */
	public void setDniClient(String dniClient) {
		this.dniClient = dniClient;
	}

	/**
	 * @return the contractList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
	public List<Contract> getContractList() {
		return contractList;
	}

	/**
	 * @param contractList the contractList to set
	 */
	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}
	
	/**
	 * Método para responder el tipo de clase
	 * @return Class<?>
	 */
	@Transient
	public Class<?> getClase(){
		return Client.class;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nameClient=" + nameClient + ", surname1Client=" + surname1Client
				+ ", surname2Client=" + surname2Client + ", dniClient=" + dniClient + "]";
	}

	
	
	
}
