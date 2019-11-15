package com.example.bootDemo.dictionary.service;

import com.example.bootDemo.dictionary.mapper.DictionaryMapper;
import com.example.bootDemo.dictionary.model.DictionaryData;
import com.example.bootDemo.dictionary.model.DictionaryType;
import com.example.bootDemo.dictionary.vo.DictionaryResponseVO;
import com.example.bootDemo.dictionary.vo.DictionarySearchVO;
import com.example.bootDemo.enums.ErrorEnum;
import com.example.bootDemo.exception.ProjectException;
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


    public DictionaryResponseVO<DictionaryType> getDictionaryTypeList(DictionarySearchVO vo) {
        DictionaryResponseVO<DictionaryType> response = new DictionaryResponseVO<>();
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

    public DictionaryResponseVO<DictionaryData> getDictionaryDataList(DictionarySearchVO vo) {
        if (null == vo.getTypeId()) {
            throw  new ProjectException(ErrorEnum.DATA_ERROR);
        }
        DictionaryResponseVO<DictionaryData> response = new DictionaryResponseVO<>();
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
}