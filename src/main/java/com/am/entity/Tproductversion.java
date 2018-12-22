package com.am.entity;
// Generated 20 nov. 2018 18:53:33 by Hibernate Tools 5.1.7.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Tproductversion generated by hbm2java
 */
@Entity
@Table(name = "tproductversion", catalog = "projectmanagement")
public class Tproductversion implements java.io.Serializable {

	private long idproductversion;
	private String nameversion;
	private Date dateversion;
	private int numberversion;
	private int enabledversion;
	private Tproduct tproduct;
	private Set<Tticket> ttickets = new HashSet<Tticket>(0);
	private Set<Ttickoprodversresol> ttickoprodversresols = new HashSet<Ttickoprodversresol>(0);

	public Tproductversion() {
	}

	public Tproductversion(long idproductversion, String nameversion, Date dateversion, int numberversion,
			int enabledversion, Tproduct tproduct) {
		this.idproductversion = idproductversion;
		this.nameversion = nameversion;
		this.dateversion = dateversion;
		this.numberversion = numberversion;
		this.enabledversion = enabledversion;
		this.tproduct = tproduct;
	}

	public Tproductversion(long idproductversion, String nameversion, Date dateversion, int numberversion,
			int enabledversion, Tproduct tproduct, Set<Tticket> ttickets, Set<Ttickoprodversresol> ttickoprodversresols) {
		this.idproductversion = idproductversion;
		this.nameversion = nameversion;
		this.dateversion = dateversion;
		this.numberversion = numberversion;
		this.enabledversion = enabledversion;
		this.tproduct = tproduct;
		this.ttickets = ttickets;
		this.ttickoprodversresols = ttickoprodversresols;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idproductversion", unique = true, nullable = false)
	public long getIdproductversion() {
		return this.idproductversion;
	}

	public void setIdproductversion(long idproductversion) {
		this.idproductversion = idproductversion;
	}

	@Column(name = "nameversion", nullable = false, length = 30)
	public String getNameversion() {
		return this.nameversion;
	}

	public void setNameversion(String nameversion) {
		this.nameversion = nameversion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateversion", nullable = false, length = 10)
	public Date getdateversion() {
		return this.dateversion;
	}

	public void setdateversion(Date dateversion) {
		this.dateversion = dateversion;
	}

	@Column(name = "numberversion", nullable = false)
	public int getNumberversion() {
		return this.numberversion;
	}

	public void setNumberversion(int numberversion) {
		this.numberversion = numberversion;
	}

	@Column(name = "enabledversion", nullable = false)
	public int getEnabledversion() {
		return this.enabledversion;
	}

	public void setEnabledversion(int enabledversion) {
		this.enabledversion = enabledversion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tproductversion")
	@JsonIgnore
	public Set<Tticket> getTtickets() {
		return this.ttickets;
	}

	public void setTtickets(Set<Tticket> ttickets) {
		this.ttickets = ttickets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tproductversion")
	@JsonIgnore
	public Set<Ttickoprodversresol> getTtickoprodversresols() {
		return this.ttickoprodversresols;
	}

	public void setTtickoprodversresols(Set<Ttickoprodversresol> ttickoprodversresols) {
		this.ttickoprodversresols = ttickoprodversresols;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproduct", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Tproduct getTproduct() {
		return tproduct;
	}

	public void setTproduct(Tproduct tproduct) {
		this.tproduct = tproduct;
	}

}
