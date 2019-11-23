package com.example.bootDemo.dictionary.controller;

import com.example.bootDemo.dictionary.model.DictionaryData;
import com.example.bootDemo.dictionary.model.DictionaryType;
import com.example.bootDemo.dictionary.service.DictionaryService;
import com.example.bootDemo.dictionary.vo.DictionarySearchVO;
import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.response.PageResponseVO;
import com.example.bootDemo.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseVO getDictionaryTypeList(@RequestBody DictionarySearchVO vo) {
        try {
            PageResponseVO<DictionaryType> data = dictionaryService.getDictionaryTypeList(vo);
            return ResponseVO.success(data);
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

    //字典详情列表
    @RequestMapping("/listData")
    public ResponseVO getDictionaryDataList(@RequestBody DictionarySearchVO vo) {
        try {
            PageResponseVO<DictionaryData> data = dictionaryService.getDictionaryDataList(vo);
            return ResponseVO.success(data);
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

    //添加字典类别
    @RequestMapping("/addType")
    public ResponseVO addType(@RequestBody DictionaryType DictionaryType) {
        try {
            dictionaryService.addType(DictionaryType);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

    //修改字典类型
    @RequestMapping("/updateType")
    public ResponseVO updateType(@RequestBody DictionaryType DictionaryType) {
        try {
            dictionaryService.updateType(DictionaryType);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

    //删除字典类型
    @RequestMapping("/deleteType")
    public ResponseVO deleteType(Integer typeId) {
        try {
            dictionaryService.deleteType(typeId);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

    //添加字典详情类别
    @RequestMapping("/addData")
    public ResponseVO addData(@RequestBody DictionaryData dictionaryData) {
        try {
            dictionaryService.addData(dictionaryData);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

    //修改字典详情类型
    @RequestMapping("/updateData")
    public ResponseVO updateData(@RequestBody DictionaryData dictionaryData) {
        try {
            dictionaryService.updateData(dictionaryData);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

    //删除字典详情类型
    @RequestMapping("/deleteData")
    public ResponseVO deleteData(Integer dataId) {
        try {
            dictionaryService.deleteData(dataId);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }


}