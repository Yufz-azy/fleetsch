package com.jeethink.project.system.textorder.controller;

import com.jeethink.framework.aspectj.lang.annotation.Log;
import com.jeethink.framework.aspectj.lang.enums.BusinessType;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.framework.web.page.TableDataInfo;
import com.jeethink.project.system.textorder.domain.Dis;
import com.jeethink.project.system.textorder.service.DisService;
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
@RequestMapping("/system/dis")
public class DisController extends BaseController
{
    private String prefix = "system/dis";

    @Autowired
    private DisService noticeService;

    @RequiresPermissions("system:dis:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/dis";
    }

    /**
     * 查询公告列表
     */
    @RequiresPermissions("system:dis:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dis notice)
    {
        startPage();
        List<Dis> list = noticeService.selectNoticeList(notice);
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
    @RequiresPermissions("system:dis:add")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dis notice)
    {
        return toAjax(noticeService.insertNotice(notice));
    }
    
    /**
     * 查看公告
     */
    @GetMapping("/detail/{noticeId}")
    public String detail(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("dis", noticeService.selectNoticeById(noticeId));
        return prefix + "/detail";
    }

    /**
     * 修改公告
     */
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("dis", noticeService.selectNoticeById(noticeId));
        return prefix + "/edit";
    }

    /**
     * 修改保存公告
     */
    @RequiresPermissions("system:dis:edit")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dis notice)
    {
        return toAjax(noticeService.updateNotice(notice));
    }

    /**
     * 删除公告
     */
    @RequiresPermissions("system:dis:remove")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(noticeService.deleteNoticeByIds(ids));
    }
}
