package com.hebeikeji.markbook.processor;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * @description: some desc
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 18:29
 */


public abstract class AbstractFreeMarkProcessor implements Processor{
    protected abstract Object getModel(SourceNoteData sourceNoteData);

    protected  abstract Template getTemplete() throws IOException;

    protected abstract Writer getWirter(SourceNoteData SourceNoteData) throws FileNotFoundException, UnsupportedEncodingException;
    //处理的流程固定,模板设计模式
    @Override
    public final void process(SourceNoteData sourceNoteData) throws TemplateException, IOException {
        Template templete = getTemplete();
        Object model = getModel(sourceNoteData);
        Writer writer = getWirter(sourceNoteData);
        templete.process(model,writer);

    }
}
