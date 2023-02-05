package com.hebeikeji.markbook.data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 存放一些共用的数据信息
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 15:43
 */


public class DataCenter {
    //选择的文本
    public static String SELECTED_TEXT = null;
    //当前文件的名称
    public static String CURRENT_FILE_NAME = null;
    //当前文件的类型
    public static String CURRENT_FILE_TYPE = null;

    public static String[] HEAD = {"标题","备注","文件名","代码段"};
    //data:是table中的数据
    //HEAD:是表头信息
    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null,HEAD);
    //笔记列表集合
    public static List<NoteData> NOTE_LIST = new LinkedList<>();

    public static void reset(){
        NOTE_LIST.clear();
        TABLE_MODEL.setDataVector(null,HEAD);
    }

}
