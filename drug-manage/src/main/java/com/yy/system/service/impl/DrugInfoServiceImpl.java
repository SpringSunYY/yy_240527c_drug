package com.yy.system.service.impl;

import java.util.List;
import com.yy.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yy.system.mapper.DrugInfoMapper;
import com.yy.system.domain.DrugInfo;
import com.yy.system.service.IDrugInfoService;

/**
 * 药物信息Service业务层处理
 * 
 * @author YY
 * @date 2024-06-04
 */
@Service
public class DrugInfoServiceImpl implements IDrugInfoService 
{
    @Autowired
    private DrugInfoMapper drugInfoMapper;

    /**
     * 查询药物信息
     * 
     * @param id 药物信息主键
     * @return 药物信息
     */
    @Override
    public DrugInfo selectDrugInfoById(Long id)
    {
        return drugInfoMapper.selectDrugInfoById(id);
    }

    /**
     * 查询药物信息列表
     * 
     * @param drugInfo 药物信息
     * @return 药物信息
     */
    @Override
    public List<DrugInfo> selectDrugInfoList(DrugInfo drugInfo)
    {
        return drugInfoMapper.selectDrugInfoList(drugInfo);
    }

    /**
     * 新增药物信息
     * 
     * @param drugInfo 药物信息
     * @return 结果
     */
    @Override
    public int insertDrugInfo(DrugInfo drugInfo)
    {
        drugInfo.setCreateTime(DateUtils.getNowDate());
        return drugInfoMapper.insertDrugInfo(drugInfo);
    }

    /**
     * 修改药物信息
     * 
     * @param drugInfo 药物信息
     * @return 结果
     */
    @Override
    public int updateDrugInfo(DrugInfo drugInfo)
    {
        drugInfo.setUpdateTime(DateUtils.getNowDate());
        return drugInfoMapper.updateDrugInfo(drugInfo);
    }

    /**
     * 批量删除药物信息
     * 
     * @param ids 需要删除的药物信息主键
     * @return 结果
     */
    @Override
    public int deleteDrugInfoByIds(Long[] ids)
    {
        return drugInfoMapper.deleteDrugInfoByIds(ids);
    }

    /**
     * 删除药物信息信息
     * 
     * @param id 药物信息主键
     * @return 结果
     */
    @Override
    public int deleteDrugInfoById(Long id)
    {
        return drugInfoMapper.deleteDrugInfoById(id);
    }
}
