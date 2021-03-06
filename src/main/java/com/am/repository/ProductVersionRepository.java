
package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tproductversion;


public interface ProductVersionRepository extends CrudRepository<Tproductversion, Long>, JpaSpecificationExecutor {
	
	@Query("select v from Tproductversion v order by v.nameversion")
	List<Tproductversion> findAll();
	
	Tproductversion findByIdproductversion(long idproductversion);
	
}
