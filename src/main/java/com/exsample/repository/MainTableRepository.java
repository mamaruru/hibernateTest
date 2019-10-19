package com.exsample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.exsample.entity.MainTable;
import com.exsample.entity.MainTableId;

@Repository
public interface MainTableRepository extends CrudRepository<MainTable, Long>{


}