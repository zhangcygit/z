package com.zhiyou.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;
@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	UserMapper mapper;
	
	public void add(User user) {
		mapper.add(user);

	}

	public void update(User user) {
		mapper.update(user);

	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	public User selectByAccounts(HttpServletRequest req, String accounts, String password) {
		User user = mapper.selectByAccounts(req, accounts, password);
		if (user != null) {
			if (user.getPassword().equals(password)) {
			} else {
				req.setAttribute("msg", "密码错误，请重新输入");
				return null;
			}
		} else {
			req.setAttribute("msg", "用户不存在");
			return null;
		}
		return user;
	}



  /*  //注册
	public void registerByAccountsAndPassword(String accounts, String password) {
		
		mapper.registerByAccountsAndPassword(accounts, password);
	}*/

/*	public User findUserByLogin(String accounts, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("accounts", accounts);
		map.put("password", password);
		User user = mapper.findUserByLogin(map);
		return user;
	}*/

	
}
