package com.jeethink.project.system.notice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeethink.common.utils.security.ShiroUtils;
import com.jeethink.common.utils.text.Convert;
import com.jeethink.project.system.notice.domain.innerNotice;
import com.jeethink.project.system.notice.mapper.innerNoticeMapper;

/**
 * 公告 服务层实现
 *
 * @author jeethink www.jeethink.vip
 * @date 2018-06-25
 */
@Service
public class innerNoticeServiceImpl implements IinnerNoticeService
{
    @Autowired
    private innerNoticeMapper innernoticeMapper;

    /**
     * 查询公告信息
     *
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
    public innerNotice selectInnerNoticeById(Long noticeId)
    {
        return innernoticeMapper.selectInnerNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     *
     * @param innernotice 公告信息
     * @return 公告集合
     */
    @Override
    public List<innerNotice> selectInnerNoticeList(innerNotice innernotice)
    {
        return innernoticeMapper.selectInnerNoticeList(innernotice);
    }

    /**
     * 新增公告
     *
     * @param innernotice 公告信息
     * @return 结果
     */
    @Override
    public int insertInnerNotice(innerNotice innernotice)
    {
        innernotice.setCreateBy(ShiroUtils.getLoginName());
        return innernoticeMapper.insertInnerNotice(innernotice);
    }

    /**
     * 修改公告
     *
     * @param innernotice 公告信息
     * @return 结果
     */
    @Override
    public int updateInnerNotice(innerNotice innernotice)
    {
        innernotice.setUpdateBy(ShiroUtils.getLoginName());
        return innernoticeMapper.updateInnerNotice(innernotice);
    }

    /**
     * 删除公告对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInnerNoticeByIds(String ids)
    {
        return innernoticeMapper.deleteInnerNoticeByIds(Convert.toStrArray(ids));
    }
}

