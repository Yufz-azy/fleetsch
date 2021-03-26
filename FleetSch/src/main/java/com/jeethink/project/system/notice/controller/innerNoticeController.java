package com.jeethink.project.system.notice.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeethink.framework.aspectj.lang.annotation.Log;
import com.jeethink.framework.aspectj.lang.enums.BusinessType;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.framework.web.page.TableDataInfo;
import com.jeethink.project.system.notice.domain.innerNotice;
import com.jeethink.project.system.notice.service.IinnerNoticeService;

/**
 * 公告 信息操作处理
 *
 * @author jeethink www.jeethink.vip
 */
@Controller
@RequestMapping("/system/inner_notice")
public class innerNoticeController extends BaseController
{
    private String prefix = "system/inner_notice";

    @Autowired
    private IinnerNoticeService IinnernoticeService;

    @RequiresPermissions("system:inner_notice:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/inner_notice";
    }

    /**
     * 查询公告列表
     */
    @RequiresPermissions("system:inner_notice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(innerNotice innernotice)
    {
        startPage();
        List<innerNotice> list = IinnernoticeService.selectInnerNoticeList(innernotice);
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
    @RequiresPermissions("system:inner_notice:add")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(innerNotice innernotice)
    {
        return toAjax(IinnernoticeService.insertInnerNotice(innernotice));
    }

    /**
     * 查看公告
     */
    @GetMapping("/detail/{noticeId}")
    public String detail(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("inner_notice", IinnernoticeService.selectInnerNoticeById(noticeId));
        return prefix + "/detail";
    }

    /**
     * 修改公告
     */
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("inner_notice", IinnernoticeService.selectInnerNoticeById(noticeId));
        return prefix + "/edit";
    }

    /**
     * 修改保存公告
     */
    @RequiresPermissions("system:inner_notice:edit")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(innerNotice innernotice)
    {
        return toAjax(IinnernoticeService.updateInnerNotice(innernotice));
    }

    /**
     * 删除公告
     */
    @RequiresPermissions("system:inner_notice:remove")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(IinnernoticeService.deleteInnerNoticeByIds(ids));
    }
}
