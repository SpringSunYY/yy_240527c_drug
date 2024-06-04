package com.yy.system.service.impl;

import java.util.List;

import com.yy.common.utils.DateUtils;
import com.yy.common.utils.SecurityUtils;
import com.yy.common.utils.StringUtils;
import com.yy.system.domain.DrugInfo;
import com.yy.system.service.IDrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yy.system.mapper.SymptomInfoMapper;
import com.yy.system.domain.SymptomInfo;
import com.yy.system.service.ISymptomInfoService;

/**
 * 症状信息Service业务层处理
 *
 * @author YY
 * @date 2024-06-04
 */
@Service
public class SymptomInfoServiceImpl implements ISymptomInfoService {
    @Autowired
    private SymptomInfoMapper symptomInfoMapper;

    @Autowired
    private IDrugInfoService drugInfoService;

    /**
     * 查询症状信息
     *
     * @param id 症状信息主键
     * @return 症状信息
     */
    @Override
    public SymptomInfo selectSymptomInfoById(Long id) {
        return symptomInfoMapper.selectSymptomInfoById(id);
    }

    /**
     * 查询症状信息列表
     *
     * @param symptomInfo 症状信息
     * @return 症状信息
     */
    @Override
    public List<SymptomInfo> selectSymptomInfoList(SymptomInfo symptomInfo) {
        List<SymptomInfo> symptomInfos = symptomInfoMapper.selectSymptomInfoList(symptomInfo);
        for (SymptomInfo info : symptomInfos) {
            DrugInfo drugInfo = drugInfoService.selectDrugInfoById(info.getDrugId());
            if (StringUtils.isNotNull(drugInfo)) {
                info.setDrugName(drugInfo.getName());
            }
        }
        return symptomInfos;
    }

    /**
     * 新增症状信息
     *
     * @param symptomInfo 症状信息
     * @return 结果
     */
    @Override
    public int insertSymptomInfo(SymptomInfo symptomInfo) {
        symptomInfo.setCreateBy(SecurityUtils.getUsername());
        symptomInfo.setCreateTime(DateUtils.getNowDate());
        return symptomInfoMapper.insertSymptomInfo(symptomInfo);
    }

    /**
     * 修改症状信息
     *
     * @param symptomInfo 症状信息
     * @return 结果
     */
    @Override
    public int updateSymptomInfo(SymptomInfo symptomInfo) {
        symptomInfo.setUpdateTime(DateUtils.getNowDate());
        return symptomInfoMapper.updateSymptomInfo(symptomInfo);
    }

    /**
     * 批量删除症状信息
     *
     * @param ids 需要删除的症状信息主键
     * @return 结果
     */
    @Override
    public int deleteSymptomInfoByIds(Long[] ids) {
        return symptomInfoMapper.deleteSymptomInfoByIds(ids);
    }

    /**
     * 删除症状信息信息
     *
     * @param id 症状信息主键
     * @return 结果
     */
    @Override
    public int deleteSymptomInfoById(Long id) {
        return symptomInfoMapper.deleteSymptomInfoById(id);
    }
}
