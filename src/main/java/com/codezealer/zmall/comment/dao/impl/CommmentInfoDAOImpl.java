package com.codezealer.zmall.comment.dao.impl;

import com.codezealer.zmall.comment.dao.CommentInfoDAO;
import com.codezealer.zmall.comment.entity.CommentInfo;
import com.codezealer.zmall.comment.mapper.CommentInfoMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class CommmentInfoDAOImpl implements CommentInfoDAO {

    @Resource
    CommentInfoMapper commentInfoMapper;

    @Override
    public boolean saveCommentInfo(CommentInfo commentInfo) {
        return commentInfoMapper.insert(commentInfo) > 0;
    }
}
