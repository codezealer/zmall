package com.codezealer.zmall.comment.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.comment.dao.CommentAggregateDAO;
import com.codezealer.zmall.comment.entity.CommentAggregate;
import com.codezealer.zmall.comment.mapper.CommentAggregateMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class CommentAggregateDAOImpl implements CommentAggregateDAO {

    @Resource
    CommentAggregateMapper commentAggregateMapper;

    @Override
    public CommentAggregate selectByGoodsId(Long goodsId) {
        return commentAggregateMapper.selectOne(new LambdaQueryWrapper<CommentAggregate>().eq(CommentAggregate::getGoodsId, goodsId));
    }

    @Override
    public void saveOrUpdate(CommentAggregate commentAggregate) {
        if (commentAggregate.getId() != null) {
            commentAggregateMapper.updateById(commentAggregate);
        } else {
            commentAggregateMapper.insert(commentAggregate);
        }
    }

}
