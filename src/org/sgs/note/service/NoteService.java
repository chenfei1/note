package org.sgs.note.service;

import org.sgs.note.entiy.NoteResult;

public interface NoteService {
	public NoteResult loadNotes(String bookId);
}
