package com.am.entity;
// Generated 20 nov. 2018 18:53:33 by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Tperson generated by hbm2java
 */
@Entity
@Table(name = "tworkcolumndata", catalog = "projectmanagement")
@DynamicUpdate
public class Tworkcolumndata implements java.io.Serializable {

	private Long idworkcolumndata;
	private Long idsession;
	private String codeworkdata;
	private Long columnworkdata;
	private String c1;
	private String c2;
	private String c3;
	private String c4;
	private String c5;
	private String c6;
	private String c7;
	private String c8;
	private String c9;
	private String c10;
	private Integer n1;
	private Integer n2;
	private Integer n3;
	private Integer n4;
	private Integer n5;
	private Integer n6;
	private Integer n7;
	private Integer n8;
	private Integer n9;
	private Integer n10;
	
	
	
	public String getC1() {
		return c1;
	}



	public void setC1(String c1) {
		this.c1 = c1;
	}



	public String getC2() {
		return c2;
	}



	public void setC2(String c2) {
		this.c2 = c2;
	}



	public String getC3() {
		return c3;
	}



	public void setC3(String c3) {
		this.c3 = c3;
	}



	public String getC4() {
		return c4;
	}



	public void setC4(String c4) {
		this.c4 = c4;
	}



	public String getC5() {
		return c5;
	}



	public void setC5(String c5) {
		this.c5 = c5;
	}



	public String getC6() {
		return c6;
	}



	public void setC6(String c6) {
		this.c6 = c6;
	}



	public String getC7() {
		return c7;
	}



	public void setC7(String c7) {
		this.c7 = c7;
	}



	public String getC8() {
		return c8;
	}



	public void setC8(String c8) {
		this.c8 = c8;
	}



	public String getC9() {
		return c9;
	}



	public void setC9(String c9) {
		this.c9 = c9;
	}



	public String getC10() {
		return c10;
	}



	public void setC10(String c10) {
		this.c10 = c10;
	}



	public Integer getN1() {
		return n1;
	}



	public void setN1(Integer n1) {
		this.n1 = n1;
	}



	public Integer getN2() {
		return n2;
	}



	public void setN2(Integer n2) {
		this.n2 = n2;
	}



	public Integer getN3() {
		return n3;
	}



	public void setN3(Integer n3) {
		this.n3 = n3;
	}



	public Integer getN4() {
		return n4;
	}



	public void setN4(Integer n4) {
		this.n4 = n4;
	}



	public Integer getN5() {
		return n5;
	}



	public void setN5(Integer n5) {
		this.n5 = n5;
	}



	public Integer getN6() {
		return n6;
	}



	public void setN6(Integer n6) {
		this.n6 = n6;
	}



	public Integer getN7() {
		return n7;
	}



	public void setN7(Integer n7) {
		this.n7 = n7;
	}



	public Integer getN8() {
		return n8;
	}



	public void setN8(Integer n8) {
		this.n8 = n8;
	}



	public Integer getN9() {
		return n9;
	}



	public void setN9(Integer n9) {
		this.n9 = n9;
	}



	public Integer getN10() {
		return n10;
	}



	public void setN10(Integer n10) {
		this.n10 = n10;
	}



	public Long getIdsession() {
		return idsession;
	}



	public void setIdsession(Long idsession) {
		this.idsession = idsession;
	}



	public String getCodeworkdata() {
		return codeworkdata;
	}



	public void setCodeworkdata(String codeworkdata) {
		this.codeworkdata = codeworkdata;
	}



	public Long getColumnworkdata() {
		return columnworkdata;
	}



	public void setColumnworkdata(Long columnworkdata) {
		this.columnworkdata = columnworkdata;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/*@GeneratedValue(strategy=GenerationType.TABLE , generator="employee_generator")
	@TableGenerator(name="employee_generator", 
	                table="pk_table", 
	                pkColumnName="name", 
	                valueColumnName="value",                            
	                allocationSize=100)*/ 
	@Column(name = "idworkcolumndata", unique = true, nullable = false)
	public Long getIdworkcolumndata() {
		return this.idworkcolumndata;
	}

	public void setIdworkcolumndata(Long idworkcolumndata) {
		this.idworkcolumndata = idworkcolumndata;
	}



	
}
