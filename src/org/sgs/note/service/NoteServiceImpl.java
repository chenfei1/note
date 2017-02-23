package org.sgs.note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.sgs.note.dao.NoteDao;
import org.sgs.note.entiy.Note;
import org.sgs.note.entiy.NoteResult;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService{
	@Resource
	private NoteDao noteDao;
	
	public NoteResult loadNotes(String bookId){
		List<Map> list = noteDao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(list);
		return result;
		
	}
}
