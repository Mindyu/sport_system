package com.mindyu.sport_system.controller;

import com.mindyu.sport_system.entity.Result;
import com.mindyu.sport_system.pojo.User;
import com.mindyu.sport_system.service.UserService;
import com.mindyu.sport_system.util.Md5Util;
import com.mindyu.sport_system.util.Salt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public User findOne(@PathVariable Integer id){
		return userService.findOne(id);
	}

	@RequestMapping(value="/login",method= RequestMethod.POST)
	public Result login(@RequestBody User user){
		System.out.println(user);
		User user_info = userService.findByUserName(user.getUserName());
		if (user_info == null){	// 用户不存在则注册
			return add(user);
		}
		try {
			String password = Md5Util.getEncryptedPwd(user.getPassword(), user_info.getSalt());
			if (user_info.getPassword().equals(password)){
				return new Result(200,"", new com.mindyu.sport_system.dto.User(user_info));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new Result(500,"用户名或密码有误");
	}
	
	/**
	 * 增加
	 * @param user
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Result add(@RequestBody User user  ){
		User user_info = userService.findByUserName(user.getUserName());
		if (user_info!=null){
			return new Result(500,"用户名已存在");
		}
		String salt = Salt.getRandomSalt();
		user.setSalt(salt);
		try {
			String password = Md5Util.getEncryptedPwd(user.getPassword(), salt);
			user.setPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500,"密码转换有误");
		}
		user.setStatus(0);
		userService.add(user);
		return new Result(200,"注册成功");
	}
	
	/**
	 * 修改
	 * @param user
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Result update(@RequestBody User user,@PathVariable Integer id ){
		user.setId(id);

		if (user.getPassword()!=null && !"".equals(user.getPassword())){
			String salt = Salt.getRandomSalt();
			user.setSalt(salt);
			try {
				user.setPassword(Md5Util.getEncryptedPwd(user.getPassword(), salt));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(500,"密码转换有误");
			}
		}
        System.out.println(user);
		userService.update(user);		
		return new Result(200,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Result delete(@PathVariable Integer id ){
		userService.delete(id);
		return new Result(200,"删除成功");
	}
	
}
