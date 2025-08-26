package com.example.demo.annotation;

import com.example.demo.Entity.Address;
import com.example.demo.enums.MaskingType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import java.io.IOException;

public class PiiMaskingSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private final MaskingType maskingType;
    public PiiMaskingSerializer(){
        this.maskingType = MaskingType.GENERIC;
    }

    public PiiMaskingSerializer(MaskingType maskingType) {
        this.maskingType = maskingType;
    }


    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(jsonGenerator == null){
            jsonGenerator.writeNull();
            return;
        }
        switch (maskingType){
            case ID -> jsonGenerator.writeString(maskId(s));
            case GENERIC -> jsonGenerator.writeString(maskDefault(s));
        }
    }
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) {
        if (property != null) {
            MaskPII annotation = property.getAnnotation(MaskPII.class);
            if (annotation != null) {
                return new PiiMaskingSerializer(annotation.type()); // use enum from annotation
            }
        }
        return this;
    }
    private String maskId(String s){
        if(s == null || s.isEmpty()){
            return s;
        }
        int length = s.length();
        if(length <= 2){
            return "*".repeat(length);
        }
        return "*".repeat(length - 2) + s.substring(length - 2);
    }


    private String maskDefault(String s){
        if(s == null || s.isEmpty()){
            return s;
        }
        int length = s.length();
        if(length <= 2){
            return "*".repeat(length);
        }
        return s.charAt(0) + "*".repeat(length - 2) + s.charAt(length - 1);
    }
}
