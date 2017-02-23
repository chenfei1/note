package org.sgs.note.dao;

import java.util.List;

import org.sgs.note.entiy.NoteBook;

public interface NoteBookDao {
	public List<NoteBook> findByUser(String userId);
}
