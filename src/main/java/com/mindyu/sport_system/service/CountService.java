package com.mindyu.sport_system.service;


import com.mindyu.sport_system.dao.CountDao;
import com.mindyu.sport_system.pojo.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class CountService {

	@Autowired
	private CountDao countDao;

	public List<Count> findAll() {

		return countDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Count> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return countDao.findAll(pageRequest);
	}

	private Specification<Count> where(Map searchMap) {
		
		return new Specification<Count>() {
          
			@Override
			public Predicate toPredicate(Root<Count> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Count> findSearch(Map whereMap, int page, int size) {
		Specification<Count> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return countDao.findAll(specification, pageRequest);
	}

	public Count findOne(Integer id) {

		return countDao.findById(id).get();
	}

	public Count findToday(Integer id, Date date) {

		return countDao.getCountByUserIdAndDateGreaterThanEqual(id, date);
	}

	public void add(Count count) {
		countDao.save(count);
	}
	
	public void update(Count count) {
		countDao.save(count);
	}

	public void delete(Integer id) {
		countDao.deleteById(id);
	}

	public void deleteList(Integer[] ids) {
		for (Integer id : ids) {
			countDao.deleteById(id);
		}
	}

	public List<Count> getCountsByUserId(Integer userId){
		return countDao.getCountsByUserIdOrderByDateDesc(userId);
	}
}
