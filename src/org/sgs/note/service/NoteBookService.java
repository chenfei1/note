package org.sgs.note.service;

import org.sgs.note.entiy.NoteResult;

public interface NoteBookService {
	public NoteResult loadBooks(String userId);
}
