package com.exsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;



import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exsample.service.MainTableService;
import com.exsample.entity.MainTable;
import com.exsample.entity.MainTableId;
import com.exsample.repository.MainTableRepository;
import com.exsample.entity.User;

@Service
@Transactional
public class MainTableServiceImpl implements MainTableService {

	  @PersistenceContext
	  private EntityManager entityManager;
	  
		// Implementing Constructor based DI
		private MainTableRepository repository;
		
		public MainTableServiceImpl() {
			
		}
		
		@Autowired
		public MainTableServiceImpl(MainTableRepository repository) {
			super();
			this.repository = repository;
		}
	
	@Override
	public List<MainTable> getAllMainTables() {
		List<MainTable> list = new ArrayList<MainTable>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public MainTable getMainTableById(MainTableId id) {
		
		MainTable entity = entityManager.find(MainTable.class, id);
		
		return entity;
	}
	
	@Override
	public List<MainTable> getMainTableByIds(List<MainTableId> ids) {
		
		  CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		    CriteriaQuery<MainTable> criteria_query = builder.createQuery(MainTable.class);
		    
		    Root<MainTable> root = criteria_query.from(MainTable.class);
		    
		    Subquery<Long> sq = criteria_query.subquery(Long.class);
		    Root<User>  tableB = sq.from(User.class);		    
		    sq.select(tableB.get("id"));
		    sq.where(builder.equal(tableB.get("id"), 3));
		    
		    criteria_query.select(root);
		    criteria_query.where( //
		    		builder.equal(root.get("id"), sq)
		    	);
		    
		    List<MainTable> list = entityManager.createQuery(criteria_query).getResultList();
		    
		   return list;
	}
	
	
	@Override
	public boolean saveMainTable(MainTable mainTable) {
		try {
			//mainTable.setId(new MainTableId(new Long(101), new Long(1)));
			//mainTable.setId(new MainTableId());
			repository.save(mainTable);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteMainTableById(Long id, Long sub_id) {
		try {
			repository.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}

}
