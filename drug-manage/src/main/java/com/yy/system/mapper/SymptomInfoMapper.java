package com.yy.system.mapper;

import java.util.List;
import com.yy.system.domain.SymptomInfo;

/**
 * 症状信息Mapper接口
 * 
 * @author YY
 * @date 2024-06-04
 */
public interface SymptomInfoMapper 
{
    /**
     * 查询症状信息
     * 
     * @param id 症状信息主键
     * @return 症状信息
     */
    public SymptomInfo selectSymptomInfoById(Long id);

    /**
     * 查询症状信息列表
     * 
     * @param symptomInfo 症状信息
     * @return 症状信息集合
     */
    public List<SymptomInfo> selectSymptomInfoList(SymptomInfo symptomInfo);

    /**
     * 新增症状信息
     * 
     * @param symptomInfo 症状信息
     * @return 结果
     */
    public int insertSymptomInfo(SymptomInfo symptomInfo);

    /**
     * 修改症状信息
     * 
     * @param symptomInfo 症状信息
     * @return 结果
     */
    public int updateSymptomInfo(SymptomInfo symptomInfo);

    /**
     * 删除症状信息
     * 
     * @param id 症状信息主键
     * @return 结果
     */
    public int deleteSymptomInfoById(Long id);

    /**
     * 批量删除症状信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSymptomInfoByIds(Long[] ids);
}
