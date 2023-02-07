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
 * @description: 点击完添加笔记之后，弹出的对话框
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
        //对话框的标题
        setTitle("添加笔记注释");
    }

    /*
    * 添加最下面的panel，点击之后会将笔记标题和笔记的内容，
    * 以及DataCenter中的信息组合成一个NoteData对象。并且
    * 加入到DataCenter中的NOTE_LIST中去。并且将该NoteData
    * 对象加入到右侧的TABLE中去。
    * */
    @Override
    protected @Nullable JComponent createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton button = new JButton("添加到笔记列表");

        //点击添加到笔记列表的按钮之后
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



    /*
    * 设置中间的panel，panel中嵌入了两个输入框。
    * BorderLayOut.NORTH 和 BorderLayOut.CENTER是两种
    * 排布的方式
    * */
    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
          etfTitle = new EditorTextField("笔记标题");
          etfMark = new EditorTextField("笔记的内容");
          etfMark.setPreferredSize(new Dimension(200,100));
          panel.add(etfTitle,BorderLayout.NORTH);
          panel.add(etfMark,BorderLayout.CENTER);
          return panel;
    }


}
