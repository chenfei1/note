package org.sgs.note.controller.notebook;

import javax.annotation.Resource;

import org.sgs.note.entiy.NoteResult;
import org.sgs.note.service.NoteBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/notebook")
public class LoadBooksController {
	@Resource
	private NoteBookService bookService;
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult execute(String userId){
		
		NoteResult result = bookService.loadBooks(userId);
		return result;
	}
}
