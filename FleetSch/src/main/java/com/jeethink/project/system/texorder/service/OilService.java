package com.jeethink.project.system.texorder.service;

import com.jeethink.project.system.texorder.domain.Oil;

import java.util.List;

/**
 * 公告 服务层
 * 
 * @author jeethink www.jeethink.vip
 */
public interface OilService
{
    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public Oil selectNoticeById(Long noticeId);

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    public List<Oil> selectNoticeList(Oil notice);

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int insertNotice(Oil notice);

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(Oil notice);

    /**
     * 删除公告信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String ids);
}
