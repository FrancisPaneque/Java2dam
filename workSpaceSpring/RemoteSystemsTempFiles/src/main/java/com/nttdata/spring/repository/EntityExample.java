package com.nttdata.spring.repository;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de entidad.
 * 
 * @author NTT Data Sevilla
 *
 */
@Entity
@Table(name = "T_ENTITY_EX")
public class EntityExample implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** ID (PK) */
	private Long id;

	/** Primer campo */
	private String fieldOne;

	/** Segundo campo */
	private String fieldTwo;

	/** Tercer campo */
	private Date fieldDate;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_ID")
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fieldOne
	 */
	@Column(name = "C_FIELD_ONE")
	public String getFieldOne() {
		return fieldOne;
	}

	/**
	 * @param fieldOne
	 *            the fieldOne to set
	 */
	public void setFieldOne(String fieldOne) {
		this.fieldOne = fieldOne;
	}

	/**
	 * @return the fieldTwo
	 */
	@Column(name = "C_FIELD_TWO")
	public String getFieldTwo() {
		return fieldTwo;
	}

	/**
	 * @param fieldTwo
	 *            the fieldTwo to set
	 */
	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	/**
	 * @return the fieldDate
	 */
	@Column(name = "C_FIELD_DATE")
	public Date getFieldDate() {
		return fieldDate;
	}

	/**
	 * @param fieldDate
	 *            the fieldDate to set
	 */
	public void setFieldDate(Date fieldDate) {
		this.fieldDate = fieldDate;
	}

}
