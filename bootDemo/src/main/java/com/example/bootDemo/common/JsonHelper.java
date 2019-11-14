package com.example.bootDemo.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;


public class JsonHelper {


    public final static ObjectMapper MAPPER = Jackson2ObjectMapperBuilder.json().build();


}
