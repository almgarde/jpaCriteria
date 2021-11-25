package com.nttdata.sevilla.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.nttdata.sevilla.persistence.Client;



/**
 * ENTIDAD CONTRACT
 * 
 * @author agadelao
 *
 */
@Entity
@Table(name = "NTTDATA_ORACLE_HIBERNATE_CONTRACTS")
public class Contract extends AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** ID del contrato */
	private Long idContract;

	/** Fecha de inicio del contrato */
	private Date startDate;

	/** Fecha de fin del contrato */
	private Date endDate;

	/** Precio mensual del contrato */
	private int monthPrice;

	/** (FK) ID del cliente del contrato */
	private Client client;

	/**
	 * @return the idContract
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdContract() {
		return idContract;
	}

	/**
	 * @param idContrato the idContract to set
	 */
	public void setIdContract(Long idContract) {
		this.idContract = idContract;
	}

	/**
	 * @return the startDate
	 */
	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the monthPrice
	 */
	@Column(name = "MONTH_PRICE")
	public int getMonthPrice() {
		return monthPrice;
	}

	/**
	 * @param monthPrice the monthPrice to set
	 */
	public void setMonthPrice(int monthPrice) {
		this.monthPrice = monthPrice;
	}

	/**
	 * @return the clientID
	 */
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClient(Client clientID) {
		this.client = clientID;
	}

	/**
	 * Método para responder el tipo de clase
	 * 
	 * @return Class<?>
	 */
	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Override
	public String toString() {
		return "Contract [idContract=" + idContract + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", monthPrice=" + monthPrice + "]";
	}

}
