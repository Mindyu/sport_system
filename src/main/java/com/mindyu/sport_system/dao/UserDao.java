package com.mindyu.sport_system.dao;

import com.mindyu.sport_system.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {
	User findUserByUserName(String username);
}
