package org.sgs.note.dao;

import org.sgs.note.entiy.User;

public interface UserDao {
	public User findByName(String name);
	public int save(User user);
	
}
