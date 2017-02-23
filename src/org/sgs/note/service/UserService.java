package org.sgs.note.service;

import org.sgs.note.entiy.NoteResult;

public interface UserService {
	public NoteResult checkLogin(String name,String pwd)throws Exception;
	public NoteResult regist(String name,String password,String nickname)throws Exception;
}
