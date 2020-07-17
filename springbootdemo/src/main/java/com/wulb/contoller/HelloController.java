package com.wulb.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wulb.mapper.UserMapper;
import com.wulb.pojo.User;

@Controller
public class HelloController {
	@Autowired
	UserMapper userMapper;
	
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping("/")
	public String toIndex(HttpServletRequest request) {
		//ModelAndView modelAndView = new ModelAndView();
		//已经在properties中进行了配置，可以直接不用写后缀
		//modelAndView.setViewName("login");
		return "login";
	}
	
	@RequestMapping("/selectUserById")
	public User selectUserById(){
		User us=userMapper.selectUserById(1);
		return us;
	}
	
	@RequestMapping("/insertUser")
	public int insertUser() {
		User user = new User();
		user.setUname("吴林玻");
		user.setUsex("男");
		user.setHoby("篮球");
		int result = userMapper.insertUser(user);
		System.out.println("插入"+result+"条数据，数据为"+user);
		return result;
	}
	
	@RequestMapping("/delUser")
	public int delUser() {
		int result;
		result = userMapper.delUser(1);
		return result;
	}
	
	
	@RequestMapping("/updateUser")
	public int updateUser(){
		User user = new User(2,"zwn","女","alb");
		int  result=userMapper.updateUser(user);
		return result;
	}
	
	//test1
	@RequestMapping("/test1")
	@ResponseBody
	public String test1(String name,String sex) {
		String s1 = name;
		return s1;
	}
}
