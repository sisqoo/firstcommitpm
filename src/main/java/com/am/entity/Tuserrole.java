package com.am.entity;
// Generated 20 nov. 2018 18:53:33 by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * Tuserrole generated by hbm2java
 */
@Entity
@Table(name = "tuserrole", catalog = "projectmanagement")
@DynamicUpdate
public class Tuserrole implements java.io.Serializable {

	private Long iduserrole;
	private Trole trole;
	private Tuser tuser;

	public Tuserrole() {
	}

	public Tuserrole(Long iduserrole, Trole trole, Tuser tuser) {
		this.iduserrole = iduserrole;
		this.trole = trole;
		this.tuser = tuser;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iduserrole", unique = true, nullable = false)
	public Long getIduserrole() {
		return this.iduserrole;
	}

	public void setIduserrole(Long iduserrole) {
		this.iduserrole = iduserrole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idrole", nullable = false)
	public Trole getTrole() {
		return this.trole;
	}

	public void setTrole(Trole trole) {
		this.trole = trole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iduser", nullable = false)
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

}
