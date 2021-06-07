package com.codezealer.zmall.comment.service;

import com.codezealer.zmall.comment.dto.CommentInfoDTO;
import com.codezealer.zmall.comment.entity.CommentInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codezealer.zmall.comment.query.CommentInfoQuery;
import com.codezealer.zmall.common.page.PageRequest;
import com.codezealer.zmall.common.page.PageResult;

/**
 * <p>
 * 评论信息表 服务类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-18
 */
public interface CommentInfoService extends IService<CommentInfo> {

    CommentInfoDTO saveCommentInfo(CommentInfoDTO commentInfoDTO);

    PageResult<CommentInfoDTO> selectPage(PageRequest<CommentInfoQuery> queryPageRequest);
}
