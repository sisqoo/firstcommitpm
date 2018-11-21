package com.am.entity;
// Generated 20 nov. 2018 18:53:33 by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Trole generated by hbm2java
 */
@Entity
@Table(name = "trole", catalog = "projectmanagement")
public class Trole implements java.io.Serializable {

	private int idrole;
	private String namerole;
	private int enabledrole;
	private String descrole;
	@JsonIgnore
	private Set<Troleview> troleviews = new HashSet<Troleview>(0);
	@JsonIgnore
	private Set<Tuserrole> tuserroles = new HashSet<Tuserrole>(0);

	public Trole() {
	}

	public Trole(int idrole, String namerole, int enabledrole) {
		this.idrole = idrole;
		this.namerole = namerole;
		this.enabledrole = enabledrole;
	}

	public Trole(int idrole, String namerole, int enabledrole, String descrole, Set<Troleview> troleviews,
			Set<Tuserrole> tuserroles) {
		this.idrole = idrole;
		this.namerole = namerole;
		this.enabledrole = enabledrole;
		this.descrole = descrole;
		this.troleviews = troleviews;
		this.tuserroles = tuserroles;
	}

	@Id
	@Column(name = "idrole", unique = true, nullable = false)
	public int getIdrole() {
		return this.idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	@Column(name = "namerole", nullable = false, length = 30)
	public String getNamerole() {
		return this.namerole;
	}

	public void setNamerole(String namerole) {
		this.namerole = namerole;
	}

	@Column(name = "enabledrole", nullable = false)
	public int getEnabledrole() {
		return this.enabledrole;
	}

	public void setEnabledrole(int enabledrole) {
		this.enabledrole = enabledrole;
	}

	@Column(name = "descrole", length = 120)
	public String getDescrole() {
		return this.descrole;
	}

	public void setDescrole(String descrole) {
		this.descrole = descrole;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trole")
	public Set<Troleview> getTroleviews() {
		return this.troleviews;
	}

	public void setTroleviews(Set<Troleview> troleviews) {
		this.troleviews = troleviews;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trole")
	public Set<Tuserrole> getTuserroles() {
		return this.tuserroles;
	}

	public void setTuserroles(Set<Tuserrole> tuserroles) {
		this.tuserroles = tuserroles;
	}

}
