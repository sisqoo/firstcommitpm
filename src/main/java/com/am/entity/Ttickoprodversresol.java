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
 * Ttickoprodversresol generated by hbm2java
 */
@Entity
@Table(name = "ttickoprodversresol", catalog = "projectmanagement")
@DynamicUpdate
public class Ttickoprodversresol implements java.io.Serializable {

	private Long idtickoprodversresol;
	private Tproductversion tproductversion;
	private Tticket tticket;
	private Tvocabword tvocabword;

	public Ttickoprodversresol() {
	}

	public Ttickoprodversresol(Long idtickoprodversresol, Tproductversion tproductversion, Tticket tticket,
			Tvocabword tvocabword) {
		this.idtickoprodversresol = idtickoprodversresol;
		this.tproductversion = tproductversion;
		this.tticket = tticket;
		this.tvocabword = tvocabword;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtickoprodversresol", unique = true, nullable = false)
	public Long getIdtickoprodversresol() {
		return this.idtickoprodversresol;
	}

	public void setIdtickoprodversresol(Long idtickoprodversresol) {
		this.idtickoprodversresol = idtickoprodversresol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproductversion", nullable = false)
	public Tproductversion getTproductversion() {
		return this.tproductversion;
	}

	public void setTproductversion(Tproductversion tproductversion) {
		this.tproductversion = tproductversion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idticket", nullable = false)
	public Tticket getTticket() {
		return this.tticket;
	}

	public void setTticket(Tticket tticket) {
		this.tticket = tticket;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voctiketresol", nullable = false)
	public Tvocabword getTvocabword() {
		return this.tvocabword;
	}

	public void setTvocabword(Tvocabword tvocabword) {
		this.tvocabword = tvocabword;
	}

}
