package com.codezealer.zmall.comment.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codezealer.zmall.comment.entity.CommentInfo;
import com.codezealer.zmall.comment.query.CommentInfoQuery;
import com.codezealer.zmall.common.page.PageRequest;

public interface CommentInfoDAO {
    boolean saveCommentInfo(CommentInfo commentInfo);

    Page<CommentInfo> listPage(PageRequest<CommentInfoQuery> pageRequest);
}
