package com.icss.bbs.pojo;

import java.util.Date;

/**
 * 实体类
 * 
 * @author Administrator
 * 
 */
public class Message {

	private int id;

	private String username;

	private String content;

	private Date createtime;

	private String ip;

	private int hit;

	public Message() {
		super();
	}

	public Message(String username, String content, Date createtime, String ip,
			int hit) {
		super();
		this.username = username;
		this.content = content;
		this.createtime = createtime;
		this.ip = ip;
		this.hit = hit;
	}

	public Message(int id, String username, String content, Date createtime,
			String ip, int hit) {
		super();
		this.id = id;
		this.username = username;
		this.content = content;
		this.createtime = createtime;
		this.ip = ip;
		this.hit = hit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", username=" + username + ", content="
				+ content + ", createtime=" + createtime + ", ip=" + ip
				+ ", hit=" + hit + "]";
	}
	
	public static void main(String[] args) {
		
		Message msg = new Message(1,"tom","你好",new Date(),"127.0.0.1",17);
		System.out.println(msg);
	}
	
}
