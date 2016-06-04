package com.java.truth.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.truth.entity.User;
import com.java.truth.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexAct {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/index.html")
	public String toIndex(HttpServletRequest request,Model model){
		Long userId = Long.parseLong(request.getParameter("id"));
		User user = null;
		try{
		   user = this.userService.selectByPrimaryKey(userId);
		   System.out.println("user:"+user);
		}catch(Exception e){
			e.printStackTrace();
			user=new User();
		}
		user.setUserName("13760697997");
		model.addAttribute("user", user);
		return "index";
	}
	
}
