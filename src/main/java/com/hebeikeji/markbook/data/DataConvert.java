package com.hebeikeji.markbook.data;

/**
 * @description: some desc
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 17:44
 */


public class DataConvert {
    public static String[] convert(NoteData noteData){
        String[] raw = new String[4];
        raw[0] = noteData.getTitle();
        raw[1] = noteData.getMark();
        raw[2] = noteData.getFileName();
        raw[3] = noteData.getContent();
        return raw;

    }
}
