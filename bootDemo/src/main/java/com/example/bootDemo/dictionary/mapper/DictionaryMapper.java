package com.example.bootDemo.dictionary.mapper;

import com.example.bootDemo.dictionary.model.DictionaryData;
import com.example.bootDemo.dictionary.model.DictionaryType;
import com.example.bootDemo.dictionary.vo.DictionarySearchVO;

import java.util.List;

public interface DictionaryMapper {
    //字典类别个数
    int getDictionaryTypeCount(DictionarySearchVO vo);

    //字典类别
    List<DictionaryType> getDictionaryTypeList(DictionarySearchVO vo);

    //字典详情个数
    int getDictionaryDataCount(DictionarySearchVO vo);

    //字典详情
    List<DictionaryData> getDictionaryDataList(DictionarySearchVO vo);

    //添加字典类别
    void addType(DictionaryType dictionaryType);

    //修改字典类型
    void updateType(DictionaryType dictionaryType);

    //删除字典类型
    void deleteType(Integer typeId);

    //添加字典详情
    Integer addData(DictionaryData dictionaryData);

    //添加字典类别详情关联
    void addtypeDate(DictionaryData dictionaryData);

    //修改字典详情
    void updateData(DictionaryData dictionaryData);

    //删除字典详情
    Integer deleteData(Integer dataId);

    //删除字典类别详情关联
    void deleteTypeDate(Integer dataId);
}
