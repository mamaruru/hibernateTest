package com.exsample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exsample.entity.RefTable;

@Repository
public interface RefRepository extends CrudRepository<RefTable, Long>{
	
}