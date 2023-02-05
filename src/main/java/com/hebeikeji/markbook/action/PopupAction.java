package com.hebeikeji.markbook.action;

import com.hebeikeji.markbook.data.DataCenter;
import com.hebeikeji.markbook.dialog.AddNoteDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        //获取当前的编辑器对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        //获取选择的数据模型
        SelectionModel selectionModel = editor.getSelectionModel();
        //获取当前的文本内容
        String selectedText = selectionModel.getSelectedText();



        //获取选择的内容，文件名称，文件类型存储到全局变量
        DataCenter.SELECTED_TEXT = selectedText;
        DataCenter.CURRENT_FILE_NAME =  e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().
                                                getVirtualFile().getName();
        DataCenter.CURRENT_FILE_TYPE = DataCenter.CURRENT_FILE_NAME.substring(DataCenter.
                                                 CURRENT_FILE_NAME.lastIndexOf(".") + 1);

        AddNoteDialog addNoteDialog = new AddNoteDialog();
        addNoteDialog.show();
    }
}
