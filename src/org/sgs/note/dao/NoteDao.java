package org.sgs.note.dao;

import java.util.List;
import java.util.Map;

import org.sgs.note.entiy.Note;

public interface NoteDao {
	public List<Map> findByBookId(String bookId);
}
