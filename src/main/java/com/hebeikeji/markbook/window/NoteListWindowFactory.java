package com.hebeikeji.markbook.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @description: some desc
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 16:26
 */


public class NoteListWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

        //创建出NoteListWindow对象
        NoteListWindow noteListWindow = new NoteListWindow(project, toolWindow);
        //获取工厂的实例
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        //获取用于toolWindow显示的内容
        Content content =  contentFactory.createContent(noteListWindow.getjContent(),"",false);
        //给toolWiondow设置内容
        toolWindow.getContentManager().addContent(content);
    }
}

