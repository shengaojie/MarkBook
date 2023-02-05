package com.hebeikeji.markbook.data;

/**
 * @description: 用于存放笔记中的字段
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 15:40
 */


public class NoteData {
    //笔记的标题
    private String title;
    //笔记的内容
    private String mark;
    //笔记的源码
    private String content;
    //源码所在的文件名
    private String fileName;
    //源码所在的文件的类型
    private String filetype;

    public NoteData(String title, String mark, String content, String fileName, String filetype) {
        this.title = title;
        this.mark = mark;
        this.content = content;
        this.fileName = fileName;
        this.filetype = filetype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
}
