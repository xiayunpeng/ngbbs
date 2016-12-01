package test;

import org.junit.Test;

import com.icss.bbs.pojo.Admin;
import com.icss.bbs.service.AdminService;

public class TestAdminService {
	
	private AdminService service = new AdminService();
	
	@Test
	public void testCheckUser() throws Exception {
		
		Admin admin = new Admin("admin","123456");
		
		int result = service.checkUser(admin);
		
		System.out.println(result);
		
	}

}
