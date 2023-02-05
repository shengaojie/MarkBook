package com.hebeikeji.markbook.processor;

import com.google.common.io.FileBackedOutputStream;
import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.codehaus.groovy.runtime.StringBufferWriter;

import java.io.*;
import java.util.HashMap;

/**
 * @description: some desc
 * @author: shengaojie
 * @email: xxx@xx.com
 * @date: 2023/2/5 18:44
 */


public class MDFreeMarkProcessor extends AbstractFreeMarkProcessor {

    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        HashMap model = new HashMap();
        model.put("topic",sourceNoteData.getTopic());
        model.put("noteList",sourceNoteData.getNoteList());
        return model;
    }

    @Override
    protected Template getTemplete() throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        String templateContent = UrlUtil.loadText(MDFreeMarkProcessor.class.getResource("/template/md.ftl"));
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
       stringTemplateLoader.putTemplate("MDTemplate",templateContent);
       configuration.setTemplateLoader(stringTemplateLoader);
       return configuration.getTemplate("MDTemplate");

    }

    @Override
    protected Writer getWirter(SourceNoteData sourceNoteData) throws FileNotFoundException, UnsupportedEncodingException {
        String fileName = sourceNoteData.getFileName();
        File file = new File(fileName);
        BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
        return bufferWriter;
    }


}
