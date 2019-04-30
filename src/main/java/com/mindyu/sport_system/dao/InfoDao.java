package com.mindyu.sport_system.dao;

import com.mindyu.sport_system.pojo.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface InfoDao extends JpaRepository<Info,Integer>,JpaSpecificationExecutor<Info> {
    Info getInfoByUserId(Integer userId);
}
