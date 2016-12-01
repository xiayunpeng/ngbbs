package com.icss.bbs.service;

import java.util.ArrayList;

import com.icss.bbs.common.Pager;
import com.icss.bbs.dao.MessageDao;
import com.icss.bbs.pojo.Message;

/**
 * ÒµÎñÂß¼­Àà
 * @author Administrator
 *
 */
public class MessageService {
	
	private MessageDao dao = new MessageDao();
	
	public void insert(Message msg) throws Exception {				
		dao.insert(msg);
	}
	
	public int getCount() throws Exception {
		return dao.getCount();
	}
	
	public ArrayList<Message> query(Pager pager) throws Exception {
		return dao.query(pager);
	}
	
	public void updateHit(int id) throws Exception{
		dao.updateHit(id);
	}
	
	public void delete(int id) throws Exception {
		dao.delete(id);
	}
	
	public Message get(int id) throws Exception {
		return dao.get(id);
	}
	
	public void update(Message msg) throws Exception {
		dao.update(msg);
	}

}