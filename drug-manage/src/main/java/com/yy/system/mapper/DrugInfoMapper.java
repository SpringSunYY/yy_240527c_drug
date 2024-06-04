package com.yy.system.mapper;

import java.util.List;
import com.yy.system.domain.DrugInfo;

/**
 * 药物信息Mapper接口
 * 
 * @author YY
 * @date 2024-06-04
 */
public interface DrugInfoMapper 
{
    /**
     * 查询药物信息
     * 
     * @param id 药物信息主键
     * @return 药物信息
     */
    public DrugInfo selectDrugInfoById(Long id);

    /**
     * 查询药物信息列表
     * 
     * @param drugInfo 药物信息
     * @return 药物信息集合
     */
    public List<DrugInfo> selectDrugInfoList(DrugInfo drugInfo);

    /**
     * 新增药物信息
     * 
     * @param drugInfo 药物信息
     * @return 结果
     */
    public int insertDrugInfo(DrugInfo drugInfo);

    /**
     * 修改药物信息
     * 
     * @param drugInfo 药物信息
     * @return 结果
     */
    public int updateDrugInfo(DrugInfo drugInfo);

    /**
     * 删除药物信息
     * 
     * @param id 药物信息主键
     * @return 结果
     */
    public int deleteDrugInfoById(Long id);

    /**
     * 批量删除药物信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDrugInfoByIds(Long[] ids);
}
