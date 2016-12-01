package test;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.icss.bbs.common.Pager;
import com.icss.bbs.dao.MessageDao;
import com.icss.bbs.pojo.Message;

public class TestBbsDao {
	
	private MessageDao dao = new MessageDao();
	
	@Test
	public void testInsert() throws Exception {
		
		Message msg = new Message("rose","这是测试评论2",new Date(),"192.168.100.200",0);		
		dao.insert(msg);		
	}

	@Test
	public void testInsertMany() throws Exception {		
		for (int i = 1;i <= 20;i ++) {			
			Message msg = new Message("jack" + i,"这是测试评论" + i,new Date(),"192.168.100.200",0);		
			dao.insert(msg);			
		}		
	}
	
	@Test
	public void testGetCount() throws Exception {		
		int count = dao.getCount();
		System.out.println(count);
	}
	
	@Test
	public void testUpdateHit() throws Exception {		
		dao.updateHit(17);
	}
	
	@Test
	public void testDelete() throws Exception {		
		dao.delete(16);
	}
	
	@Test
	public void testQuery() throws Exception {		
		
		Pager pager = new Pager(dao.getCount(),10,3);
		
		ArrayList<Message> list = dao.query(pager);
		
		for (Message msg : list) {
			System.out.println(msg);
		}		
	}
	
	@Test
	public void testGet() throws Exception {		
		Message msg = dao.get(15);
		System.out.println(msg);
	}
	
	@Test
	public void testUpdate() throws Exception {		
		
		Message msg = new Message();
		msg.setId(11);
		msg.setUsername("11111");
		msg.setContent("22222");
		
		dao.update(msg);		
	}
}