package com.am.entity;
// Generated 20 nov. 2018 18:53:33 by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	private Long idrole;
	private String namerole;
	private Integer enabledrole;
	private String descrole;
	private Set<Troleview> troleviews = new HashSet<Troleview>(0);
	private Set<Tuserrole> tuserroles = new HashSet<Tuserrole>(0);

	public Trole() {
	}

	public Trole(Long idrole, String namerole, Integer enabledrole) {
		this.idrole = idrole;
		this.namerole = namerole;
		this.enabledrole = enabledrole;
	}

	public Trole(Long idrole, String namerole, Integer enabledrole, String descrole, Set<Troleview> troleviews,
			Set<Tuserrole> tuserroles) {
		this.idrole = idrole;
		this.namerole = namerole;
		this.enabledrole = enabledrole;
		this.descrole = descrole;
		this.troleviews = troleviews;
		this.tuserroles = tuserroles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idrole", unique = true, nullable = false)
	public Long getIdrole() {
		return this.idrole;
	}

	public void setIdrole(Long idrole) {
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
	public Integer getEnabledrole() {
		return this.enabledrole;
	}

	public void setEnabledrole(Integer enabledrole) {
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
	@JsonIgnore
	public Set<Troleview> getTroleviews() {
		return this.troleviews;
	}

	public void setTroleviews(Set<Troleview> troleviews) {
		this.troleviews = troleviews;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trole")
	@JsonIgnore
	public Set<Tuserrole> getTuserroles() {
		return this.tuserroles;
	}

	public void setTuserroles(Set<Tuserrole> tuserroles) {
		this.tuserroles = tuserroles;
	}

}
