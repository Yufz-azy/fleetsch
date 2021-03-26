package com.jeethink.project.system.texorder.controller;

import com.jeethink.framework.aspectj.lang.annotation.Log;
import com.jeethink.framework.aspectj.lang.enums.BusinessType;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.framework.web.page.TableDataInfo;
import com.jeethink.project.system.texorder.domain.Oil;
import com.jeethink.project.system.texorder.service.OilService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告 信息操作处理
 * 
 * @author jeethink www.jeethink.vip
 */
@Controller
@RequestMapping("/system/oil")
public class OilController extends BaseController
{
    private String prefix = "system/oil";

    @Autowired
    private OilService noticeService;

    @RequiresPermissions("system:oil:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/oil";
    }

    /**
     * 查询公告列表
     */
    @RequiresPermissions("system:oil:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Oil notice)
    {
        startPage();
        List<Oil> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 新增公告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公告
     */
    @RequiresPermissions("system:oil:add")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Oil notice)
    {
        return toAjax(noticeService.insertNotice(notice));
    }
    
    /**
     * 查看公告
     */
    @GetMapping("/detail/{noticeId}")
    public String detail(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("oil", noticeService.selectNoticeById(noticeId));
        return prefix + "/detail";
    }

    /**
     * 修改公告
     */
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("oil", noticeService.selectNoticeById(noticeId));
        return prefix + "/edit";
    }

    /**
     * 修改保存公告
     */
    @RequiresPermissions("system:oil:edit")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Oil notice)
    {
        return toAjax(noticeService.updateNotice(notice));
    }

    /**
     * 删除公告
     */
    @RequiresPermissions("system:oil:remove")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(noticeService.deleteNoticeByIds(ids));
    }
}
