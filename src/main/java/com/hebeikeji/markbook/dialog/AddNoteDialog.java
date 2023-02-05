package com.hebeikeji.markbook.dialog;

import com.hebeikeji.markbook.data.DataCenter;
import com.hebeikeji.markbook.data.DataConvert;
import com.hebeikeji.markbook.data.NoteData;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @description: some desc
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 15:29
 */



public class AddNoteDialog extends DialogWrapper {
    //标题的输入框
    private EditorTextField etfTitle;
    //内容的输入框
    private EditorTextField etfMark;


    public AddNoteDialog() {
        super(true);
        init();
        setTitle("添加笔记注释");
    }
    @Override
    protected @Nullable JComponent createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton button = new JButton("添加到笔记列表");

        //
        button.addActionListener(e ->{
            //获取标题
            String title = etfTitle.getText();
            //获取内容
            String mark = etfMark.getText();
            String fileType = DataCenter.CURRENT_FILE_NAME.substring(
                    DataCenter.CURRENT_FILE_NAME.lastIndexOf(".") + 1);
            NoteData noteData = new NoteData(title, mark, DataCenter.SELECTED_TEXT, DataCenter.CURRENT_FILE_NAME, fileType);
            DataCenter.NOTE_LIST.add(noteData);

            //将noteData的数据转成String数组，出入addRow方法
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
        });
        panel.add(button);
        return panel;
    }




    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
          etfTitle = new EditorTextField("笔记标题");
          etfMark = new EditorTextField("笔记的内容");
          panel.add(etfTitle,BorderLayout.NORTH);
          panel.add(etfMark,BorderLayout.CENTER);
          return panel;
    }


}
