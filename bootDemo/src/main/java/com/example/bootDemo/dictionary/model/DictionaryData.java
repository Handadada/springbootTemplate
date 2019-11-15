package com.example.bootDemo.dictionary.model;

import lombok.Data;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-15 15:35
 */
@Data
public class DictionaryData {

    private Integer id;
    //编码
    private String code;
    //字典名
    private String dataDesc;
    //父id
    private Integer parentId;
    //排序
    private Integer seq;
    //备注
    private String mark;

}