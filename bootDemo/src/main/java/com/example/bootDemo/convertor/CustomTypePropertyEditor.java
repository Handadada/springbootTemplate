package com.example.bootDemo.convertor;


import com.example.bootDemo.common.JsonHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

/**
 * 2018/8/29  15:22  xutao1@mail.haoyisheng.com
 */

public class CustomTypePropertyEditor extends PropertyEditorSupport {

    public final static ObjectMapper MAPPER = Jackson2ObjectMapperBuilder.json().build();
    private TypeReference reference;

    public CustomTypePropertyEditor(TypeReference reference) {
        this.reference = reference;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Object value = JsonHelper.MAPPER.readValue(text, reference);
            setValue(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
