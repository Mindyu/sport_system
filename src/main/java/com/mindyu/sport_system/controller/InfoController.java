package com.mindyu.sport_system.controller;

import com.mindyu.sport_system.pojo.Info;
import com.mindyu.sport_system.service.InfoService;
import com.mindyu.sport_system.entity.PageResult;
import com.mindyu.sport_system.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private InfoService infoService;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Info> findAll(){
		return infoService.findAll();
	}
	
	/**
	 * 根据user_ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Info findInfoByUserId(@PathVariable Integer id){
		return infoService.findInfoByUserId(id);
	}
	
	/**
	 * 分页查询全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/{page}/{size}",method=RequestMethod.GET)
	public PageResult<Info> findPage(@PathVariable int page,@PathVariable int size){		
		Page<Info> pageList = infoService.findPage(page, size);
		return new PageResult<Info>(pageList.getTotalElements(), pageList.getContent());		
	}
	
	/**
	 * 分页+多条件查询 
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/{page}/{size}",method=RequestMethod.POST)
	public PageResult<Info> findSearch(@RequestBody Map searchMap ,@PathVariable int page,@PathVariable int size){		
		Page<Info> pageList = infoService.findSearch(searchMap, page, size);
		return new PageResult<Info>(pageList.getTotalElements(), pageList.getContent());		
	}
	
	/**
	 * 增加
	 * @param info
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Result add(@RequestBody Info info  ){

		info.setStatus(0);
		info.setCreatedAt(new Date());
		info.setUpdatedAt(new Date());
		infoService.add(info);	
		
		return new Result(200,"新增成功");
	}
	
	/**
	 * 修改
	 * @param info
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Result update(@RequestBody Info info,@PathVariable Integer id ){
		info.setId(id);
		info.setUpdatedAt(new Date());
		infoService.update(info);
		return new Result(200,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Result delete(@PathVariable Integer id ){
		infoService.delete(id);
		return new Result(200,"删除成功");
	}
	
}
