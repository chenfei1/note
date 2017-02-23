package org.sgs.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.sgs.note.dao.NoteBookDao;
import org.sgs.note.entiy.NoteBook;
import org.sgs.note.entiy.NoteResult;
import org.springframework.stereotype.Service;
@Service
public class NoteBookServiceImpl implements NoteBookService{
	@Resource
	private NoteBookDao bookDao;
	public NoteResult loadBooks(String userId){
		List<NoteBook> list = bookDao.findByUser(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记本成功");
		result.setData(list);
		return result;
	}
	
}
