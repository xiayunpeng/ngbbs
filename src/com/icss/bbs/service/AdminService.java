package com.icss.bbs.service;

import com.icss.bbs.dao.AdminDao;
import com.icss.bbs.pojo.Admin;

/**
 * 用户登录业务
 * @author Administrator
 *
 */
public class AdminService {
	
	private AdminDao dao = new AdminDao();
	
	/**
	 * 
	 * @param admin 传入用户对象
	 * @return 
	 * 	如果用户名不存在 返回1
	 * 	如果密码错误 返回2
	 *  如果登录成功 返回3
	 * @throws Exception 
	 */
	public int checkUser(Admin ad) throws Exception {
		
		Admin admin = dao.queryByUsername(ad.getUsername());
		
		if (admin == null) {
			return 1;
		} else if (!ad.getUserpwd().equals(admin.getUserpwd())) {
			return 2;
		} else {
			return 3;
		}
		
	}

}
