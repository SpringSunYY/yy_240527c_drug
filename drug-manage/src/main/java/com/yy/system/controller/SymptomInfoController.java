package com.yy.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yy.common.annotation.Log;
import com.yy.common.core.controller.BaseController;
import com.yy.common.core.domain.AjaxResult;
import com.yy.common.enums.BusinessType;
import com.yy.system.domain.SymptomInfo;
import com.yy.system.service.ISymptomInfoService;
import com.yy.common.utils.poi.ExcelUtil;
import com.yy.common.core.page.TableDataInfo;

/**
 * 症状信息Controller
 * 
 * @author YY
 * @date 2024-06-04
 */
@RestController
@RequestMapping("/manage/symptomInfo")
public class SymptomInfoController extends BaseController
{
    @Autowired
    private ISymptomInfoService symptomInfoService;

    /**
     * 查询症状信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:symptomInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SymptomInfo symptomInfo)
    {
        startPage();
        List<SymptomInfo> list = symptomInfoService.selectSymptomInfoList(symptomInfo);
        return getDataTable(list);
    }

    /**
     * 导出症状信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:symptomInfo:export')")
    @Log(title = "症状信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SymptomInfo symptomInfo)
    {
        List<SymptomInfo> list = symptomInfoService.selectSymptomInfoList(symptomInfo);
        ExcelUtil<SymptomInfo> util = new ExcelUtil<SymptomInfo>(SymptomInfo.class);
        util.exportExcel(response, list, "症状信息数据");
    }

    /**
     * 获取症状信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:symptomInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(symptomInfoService.selectSymptomInfoById(id));
    }

    /**
     * 新增症状信息
     */
    @PreAuthorize("@ss.hasPermi('manage:symptomInfo:add')")
    @Log(title = "症状信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SymptomInfo symptomInfo)
    {
        return toAjax(symptomInfoService.insertSymptomInfo(symptomInfo));
    }

    /**
     * 修改症状信息
     */
    @PreAuthorize("@ss.hasPermi('manage:symptomInfo:edit')")
    @Log(title = "症状信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SymptomInfo symptomInfo)
    {
        return toAjax(symptomInfoService.updateSymptomInfo(symptomInfo));
    }

    /**
     * 删除症状信息
     */
    @PreAuthorize("@ss.hasPermi('manage:symptomInfo:remove')")
    @Log(title = "症状信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(symptomInfoService.deleteSymptomInfoByIds(ids));
    }
}
