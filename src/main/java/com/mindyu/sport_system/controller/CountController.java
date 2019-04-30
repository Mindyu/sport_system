package com.mindyu.sport_system.controller;

import com.mindyu.sport_system.entity.PageResult;
import com.mindyu.sport_system.entity.Result;
import com.mindyu.sport_system.pojo.Count;
import com.mindyu.sport_system.service.CountService;
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
@RequestMapping("/count")
public class CountController {

	@Autowired
	private CountService countService;


	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Count> findByUserId(@RequestBody Count count ){
		return countService.getCountsByUserId(count.getUserId());
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Count findOne(@PathVariable Integer id){
		return countService.findOne(id);
	}
	
	/**
	 * 分页查询全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/{page}/{size}",method=RequestMethod.GET)
	public PageResult<Count> findPage(@PathVariable int page, @PathVariable int size){
		Page<Count> pageList = countService.findPage(page, size);
		return new PageResult<Count>(pageList.getTotalElements(), pageList.getContent());		
	}
	
	/**
	 * 分页+多条件查询 
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/{page}/{size}",method=RequestMethod.POST)
	public PageResult<Count> findSearch(@RequestBody Map searchMap ,@PathVariable int page,@PathVariable int size){		
		Page<Count> pageList = countService.findSearch(searchMap, page, size);
		return new PageResult<Count>(pageList.getTotalElements(), pageList.getContent());		
	}
	
	/**
	 * 增加
	 * @param count
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Result add(@RequestBody Count count){
		count.setDate(new Date());
		count.setStatus(0);
		countService.add(count);	
		
		return new Result(200,"新增成功");
	}
	
	/**
	 * 修改
	 * @param count
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Result update(@RequestBody Count count,@PathVariable Integer id ){
		count.setId(id);
		countService.update(count);		
		return new Result(200,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Result delete(@PathVariable Integer id ){
		countService.delete(id);
		return new Result(200,"删除成功");
	}

}
