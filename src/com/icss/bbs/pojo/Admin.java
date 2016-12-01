package com.icss.bbs.pojo;

/**
 *  µÃÂ¿‡
 * 
 * @author Administrator
 * 
 */
public class Admin {

	private int id;

	private String username;

	private String userpwd;

	public Admin() {
		super();
	}

	public Admin(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}

	public Admin(int id, String username, String userpwd) {
		super();
		this.id = id;
		this.username = username;
		this.userpwd = userpwd;
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

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", userpwd="
				+ userpwd + "]";
	}
	
}
