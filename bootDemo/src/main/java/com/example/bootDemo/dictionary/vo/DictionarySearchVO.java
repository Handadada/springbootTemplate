package com.example.bootDemo.dictionary.vo;

import lombok.Data;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-15 15:55
 */
@Data
public class DictionarySearchVO {

    private Integer typeId;

    /**
     * 分页数据
     */
    private Integer pageNo;

    private Integer startRow;

    private Integer pageSize;

}