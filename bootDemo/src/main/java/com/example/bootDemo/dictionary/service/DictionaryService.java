package com.example.bootDemo.dictionary.service;

import com.example.bootDemo.dictionary.mapper.DictionaryMapper;
import com.example.bootDemo.dictionary.model.DictionaryData;
import com.example.bootDemo.dictionary.model.DictionaryType;
import com.example.bootDemo.response.PageResponseVO;
import com.example.bootDemo.dictionary.vo.DictionarySearchVO;
import com.example.bootDemo.enums.ErrorEnum;
import com.example.bootDemo.exception.ProjectException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-15 15:46
 */
@Service
public class DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;


    public PageResponseVO<DictionaryType> getDictionaryTypeList(DictionarySearchVO vo) {
        PageResponseVO<DictionaryType> response = new PageResponseVO<>();
        //校正数据
        if (vo.getPageNo() < 1) {
            vo.setPageNo(1);
        }
        if (vo.getPageSize() < 1) {
            vo.setPageSize(15);
        }
        vo.setStartRow((vo.getPageNo() - 1) * vo.getPageSize());

        int count = dictionaryMapper.getDictionaryTypeCount(vo);
        int pages = 0;
        if (count > 0) {
            pages = count % 15 == 0 ? count / 15 : count / 15 + 1;
        }
        List<DictionaryType> list = dictionaryMapper.getDictionaryTypeList(vo);
        response.setPageNo(vo.getPageNo());
        response.setPageSize(vo.getPageSize());
        response.setCount(count);
        response.setPages(pages);
        response.setList(list);

        return response;
    }

    public PageResponseVO<DictionaryData> getDictionaryDataList(DictionarySearchVO vo) {
        if (null == vo.getTypeId()) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        PageResponseVO<DictionaryData> response = new PageResponseVO<>();
        //校正数据
        if (vo.getPageNo() < 1) {
            vo.setPageNo(1);
        }
        if (vo.getPageSize() < 1) {
            vo.setPageSize(15);
        }
        vo.setStartRow((vo.getPageNo() - 1) * vo.getPageSize());

        int count = dictionaryMapper.getDictionaryDataCount(vo);
        int pages = 0;
        if (count > 0) {
            pages = count % 15 == 0 ? count / 15 : count / 15 + 1;
        }
        List<DictionaryData> list = dictionaryMapper.getDictionaryDataList(vo);
        response.setPageNo(vo.getPageNo());
        response.setPageSize(vo.getPageSize());
        response.setCount(count);
        response.setPages(pages);
        response.setList(list);

        return response;
    }

    public void addType(DictionaryType dictionaryType) {
        if (StringUtils.isBlank(dictionaryType.getTypeDesc()) || StringUtils.isBlank(dictionaryType.getCode())) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        dictionaryMapper.addType(dictionaryType);
    }


    public void updateType(DictionaryType dictionaryType) {
        if (dictionaryType == null || dictionaryType.getId() == null) {
            throw new ProjectException(ErrorEnum.ID_NOT_EXIT);
        }
        dictionaryMapper.updateType(dictionaryType);
    }

    public void deleteType(Integer typeId) {
        if (typeId == null) {
            throw new ProjectException(ErrorEnum.ID_NOT_EXIT);
        }
        dictionaryMapper.deleteType(typeId);
    }

    public void addData(DictionaryData dictionaryData) {
        if (dictionaryData == null || dictionaryData.getDataDesc() == null || "".equals(dictionaryData.getDataDesc())) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        if (dictionaryData.getParentId() == null) {
            throw new ProjectException(ErrorEnum.ID_NOT_EXIT);
        }
        Integer flag = dictionaryMapper.addData(dictionaryData);
        if (null != flag && flag == 1) {
            dictionaryMapper.addtypeDate(dictionaryData);
        }
    }

    public void updateData(DictionaryData dictionaryData) {
        if (dictionaryData == null || dictionaryData.getId() == null) {
            throw new ProjectException(ErrorEnum.ID_NOT_EXIT);
        }
        dictionaryMapper.updateData(dictionaryData);
    }

    public void deleteData(Integer dataId) {
        if (null == dataId) {
            throw new ProjectException(ErrorEnum.ID_NOT_EXIT);
        }
        Integer flag = dictionaryMapper.deleteData(dataId);
        if (null != flag || flag == 1) {
            dictionaryMapper.deleteTypeDate(dataId);
        }
    }
}