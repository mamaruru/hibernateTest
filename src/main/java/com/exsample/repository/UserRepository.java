package com.exsample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exsample.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
}