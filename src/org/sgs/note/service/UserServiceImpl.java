package org.sgs.note.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.sgs.note.dao.UserDao;
import org.sgs.note.entiy.NoteResult;
import org.sgs.note.entiy.User;
import org.sgs.note.util.NoteUtil;
import org.springframework.stereotype.Service;
@ Service//扫描Service组件
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	public NoteResult checkLogin(String name,String pwd) throws Exception{
		NoteResult result = new NoteResult();
		
		
		User user = userDao.findByName(name);
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//将用户输入的pwd密码加密
		String md5_pwd = NoteUtil.md5(pwd);
		//将数据库密码比对
		if(!user.getCn_user_password().equals(md5_pwd)){
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		result.setData(user.getCn_user_id());
		return result;
	}
	public NoteResult regist(String name, String password, String nickname)throws Exception {
		NoteResult result = new NoteResult();
		//检测用户名是否被占用
		User has_user = userDao.findByName(name);
		if(has_user != null){
			result.setStatus(1);
			result.setMsg("用户名已经被占用");
			return result;
			}
		//注册
		User user = new User();
		user.setCn_user_name(name);//设置用户名
		user.setCn_user_desc(nickname);//设置昵称
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);//设置加密密码
		String userId = NoteUtil.creatId();
		user.setCn_user_id(userId);//设置id
		//调用userDao保存
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");

		
		return result;
	}
}
