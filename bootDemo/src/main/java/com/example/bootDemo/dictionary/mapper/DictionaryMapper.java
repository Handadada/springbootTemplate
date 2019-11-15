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
}
