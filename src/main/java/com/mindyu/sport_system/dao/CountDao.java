package com.mindyu.sport_system.dao;

import com.mindyu.sport_system.pojo.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;
import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface CountDao extends JpaRepository<Count,Integer>,JpaSpecificationExecutor<Count> {
	List<Count> getCountsByUserIdOrderByDateDesc(Integer userId);
	Count getCountByUserIdAndDateGreaterThanEqual(Integer userId, Date date);
}
