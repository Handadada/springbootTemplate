package com.example.bootDemo.dictionary.model;

import lombok.Data;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-15 15:38
 */
@Data
public class DictionaryType {

    private Integer id;
    //编码
    private String code;
    //字典类型名称
    private String typeDesc;
}