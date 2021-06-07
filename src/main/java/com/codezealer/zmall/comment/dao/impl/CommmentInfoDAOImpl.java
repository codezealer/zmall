package com.codezealer.zmall.comment.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codezealer.zmall.comment.dao.CommentInfoDAO;
import com.codezealer.zmall.comment.entity.CommentInfo;
import com.codezealer.zmall.comment.mapper.CommentInfoMapper;
import com.codezealer.zmall.comment.query.CommentInfoQuery;
import com.codezealer.zmall.common.page.PageRequest;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;

@Repository
public class CommmentInfoDAOImpl implements CommentInfoDAO {

    @Resource
    CommentInfoMapper commentInfoMapper;

    @Override
    public boolean saveCommentInfo(CommentInfo commentInfo) {
        return commentInfoMapper.insert(commentInfo) > 0;
    }

    @Override
    public Page<CommentInfo> listPage(PageRequest<CommentInfoQuery> pageRequest) {
        CommentInfoQuery query = pageRequest.getParam();
        LambdaQueryWrapper<CommentInfo> queryWrapper = createWrapper(query);
        Page<CommentInfo> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        return commentInfoMapper.selectPage(page, queryWrapper);
    }

    private LambdaQueryWrapper<CommentInfo> createWrapper(CommentInfoQuery query) {
        LambdaQueryWrapper<CommentInfo> queryWrapper = Wrappers.lambdaQuery(CommentInfo.class);
        if (query.getCommentStatus() != null) {
            queryWrapper.eq(CommentInfo::getCommentStatus, query.getCommentStatus());
        }
        if (query.getDefaultComment() != null) {
            queryWrapper.eq(CommentInfo::getIsDefaultComment, query.getDefaultComment());
        }
        if (query.getCommentType() != null) {
            queryWrapper.eq(CommentInfo::getCommentType, query.getCommentType());
        }
        if (query.getShowPictures() != null) {
            queryWrapper.eq(CommentInfo::getIsShowPictures, query.getShowPictures());
        }
        if (query.getTotalScore() != null) {
            queryWrapper.eq(CommentInfo::getTotalScore, query.getTotalScore());
        }
        if (query.getStartTime() != null) {
            queryWrapper.gt(CommentInfo::getGmtCreate, query.getStartTime());
        }
        if (query.getEndTime() != null) {
            queryWrapper.lt(CommentInfo::getGmtCreate, query.getEndTime());
        }
        return queryWrapper;
    }
}
