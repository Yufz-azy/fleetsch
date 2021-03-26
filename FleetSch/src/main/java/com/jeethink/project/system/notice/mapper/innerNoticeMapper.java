package com.jeethink.project.system.notice.mapper;

import java.util.List;

import com.jeethink.project.system.notice.domain.innerNotice;

/**
 * 公告 数据层
 *
 * @author jeethink www.jeethink.vip
 */
public interface innerNoticeMapper
{
    /**
     * 查询公告信息
     *
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public innerNotice selectInnerNoticeById(Long noticeId);

    /**
     * 查询公告列表
     *
     * @param innernotice 公告信息
     * @return 公告集合
     */
    public List<innerNotice> selectInnerNoticeList(innerNotice innernotice);

    /**
     * 新增公告
     *
     * @param innernotice 公告信息
     * @return 结果
     */
    public int insertInnerNotice(innerNotice innernotice);

    /**
     * 修改公告
     *
     * @param innernotice 公告信息
     * @return 结果
     */
    public int updateInnerNotice(innerNotice innernotice);

    /**
     * 批量删除公告
     *
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteInnerNoticeByIds(String[] noticeIds);
}
