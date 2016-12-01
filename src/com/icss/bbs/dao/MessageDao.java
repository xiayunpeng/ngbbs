package com.icss.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.icss.bbs.common.DbUtil;
import com.icss.bbs.common.Pager;
import com.icss.bbs.pojo.Message;

/**
 * DAO类
 * 
 * @author Administrator
 * 
 */
public class MessageDao {

	/**
	 * 增加功能
	 * 
	 * @param msg
	 * @throws Exception
	 */
	public void insert(Message msg) throws Exception {

		Connection conn = DbUtil.getConnection();
		String sql = "insert into message values (default,?,?,?,?,default)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, msg.getUsername());
		pstmt.setString(2, msg.getContent());
		pstmt.setTimestamp(3, new Timestamp(msg.getCreatetime().getTime()));
		pstmt.setString(4, msg.getIp());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	/**
	 * 更新赞的列值+1
	 * @param id
	 * @throws Exception
	 */
	public void updateHit(int id) throws Exception {
		Connection conn = DbUtil.getConnection();
		String sql = "UPDATE message SET hit=hit+1 WHERE id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);	
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		String sql = "DELETE FROM message WHERE id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);	
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();		
	}
	
	/**
	 * 更新
	 * @param msg
	 * @throws Exception
	 */
	public void update(Message msg) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		String sql = "UPDATE message SET username=?,content=? WHERE id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, msg.getUsername());
		pstmt.setString(2, msg.getContent());
		pstmt.setInt(3, msg.getId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();		
	}
	
	/**
	 * 查询单条数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Message get(int id) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT * FROM message WHERE id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);				
		ResultSet rs = pstmt.executeQuery();
		
		Message msg = null;
		
		if (rs.next()) {
			 msg = new Message(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getTimestamp(4), rs.getString(5),
						rs.getInt(6));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return msg;	
	}

	/**
	 * 返回表的总记录数
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getCount() throws Exception {

		Connection conn = DbUtil.getConnection();
		String sql = "SELECT COUNT(*) FROM message";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		rs.close();
		pstmt.close();
		conn.close();
		return count;
	}

	/**
	 * 分页查询
	 * @param pager
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Message> query(Pager pager) throws Exception {

		ArrayList<Message> list = new ArrayList<Message>();

		Connection conn = DbUtil.getConnection();
		String sql = "SELECT * FROM message order by id desc LIMIT ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pager.getStart() - 1);
		pstmt.setInt(2, pager.getPageSize());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Message msg = new Message(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getTimestamp(4), rs.getString(5),
					rs.getInt(6));

			list.add(msg);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
}
