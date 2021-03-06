package com.am.service;

import java.util.List;

import com.am.entity.Tperson;
import com.am.entity.Tworklinedata;

public interface WorklinedataService {

	public Tworklinedata save(Tworklinedata tworklinedata);

	public List<Tworklinedata> saveAll(List<Tworklinedata> tworklinedata);

	List<Tworklinedata> findByIdsession(Long idsession);

	List<Tworklinedata> findByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);

	public void delete(Long idworklinedata);

	void deleteByIdsession(Long idsession);

	void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);

}
