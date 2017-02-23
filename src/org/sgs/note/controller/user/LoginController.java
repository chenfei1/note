package org.sgs.note.controller.user;

import javax.annotation.Resource;

import org.sgs.note.entiy.NoteResult;
import org.sgs.note.entiy.User;
import org.sgs.note.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//扫描控制组件
@RequestMapping("/user")
public class LoginController {
	
	@Resource
	private UserService userService;//注入
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult execute(String name,String pwd) throws Exception{
		NoteResult result = userService.checkLogin(name,pwd);
		
		return result;
	}
}
