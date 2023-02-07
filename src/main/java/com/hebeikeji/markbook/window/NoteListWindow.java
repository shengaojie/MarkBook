package com.hebeikeji.markbook.window;

import com.hebeikeji.markbook.data.DataCenter;
import com.hebeikeji.markbook.processor.DefaultSourceNoteData;
import com.hebeikeji.markbook.processor.MDFreeMarkProcessor;
import com.hebeikeji.markbook.processor.Processor;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @description: some desc
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 15:56
 */

public class NoteListWindow {
    private JPanel jContent;
    private JTextField tfTopic;
    private JTable tbContent;
    private JButton btCreate;
    private JButton btClear;
    private JButton btClose;

    public JPanel getjContent() {
        return jContent;
    }

    //右侧笔记列表的初始化
    public void init(){
        tbContent.setModel(DataCenter.TABLE_MODEL);
        tbContent.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        //在构造方法中调用init()
        init();

        /*
        * 生成文档按钮
        * */
        btCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topicText = tfTopic.getText();
                String fileName = topicText + ".md";
                if(topicText == null || "".equals(topicText)){
                    MessageDialogBuilder.yesNo("操作结果","文档标题没有输入").show();
                    return;
                }

                //不为空的话，我们需要打开保存目录
               VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFileDescriptor(),
                                            project,project.getBaseDir());
                //这里我们可能没有选择保存目录
                if(virtualFile != null){
                    String path = virtualFile.getPath();
                    String fileFullPath = path + File.separator + fileName;
                    Processor processor = new MDFreeMarkProcessor();
                    try{
                        processor.process(new DefaultSourceNoteData(fileFullPath,topicText,DataCenter.NOTE_LIST));
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        });
        /*
        * 清除列表按钮
        * */
        btClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.reset();
            }
        });

        /*
        * 关闭按钮
        * */
        btClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);
            }
        });
    }
}
