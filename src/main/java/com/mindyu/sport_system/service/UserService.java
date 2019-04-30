package com.mindyu.sport_system.service;

import com.mindyu.sport_system.dao.UserDao;
import com.mindyu.sport_system.pojo.User;
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
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> findAll() {

		return userDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<User> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return userDao.findAll(pageRequest);
	}

	private Specification<User> where(final Map searchMap) {
		
		return new Specification<User>() {
          
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("user_name")!=null && !"".equals(searchMap.get("user_name"))) {
                	predicateList.add(cb.like(root.get("user_name").as(String.class), "%"+(String)searchMap.get("user_name")+"%"));
                }
                // 
                if (searchMap.get("password")!=null && !"".equals(searchMap.get("password"))) {
                	predicateList.add(cb.like(root.get("password").as(String.class), "%"+(String)searchMap.get("password")+"%"));
                }
                // 
                if (searchMap.get("Salt")!=null && !"".equals(searchMap.get("Salt"))) {
                	predicateList.add(cb.like(root.get("Salt").as(String.class), "%"+(String)searchMap.get("Salt")+"%"));
                }
                // 
                if (searchMap.get("avator")!=null && !"".equals(searchMap.get("avator"))) {
                	predicateList.add(cb.like(root.get("avator").as(String.class), "%"+(String)searchMap.get("avator")+"%"));
                }
                // 
                if (searchMap.get("email")!=null && !"".equals(searchMap.get("email"))) {
                	predicateList.add(cb.like(root.get("email").as(String.class), "%"+(String)searchMap.get("email")+"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<User> findSearch(Map whereMap, int page, int size) {
		Specification<User> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return userDao.findAll(specification, pageRequest);
	}

	public User findOne(Integer id) {
		return userDao.findById(id).get();
	}

	public User findByUserName(String username) {
		return userDao.findUserByUserName(username);
	}

	public void add(User user) {
		userDao.save(user);
	}
	
	public void update(User user) {
		userDao.saveAndFlush(user);
	}

	public void delete(Integer id) {
		userDao.deleteById(id);
	}

	public void deleteList(Integer[] ids) {
		for (Integer id : ids) {
			userDao.deleteById(id);
		}
	}

}
