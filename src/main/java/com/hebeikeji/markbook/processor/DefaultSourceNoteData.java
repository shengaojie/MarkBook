package com.hebeikeji.markbook.processor;

import com.hebeikeji.markbook.data.NoteData;

import java.util.List;

/**
 * @description: some desc
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 19:04
 */


public class DefaultSourceNoteData implements SourceNoteData{
    private String fileName;
    private String topic;
    private List<NoteData> noteList;

    public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteList = noteList;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<NoteData> getNoteList() {
        return noteList;
    }
}
