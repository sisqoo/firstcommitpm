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
 * Tview generated by hbm2java
 */
@Entity
@Table(name = "tview", catalog = "projectmanagement")
public class Tview implements java.io.Serializable {

	private long idview;
	private String nameview;
	private String progview;
	private int enabledview;
	@JsonIgnore
	private Set<Troleview> troleviews = new HashSet<Troleview>(0);

	public Tview() {
	}

	public Tview(long idview, String nameview, int enabledview) {
		this.idview = idview;
		this.nameview = nameview;
		this.enabledview = enabledview;
	}

	public Tview(long idview, String nameview, String progview, int enabledview,
			Set<Troleview> troleviews) {
		this.idview = idview;
		this.nameview = nameview;
		this.progview = progview;
		this.enabledview = enabledview;
		this.troleviews = troleviews;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idview", unique = true, nullable = false)
	public long getIdview() {
		return this.idview;
	}

	public void setIdview(long idview) {
		this.idview = idview;
	}

	@Column(name = "nameview", nullable = false, length = 30)
	public String getNameview() {
		return this.nameview;
	}

	public void setNameview(String nameview) {
		this.nameview = nameview;
	}

	@Column(name = "progview", length = 60)
	public String getProgview() {
		return this.progview;
	}

	public void setProgview(String progview) {
		this.progview = progview;
	}

	@Column(name = "enabledview", nullable = false)
	public int getEnabledview() {
		return this.enabledview;
	}

	public void setEnabledview(int enabledview) {
		this.enabledview = enabledview;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tview")
	@JsonIgnore
	public Set<Troleview> getTroleviews() {
		return this.troleviews;
	}

	public void setTroleviews(Set<Troleview> troleviews) {
		this.troleviews = troleviews;
	}

}
