package com.mindyu.sport_system.service;

import com.mindyu.sport_system.dao.InfoDao;
import com.mindyu.sport_system.pojo.Info;
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
import java.util.List;
import java.util.Map;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class InfoService {

	@Autowired
	private InfoDao infoDao;

	public List<Info> findAll() {

		return infoDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Info> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return infoDao.findAll(pageRequest);
	}

	private Specification<Info> where(final Map searchMap) {
		
		return new Specification<Info>() {
          
			@Override
			public Predicate toPredicate(Root<Info> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))) {
                	predicateList.add(cb.like(root.get("phone").as(String.class), "%"+(String)searchMap.get("phone")+"%"));
                }
                // 
                if (searchMap.get("address")!=null && !"".equals(searchMap.get("address"))) {
                	predicateList.add(cb.like(root.get("address").as(String.class), "%"+(String)searchMap.get("address")+"%"));
                }
                // 
                if (searchMap.get("extra")!=null && !"".equals(searchMap.get("extra"))) {
                	predicateList.add(cb.like(root.get("extra").as(String.class), "%"+(String)searchMap.get("extra")+"%"));
                }
                // 
                if (searchMap.get("intro")!=null && !"".equals(searchMap.get("intro"))) {
                	predicateList.add(cb.like(root.get("intro").as(String.class), "%"+(String)searchMap.get("intro")+"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Info> findSearch(Map whereMap, int page, int size) {
		Specification<Info> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return infoDao.findAll(specification, pageRequest);
	}

	public Info findOne(Integer id) {
		return infoDao.findById(id).get();
	}

	public void add(Info info) {
		infoDao.save(info);
	}
	
	public void update(Info info) {
		infoDao.save(info);
	}

	public void delete(Integer id) {
		infoDao.deleteById(id);
	}

	public void deleteList(Integer[] ids) {
		for (Integer id : ids) {
			infoDao.deleteById(id);
		}
	}

	public Info findInfoByUserId(Integer userId){
		return infoDao.getInfoByUserId(userId);
	}

}
