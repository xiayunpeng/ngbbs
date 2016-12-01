package test;

import org.junit.Test;

import com.icss.bbs.dao.AdminDao;
import com.icss.bbs.pojo.Admin;

public class TestAdminDao {
	
	private AdminDao dao = new AdminDao();
	
	@Test
	public void testQueryByUsername() throws Exception {
		
		Admin admin = dao.queryByUsername("sdfdsfds");
		
		System.out.println(admin);
		
	}

}