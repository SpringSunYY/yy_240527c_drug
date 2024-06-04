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
import com.yy.system.domain.DrugInfo;
import com.yy.system.service.IDrugInfoService;
import com.yy.common.utils.poi.ExcelUtil;
import com.yy.common.core.page.TableDataInfo;

/**
 * 药物信息Controller
 * 
 * @author YY
 * @date 2024-06-04
 */
@RestController
@RequestMapping("/manage/drugInfo")
public class DrugInfoController extends BaseController
{
    @Autowired
    private IDrugInfoService drugInfoService;

    /**
     * 查询药物信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:drugInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(DrugInfo drugInfo)
    {
        startPage();
        List<DrugInfo> list = drugInfoService.selectDrugInfoList(drugInfo);
        return getDataTable(list);
    }

    /**
     * 导出药物信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:drugInfo:export')")
    @Log(title = "药物信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DrugInfo drugInfo)
    {
        List<DrugInfo> list = drugInfoService.selectDrugInfoList(drugInfo);
        ExcelUtil<DrugInfo> util = new ExcelUtil<DrugInfo>(DrugInfo.class);
        util.exportExcel(response, list, "药物信息数据");
    }

    /**
     * 获取药物信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:drugInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(drugInfoService.selectDrugInfoById(id));
    }

    /**
     * 新增药物信息
     */
    @PreAuthorize("@ss.hasPermi('manage:drugInfo:add')")
    @Log(title = "药物信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DrugInfo drugInfo)
    {
        return toAjax(drugInfoService.insertDrugInfo(drugInfo));
    }

    /**
     * 修改药物信息
     */
    @PreAuthorize("@ss.hasPermi('manage:drugInfo:edit')")
    @Log(title = "药物信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DrugInfo drugInfo)
    {
        return toAjax(drugInfoService.updateDrugInfo(drugInfo));
    }

    /**
     * 删除药物信息
     */
    @PreAuthorize("@ss.hasPermi('manage:drugInfo:remove')")
    @Log(title = "药物信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(drugInfoService.deleteDrugInfoByIds(ids));
    }
}
