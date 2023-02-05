package com.hebeikeji.markbook.processor;

import com.hebeikeji.markbook.data.NoteData;

import java.util.List;

/**
 * @description: some desc
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 18:02
 */


public interface SourceNoteData {
    public String getFileName();
    public String getTopic();
    public List<NoteData> getNoteList();

}
