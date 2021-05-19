package com.codezealer.zmall.comment.dao;

import com.codezealer.zmall.comment.entity.CommentAggregate;

public interface CommentAggregateDAO {
    CommentAggregate selectByGoodsId(Long goodsId);

    void saveOrUpdate(CommentAggregate commentAggregate);
}
