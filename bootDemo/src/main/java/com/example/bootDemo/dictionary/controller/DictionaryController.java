package com.example.bootDemo.dictionary.controller;

import com.example.bootDemo.dictionary.model.DictionaryData;
import com.example.bootDemo.dictionary.model.DictionaryType;
import com.example.bootDemo.dictionary.service.DictionaryService;
import com.example.bootDemo.dictionary.vo.DictionaryResponseVO;
import com.example.bootDemo.dictionary.vo.DictionarySearchVO;
import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-15 15:46
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    //获取字典类别
    @RequestMapping("/listType")
    public ResponseVO getDictionaryTypeList(DictionarySearchVO vo){
        try {
            DictionaryResponseVO<DictionaryType> data =  dictionaryService.getDictionaryTypeList(vo);
            return ResponseVO.success(data);
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

    //字典详情列表
    @RequestMapping("/listData")
    public ResponseVO getDictionaryDataList(DictionarySearchVO vo){
        try {
            DictionaryResponseVO<DictionaryData> data =  dictionaryService.getDictionaryDataList(vo);
            return ResponseVO.success(data);
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }


}